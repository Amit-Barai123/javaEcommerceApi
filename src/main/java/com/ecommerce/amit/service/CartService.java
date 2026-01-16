package com.ecommerce.amit.service;


import org.springframework.stereotype.Service;

import com.ecommerce.amit.entity.Cart;

@Service
public interface CartService {
    
    Cart createCart(Integer UserId);

    Cart getUserItems(Integer UserId);

}
