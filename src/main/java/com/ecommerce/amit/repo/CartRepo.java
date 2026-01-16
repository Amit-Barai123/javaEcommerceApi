package com.ecommerce.amit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.amit.entity.Cart;
import com.ecommerce.amit.entity.User;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    
    Cart findByUser(User user);

}
