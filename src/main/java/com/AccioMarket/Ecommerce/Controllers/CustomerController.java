package com.AccioMarket.Ecommerce.Controllers;

import com.AccioMarket.Ecommerce.RequestDTO.CustomerRequestDTO;
import com.AccioMarket.Ecommerce.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){

        return customerService.addCustomer(customerRequestDTO);
    }



    // get customer by id

    // view all customers

    // delete customer by id

    // get a customer by email

    // update customer
}
