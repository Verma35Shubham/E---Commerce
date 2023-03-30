package com.AccioMarket.Ecommerce.Repository;

import com.AccioMarket.Ecommerce.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Seller findByPanNo(String panNo);
}
