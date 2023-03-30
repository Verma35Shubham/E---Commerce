package com.AccioMarket.Ecommerce.Services;

import com.AccioMarket.Ecommerce.Enum.ProductCategory;
import com.AccioMarket.Ecommerce.Exceptions.SellerNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.ProductRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) throws SellerNotFoundException;

    public List<ProductResponseDTO> getProductsByCategory(ProductCategory productCategory);
}
