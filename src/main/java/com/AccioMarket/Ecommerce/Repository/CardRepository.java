package com.AccioMarket.Ecommerce.Repository;

import com.AccioMarket.Ecommerce.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
