package com.AccioMarket.Ecommerce.RequestDTO;

import com.AccioMarket.Ecommerce.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {
    private int sellerId;
    private String productName;
    private int price;
    private int quantity;
    private ProductCategory productCategory;
}
