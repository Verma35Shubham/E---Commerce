package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.Exceptions.ProductNotFoundException;
import com.AccioMarket.Ecommerce.ResponseDTO.ItemResponseDto;

public interface ItemService {

    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException;
}
