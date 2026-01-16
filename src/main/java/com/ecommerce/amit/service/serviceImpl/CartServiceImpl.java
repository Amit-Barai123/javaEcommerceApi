package com.ecommerce.amit.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.entity.Cart;
import com.ecommerce.amit.entity.User;
import com.ecommerce.amit.repo.CartRepo;
import com.ecommerce.amit.repo.UserRepo;
import com.ecommerce.amit.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartRepo cartRepo;

    @Override
    public Cart createCart(Integer UserId) {
       User user = userRepo.findById(UserId).orElseThrow(()-> new RuntimeException("user not found"));
       if(user !=null){
        Cart cart = Cart.builder()
        .user(user)
        .build();

       Cart c=  cartRepo.save(cart);
       return c;
       }else {
       throw new RuntimeException("some thing went worng");
       }
       
    }

    @Override
    public Cart getUserItems(Integer UserId) {
        User user = userRepo.findById(UserId).orElseThrow(()->new RuntimeException("user not found"));
        Cart carts = cartRepo.findByUser(user);

        return carts;
    }
    
}
