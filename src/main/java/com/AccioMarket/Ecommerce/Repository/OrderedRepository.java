package com.AccioMarket.Ecommerce.Repository;

import com.AccioMarket.Ecommerce.Model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer> {
}
