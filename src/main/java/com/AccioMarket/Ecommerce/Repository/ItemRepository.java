package com.AccioMarket.Ecommerce.Repository;

import com.AccioMarket.Ecommerce.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
