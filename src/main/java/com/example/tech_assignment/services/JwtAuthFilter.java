package com.example.tech_assignment.services;

import java.io.IOException;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.tech_assignment.model.UserInfo;
import com.example.tech_assignment.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserJwtService userJwtService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String bearerToken = request.getHeader("Authorization");
            if(bearerToken == null || !bearerToken.startsWith("Bearer")) {
                throw new Exception("Authorization Bearer not found");
            }

            String jwt = bearerToken.substring(7);
            Claims claims = jwtService.getTokenClaims(jwt);

            if(claims == null) {
                throw new Exception("[-] Invalid token");
            }

            String email = claims.getSubject();
            var user = userJwtService.loadUserByUsername(email);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            System.out.println("[-] Can't authenticate user: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
    
}
