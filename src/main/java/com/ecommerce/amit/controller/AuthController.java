package com.ecommerce.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amit.dto.LoginReq;
import com.ecommerce.amit.dto.RegisterReq;
import com.ecommerce.amit.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/auth")
public class AuthController {
    

    @Autowired
    private AuthService service;



    @GetMapping("/")
    public String testController() {
        return  "welcome to ecommerce app";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterReq req){
service.registerUser(req);
return "user registered sucessfully";
    }
    

    //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWl0MTIzQGdtYWlsLmNvbSIsInJvbGUiOiJST0xFX1VTRVIiLCJpYXQiOjE3NjgxMDY2MzYsImV4cCI6MTc2ODEwNjY3Mn0.rPeeG74wmiDuip0qDyHNxK0m2S2q7g5LZLsI69a7dJE

    @PostMapping("/login")
    public String LoginUser(@RequestBody LoginReq req){
return service.LoginUser(req);
    }

}
