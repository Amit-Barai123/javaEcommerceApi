package com.ecommerce.amit.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.entity.Role;
import com.ecommerce.amit.entity.User;
import com.ecommerce.amit.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        User user = userRepo.findByEmail(username);

        org.springframework.security.core.userdetails.User usr = new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            List.of( new SimpleGrantedAuthority(user.getRole().name()) )
        );

        return usr;
 
      
    }
}
