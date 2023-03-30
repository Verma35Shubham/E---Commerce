package com.AccioMarket.Ecommerce.Convertor;

import com.AccioMarket.Ecommerce.Enum.ProductStatus;
import com.AccioMarket.Ecommerce.Model.Product;
import com.AccioMarket.Ecommerce.RequestDTO.ProductRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.ProductResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConvertor {
    public static Product productRequestDtotoProduct(ProductRequestDTO productRequestDTO){
        return Product.builder()
                .productName(productRequestDTO.getProductName())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .productCategory(productRequestDTO.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
    public static ProductResponseDTO productToProductResponseDto(Product product){
        return ProductResponseDTO.builder()
                .name(product.getProductName())
                .productStatus(product.getProductStatus())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
