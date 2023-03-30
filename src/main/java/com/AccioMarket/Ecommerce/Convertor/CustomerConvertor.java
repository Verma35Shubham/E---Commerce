package com.AccioMarket.Ecommerce.Convertor;

import com.AccioMarket.Ecommerce.Model.Customer;
import com.AccioMarket.Ecommerce.RequestDTO.CustomerRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {

    public static Customer customerRequestDTOtoCustomer(CustomerRequestDTO customerRequestDTO){
        return Customer.builder()
                .name(customerRequestDTO.getName())
                .age(customerRequestDTO.getAge())
                .mobNo(customerRequestDTO.getMobNo())
                .email(customerRequestDTO.getEmail())
                .build();
    }
}
