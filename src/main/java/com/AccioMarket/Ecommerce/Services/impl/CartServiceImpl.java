package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Enum.ProductStatus;
import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.Exceptions.ProductNotFoundException;
import com.AccioMarket.Ecommerce.Model.*;
import com.AccioMarket.Ecommerce.Repository.CustomerRepository;
import com.AccioMarket.Ecommerce.Repository.ProductRepository;
import com.AccioMarket.Ecommerce.RequestDTO.OrderRequestDto;
import com.AccioMarket.Ecommerce.ResponseDTO.OrderResponseDto;
import com.AccioMarket.Ecommerce.Services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    JavaMailSender emailSender;

    @Override
    public String addCart(OrderRequestDto orderRequestDto) throws Exception {
        Customer customer;
        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid Customer id!!!");
        }

        Product product;
        try{

            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Invalid Product Id !!!");
        }

        if(product.getQuantity() < orderRequestDto.getRequiredQuantity()){
            throw new Exception("Sorry! Required quantity not available");
        }

        Cart cart = new Cart();

        int newCost = product.getPrice()*orderRequestDto.getRequiredQuantity() + cart.getCartTotal();
        cart.setCartTotal(newCost);

        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setCart(cart);
        item.setProduct(product);
        cart.getItems().add(item);

        customerRepository.save(customer);

        return "Item has been added to your cart !!";
    }

    @Override
    public List<OrderResponseDto> checkout(int customerId) throws CustomerNotFoundException {
        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid Customer id !!");
        }
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        int totalCost = customer.getCart().getCartTotal();
        Cart cart = customer.getCart();
        for (Item item : cart.getItems()){
            Ordered order = new Ordered();
            order.setTotalCost(item.getRequiredQuantity()*item.getProduct().getPrice());
            order.setDeliveryCharge(0);
            order.setCustomer(customer);
            order.getOrderedItems().add(item);

            Card card = customer.getCards().get(0);
            String cardNo = "";
            for(int i = 0; i<card.getCardNo().length()-4; i++){
                cardNo += 'X';
            }
            cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
            order.setCardUsedForPayment(cardNo);

            int leftQuantity = item.getProduct().getQuantity() - item.getRequiredQuantity();
            if(leftQuantity <= 0){
                item.getProduct().setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
            item.getProduct().setQuantity(leftQuantity);

            customer.getOrders().add(order);

            OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                    .productName(item.getProduct().getProductName())
                    .orderDate(order.getOrderDate())
                    .quantityOrdered(item.getRequiredQuantity())
                    .cardUsedForPayment(cardNo)
                    .itemPrice(item.getProduct().getPrice())
                    .totalCost(order.getTotalCost())
                    .deliveryCharge(0)
                    .build();

            orderResponseDtos.add(orderResponseDto);
        }
        cart.setItems(new ArrayList<>());
        cart.setCartTotal(0);
        customerRepository.save(customer);

        String text = "Congrts your order with total value " + totalCost + " has been placed.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendavengers@gmail.com");
        message.setTo(customer.getEmail());
        message.setSubject("Order Placed from Accio Market");
        message.setText(text);
        emailSender.send(message);

        return orderResponseDtos;
    }
}

















