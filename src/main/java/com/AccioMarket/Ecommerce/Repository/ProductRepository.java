package com.AccioMarket.Ecommerce.Repository;

import com.AccioMarket.Ecommerce.Enum.ProductCategory;
import com.AccioMarket.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByProductCategory(ProductCategory productCategory);
}
