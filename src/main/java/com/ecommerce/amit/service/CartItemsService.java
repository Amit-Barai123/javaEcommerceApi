package com.ecommerce.amit.service;

import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.CartItemsReq;
import com.ecommerce.amit.entity.CartItem; 

@Service
public interface CartItemsService {
    
    CartItem addItemsTOCart(CartItemsReq req);

}
