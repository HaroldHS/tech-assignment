package com.example.tech_assignment.services;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.tech_assignment.request.UserLogin;

@Service
public class JwtService {
    
    @Value("${security.jwt.secret-key}")
    private String secretKey;
    
    @Value("${security.jwt.expiration-time-ms}")
    private long expirationTime;
    
    @Value("${security.jwt.issuer}")
    private String issuer;

    public String generateJWT(UserLogin user) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        var key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
        .subject(user.getEmail())
        .issuedAt(new Date(System.currentTimeMillis()))
        .issuer(issuer)
        .expiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
    }

    public Claims getTokenClaims(String token) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        var key = Keys.hmacShaKeyFor(keyBytes);

        try {
            var claims = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
            
            Date exprDate = claims.getExpiration();
            Date currDate = new Date();
            if(currDate.before(exprDate)) {
                return claims;
            }
        } catch (Exception e) {
        }

        return null;
    }

}
