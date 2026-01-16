package com.ecommerce.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amit.entity.Cart;
import com.ecommerce.amit.service.CartService;

@RequestMapping("/user")
@RestController
public class CartController {
    
    @Autowired
    private CartService service;

    @GetMapping("/createCart/{userId}")
    public ResponseEntity< Cart> createCart(@PathVariable Integer userId){

     Cart cart=  service.createCart(userId);

     return ResponseEntity.ok(cart);
    }

    @GetMapping("/getUserCart/{UserId}")
     public ResponseEntity< Cart> getUserItems(@PathVariable Integer UserId){
return ResponseEntity.ok(service.getUserItems(UserId));
     }



}
