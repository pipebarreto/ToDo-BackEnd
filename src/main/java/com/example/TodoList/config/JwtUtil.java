package com.example.TodoList.config;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.TodoList.domain.UserModel;

@Component
public class JwtUtil {
    private static final long EXPIRE_DURATION = 60 * 60 * 1000; // Valid for 1 hour
     
    @Value("${jwt_secret}")
    private String SECRET_KEY;
     
    public String generateAccessToken(UserModel user) {
        return JWT.create()
                .withClaim("email", user.getEmail())                
                .withIssuedAt(new Date(System.currentTimeMillis()))                
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .withIssuer("Diego")
                .sign(Algorithm.HMAC256(SECRET_KEY));
                                
    }
    
    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .withIssuer("Diego")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("email").asString();
    }
    
    
}