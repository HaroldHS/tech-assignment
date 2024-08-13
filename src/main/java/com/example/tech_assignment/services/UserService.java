package com.example.tech_assignment.services;

import com.example.tech_assignment.request.UserLogin;
import com.example.tech_assignment.request.UserRegister;
import com.example.tech_assignment.response.LoginResponse;

public interface UserService {
   String registerUser(UserRegister userRegister);
   LoginResponse loginUser(UserLogin userLogin);
}
