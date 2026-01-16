package com.ecommerce.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.amit.entity.CartItem;


@Repository
public interface CartItemsRepo extends JpaRepository<CartItem,Integer> {
    
}
