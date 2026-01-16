package com.ecommerce.amit.service;

import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.LoginReq;
import com.ecommerce.amit.dto.RegisterReq;

@Service
public interface AuthService {
    String registerUser(RegisterReq req);
    String LoginUser(LoginReq req);
}
