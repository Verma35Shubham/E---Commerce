package com.AccioMarket.Ecommerce.Controllers;

import com.AccioMarket.Ecommerce.Exceptions.CustomerNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.OrderRequestDto;
import com.AccioMarket.Ecommerce.ResponseDTO.OrderResponseDto;
import com.AccioMarket.Ecommerce.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody OrderRequestDto orderRequestDto){
        String response = "";
        System.out.println(orderRequestDto.toString() + ".............");
        try{
            response = cartService.addCart(orderRequestDto);
        } catch (Exception e) {
            return e.getMessage();
        }

        return response;
    }

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity checkoutCart(@PathVariable("customerId") int customerId){
        List<OrderResponseDto> orderResponseDtos;

        try{
            orderResponseDtos = cartService.checkout(customerId);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(orderResponseDtos, HttpStatus.ACCEPTED);
    }
}
