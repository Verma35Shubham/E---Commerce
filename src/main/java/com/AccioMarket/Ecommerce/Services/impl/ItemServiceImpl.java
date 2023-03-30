package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Convertor.ItemConvertor;
import com.AccioMarket.Ecommerce.Exceptions.ProductNotFoundException;
import com.AccioMarket.Ecommerce.Model.Item;
import com.AccioMarket.Ecommerce.Model.Product;
import com.AccioMarket.Ecommerce.Repository.ProductRepository;
import com.AccioMarket.Ecommerce.ResponseDTO.ItemResponseDto;
import com.AccioMarket.Ecommerce.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;

        try{
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Sorry! Invalid Product Id.");
        }

        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        product.setItem(item);

        productRepository.save(product);

        ItemResponseDto itemResponseDto = ItemConvertor.productToItemResponseDto(product);

        return itemResponseDto;
    }
}
