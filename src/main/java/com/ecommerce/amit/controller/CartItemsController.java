package com.ecommerce.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amit.dto.CartItemsReq;
import com.ecommerce.amit.entity.CartItem;
import com.ecommerce.amit.service.CartItemsService;

@RequestMapping("/user")
@RestController
public class CartItemsController {

    @Autowired
    private CartItemsService  cartItemsService;

    @PostMapping("/addItemtoCart")
    public ResponseEntity< CartItem> addItemsTOCart(@RequestBody CartItemsReq req){
         CartItem cartItem=    cartItemsService.addItemsTOCart(req);
         return ResponseEntity.ok(cartItem);
    }
}
