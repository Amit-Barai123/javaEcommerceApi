package com.ecommerce.amit.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.CartItemsReq;
import com.ecommerce.amit.entity.Cart;
import com.ecommerce.amit.entity.CartItem;
import com.ecommerce.amit.entity.Product;
import com.ecommerce.amit.repo.CartItemsRepo;
import com.ecommerce.amit.repo.CartRepo;
import com.ecommerce.amit.repo.ProductRepo;
import com.ecommerce.amit.service.CartItemsService;
import com.ecommerce.amit.service.CartService;

@Service
public class CartItemServiceImpl implements CartItemsService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartItemsRepo cartItemsRepo;

    @Override
    public CartItem addItemsTOCart(CartItemsReq req) {

        Cart cart = cartRepo.findById(req.getCartId()).orElseThrow(()-> new RuntimeException("cart not found"));
        Product product = productRepo.findById(req.getProductId()).orElseThrow(()-> new RuntimeException("product not found"));

       CartItem  cartItem = CartItem.builder().quantity(req.getQuantity())
       .cart(cart)
       .product(product)
       .build();

      return cartItemsRepo.save(cartItem);

    }

    
    
}
