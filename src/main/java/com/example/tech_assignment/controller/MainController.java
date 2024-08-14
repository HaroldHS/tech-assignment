package com.example.tech_assignment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech_assignment.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/profile")
    public ResponseEntity<Object> profile(Authentication auth) {
        var response = new HashMap<String, Object>();
        response.put("username", auth.getName());
        response.put("authorities", auth.getAuthorities());

        var user = userRepository.findByEmail(auth.getName());
        response.put("user_profile", user);
        return ResponseEntity.ok(response);
    }

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
                System.out.println("[-] Failed to authenticate: ");
                e.printStackTrace();
            }
        }

        return ResponseEntity.badRequest().body(result);
    }
}
