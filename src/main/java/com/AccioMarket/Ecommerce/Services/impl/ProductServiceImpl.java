package com.AccioMarket.Ecommerce.Services.impl;

import com.AccioMarket.Ecommerce.Convertor.ProductConvertor;
import com.AccioMarket.Ecommerce.Enum.ProductCategory;
import com.AccioMarket.Ecommerce.Exceptions.SellerNotFoundException;
import com.AccioMarket.Ecommerce.Model.Product;
import com.AccioMarket.Ecommerce.Model.Seller;
import com.AccioMarket.Ecommerce.Repository.ProductRepository;
import com.AccioMarket.Ecommerce.Repository.SellerRepository;
import com.AccioMarket.Ecommerce.RequestDTO.ProductRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.ProductResponseDTO;
import com.AccioMarket.Ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) throws SellerNotFoundException {
        Seller seller;
        try{
            seller = sellerRepository.findById(productRequestDTO.getSellerId()).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }
        Product product = ProductConvertor.productRequestDtotoProduct(productRequestDTO);
        product.setSeller(seller);
        seller.getProducts().add(product);

        sellerRepository.save(seller);

        ProductResponseDTO productResponseDTO = ProductConvertor.productToProductResponseDto(product);
        return productResponseDTO;
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(ProductCategory productCategory) {
        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for(Product product : products){
            ProductResponseDTO productResponseDTO = ProductConvertor.productToProductResponseDto(product);
            productResponseDTOS.add(productResponseDTO);
        }

        return productResponseDTOS;
    }


}
