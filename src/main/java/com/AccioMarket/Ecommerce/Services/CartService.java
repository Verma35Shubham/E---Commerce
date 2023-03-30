package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.Exceptions.ProductNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.OrderRequestDto;
import com.AccioMarket.Ecommerce.ResponseDTO.OrderResponseDto;

import java.util.List;

public interface CartService {

    public String addCart(OrderRequestDto orderRequestDto) throws Exception;

    public List<OrderResponseDto> checkout(int customerId) throws CustomerNotFoundException;
}
