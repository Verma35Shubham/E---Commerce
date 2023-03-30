package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Convertor.CustomerConvertor;
import com.AccioMarket.Ecommerce.Model.Cart;
import com.AccioMarket.Ecommerce.Model.Customer;
import com.AccioMarket.Ecommerce.Repository.CustomerRepository;
import com.AccioMarket.Ecommerce.RequestDTO.CustomerRequestDTO;
import com.AccioMarket.Ecommerce.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = CustomerConvertor.customerRequestDTOtoCustomer(customerRequestDTO);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setCartTotal(0);

        customer.setCart(cart);
        customerRepository.save(customer);

        return "Congratulation!! Welcome to AccioMarket";
    }
}
