package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Enum.ProductStatus;
import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.Exceptions.InsufficientQuantityException;
import com.AccioMarket.Ecommerce.Exceptions.ProductNotFoundException;
import com.AccioMarket.Ecommerce.Model.*;
import com.AccioMarket.Ecommerce.Repository.CustomerRepository;
import com.AccioMarket.Ecommerce.Repository.ProductRepository;
import com.AccioMarket.Ecommerce.RequestDTO.OrderRequestDto;
import com.AccioMarket.Ecommerce.ResponseDTO.OrderResponseDto;
import com.AccioMarket.Ecommerce.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    JavaMailSender emailSender;
    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception {
        Customer customer;
        try {
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid Customer Id!!");
        }

        Product product;
        try {
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Invalid Product Id !!");
        }

        if(product.getQuantity() < orderRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not available !!");
        }

        Ordered order = new Ordered();
        order.setTotalCost(orderRequestDto.getRequiredQuantity()*product.getPrice());
        order.setDeliveryCharge(40);

        Card card = customer.getCards().get(0);
        String cardNo = "";

        for (int i = 0; i<card.getCardNo().length()-4; i++){
            cardNo += 'X';
        }
        cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
        order.setCardUsedForPayment(cardNo);


        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setProduct(product);
        item.setOrder(order);
        order.getOrderedItems().add(item);
        order.setCustomer(customer);



        int leftQuantity = product.getQuantity() - orderRequestDto.getRequiredQuantity();
        if(leftQuantity <= 0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }
        product.setQuantity(leftQuantity);

        customer.getOrders().add(order);
        Customer savedCustomer = customerRepository.save(customer);
        Ordered savedOrder = savedCustomer.getOrders().get(savedCustomer.getOrders().size()-1);

        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .productName(product.getProductName())
                .orderDate(order.getOrderDate())
                .quantityOrdered(orderRequestDto.getRequiredQuantity())
                .cardUsedForPayment(cardNo)
                .itemPrice(product.getPrice())
                .totalCost(order.getTotalCost())
                .deliveryCharge(40)
                .build();

        String text = "Congrats your order with total value " + order.getTotalCost() + " has been placed";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendavengers@gmail.com");
        message.setTo(customer.getEmail());
        message.setSubject("Order Placed Notification");
        message.setText(text);
        emailSender.send(message);

        return orderResponseDto;
    }
}
