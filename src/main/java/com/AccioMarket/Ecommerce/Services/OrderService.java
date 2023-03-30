package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.Exceptions.ProductNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.OrderRequestDto;
import com.AccioMarket.Ecommerce.ResponseDTO.OrderResponseDto;

public interface OrderService {

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;
}
