package com.ecommerce.amit.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.amit.entity.User;
import com.ecommerce.amit.service.serviceImpl.CustomUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service  
public class JwtAuthenticationFilter extends OncePerRequestFilter  {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
                String authorization = request.getHeader("Authorization");

                  if (authorization == null || !authorization.startsWith("Bearer ")) {
        filterChain.doFilter(request, response);
        return;
    }

   

                if(SecurityContextHolder.getContext().getAuthentication() == null ){

                  String token = authorization.substring(7);

    // ✅ MUST check empty token
    if (token.isBlank()) {
        filterChain.doFilter(request, response);
        return;
    }

                 String userName = jwtService.getUserName(token);

                 UserDetails userDetails = customUserDetailService.loadUserByUsername(userName);

                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,
                     userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);



                }
                filterChain.doFilter(request, response);
            }
}
