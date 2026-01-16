package com.ecommerce.amit.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    

    private final String JwtSecret = "kfhahfiaffasfndjanfvanfieffjhhjghjghjgjhhchgfghdgcghfhgcgc";
    private final Long    JwtExpiary=360000000000L;

    private final SecretKey key =
            Keys.hmacShaKeyFor(JwtSecret.getBytes());


    public String generateJwt(String username,String role){
     return   Jwts.builder()
        .subject(username)
        .claim("role", role)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + JwtExpiary))
        .signWith(key, Jwts.SIG.HS256)
        .compact();
    }

    public Claims claims(String token){
        return Jwts.parser()
        .verifyWith(key)
        .build().parseSignedClaims(token)
        .getPayload();
    }

    public String getUserName(String token){
        return claims(token).getSubject();
    }

}
