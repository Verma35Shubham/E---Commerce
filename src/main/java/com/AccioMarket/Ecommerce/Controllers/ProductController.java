package com.AccioMarket.Ecommerce.Controllers;

import com.AccioMarket.Ecommerce.Enum.ProductCategory;
import com.AccioMarket.Ecommerce.Exceptions.SellerNotFoundException;
import com.AccioMarket.Ecommerce.RequestDTO.ProductRequestDTO;
import com.AccioMarket.Ecommerce.ResponseDTO.ProductResponseDTO;
import com.AccioMarket.Ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO;
        try {
            productResponseDTO = productService.addProduct(productRequestDTO);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(productResponseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/category/{productCategory}")
    public List<ProductResponseDTO> getAllProductByCategory(@PathVariable("productCategory")ProductCategory productCategory){
        return productService.getProductsByCategory(productCategory);
    }
}
