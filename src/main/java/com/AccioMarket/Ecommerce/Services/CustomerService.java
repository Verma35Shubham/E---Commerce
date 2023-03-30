package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.RequestDTO.CustomerRequestDTO;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Service;


public interface CustomerService {

    public String addCustomer(CustomerRequestDTO customerRequestDTO);
}
