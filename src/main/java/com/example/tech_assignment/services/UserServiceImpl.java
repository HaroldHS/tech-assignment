package com.example.tech_assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tech_assignment.model.User;
import com.example.tech_assignment.model.UserConstructor;
import com.example.tech_assignment.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserConstructor userConstructor){

        User user = new User(
        userConstructor.getId(),
        userConstructor.getName(),
        userConstructor.getEmail(),
        userConstructor.getMobile(),
        userConstructor.getAddress(),
        this.passwordEncoder.encode(userConstructor.getPassword())
        );

        userRepository.save(user);

        return userConstructor.getName();
    }

}
