package com.example.tech_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech_assignment.request.UserLogin;
import com.example.tech_assignment.request.UserRegister;
import com.example.tech_assignment.response.LoginResponse;
import com.example.tech_assignment.services.UserService;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/register")
    @CrossOrigin
    public String registerUser(@RequestBody UserRegister userRegister) {
        String result = "User has been created: " + userService.registerUser(userRegister);
        return result;
    }

    @PostMapping("/api/v1/login")
    @CrossOrigin
    public LoginResponse loginUser(@RequestBody UserLogin userLogin) {
        LoginResponse result = userService.loginUser(userLogin);
        return result;
    }
}
