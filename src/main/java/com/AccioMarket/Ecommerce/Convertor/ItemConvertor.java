package com.AccioMarket.Ecommerce.Convertor;

import com.AccioMarket.Ecommerce.Model.Item;
import com.AccioMarket.Ecommerce.Model.Product;
import com.AccioMarket.Ecommerce.ResponseDTO.ItemResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemConvertor {

    public static ItemResponseDto productToItemResponseDto(Product product){
        return ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}


