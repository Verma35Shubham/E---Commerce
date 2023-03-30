package com.AccioMarket.Ecommerce.ResponseDTO;

import com.AccioMarket.Ecommerce.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String name;
    private  int price;
    private int quantity;
    private ProductStatus productStatus;
}
