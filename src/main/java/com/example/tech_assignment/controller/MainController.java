package com.example.tech_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech_assignment.model.UserConstructor;
import com.example.tech_assignment.services.UserService;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/register")
    @CrossOrigin
    public String registerUser(@RequestBody UserConstructor userConstructor) {
        String result = "User has been created: " + userService.registerUser(userConstructor);
        return result;
    }
}
