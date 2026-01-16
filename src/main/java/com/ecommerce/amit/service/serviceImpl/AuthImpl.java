package com.ecommerce.amit.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.config.JwtService;
import com.ecommerce.amit.dto.LoginReq;
import com.ecommerce.amit.dto.RegisterReq;
import com.ecommerce.amit.entity.Role;
import com.ecommerce.amit.repo.UserRepo;
import com.ecommerce.amit.service.AuthService;

import jakarta.transaction.Transactional;

@Service
public class AuthImpl implements AuthService {

    @Autowired
    private UserRepo userRepo;

        @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    @Transactional
    public String registerUser(RegisterReq req) {

        com.ecommerce.amit.entity.User user = new com.ecommerce.amit.entity.User();
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRole(Role.valueOf(req.getRole()));
        user.setName(req.getName());
userRepo.save(user);

return "User saved sucessfully";


    }

    @Override
    public String LoginUser(LoginReq req) {
    Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(),req.getPassword()));
    String role = auth.getAuthorities().stream().findFirst().orElseThrow().getAuthority();
    return jwtService.generateJwt(req.getEmail(), role);
     
       
    }
    
}
