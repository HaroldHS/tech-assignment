package com.example.tech_assignment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech_assignment.request.UserLogin;
import com.example.tech_assignment.request.UserRegister;
import com.example.tech_assignment.response.LoginResponse;
import com.example.tech_assignment.services.JwtService;
import com.example.tech_assignment.services.UserService;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/v1/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserRegister userRegister) {
        String result = "User has been created for " + userService.registerUser(userRegister);

        var response = new HashMap<String, Object>();
        response.put("user", userRegister);
        response.put("message", result);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLogin userLogin) {
        LoginResponse result = userService.loginUser(userLogin);

        if(result.getStatus().equals(true)) {
            try {
                authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword())
                );

                String jwtToken = jwtService.generateJWT(userLogin);
                var response = new HashMap<String, Object>();
                response.put("token", jwtToken);
                response.put("message", result);

                return ResponseEntity.ok(response);
            } catch (Exception e) {
            }
        }

        return ResponseEntity.badRequest().body(result);
    }
}
