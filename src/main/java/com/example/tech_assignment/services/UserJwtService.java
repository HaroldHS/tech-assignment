package com.example.tech_assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tech_assignment.model.UserInfo;
import com.example.tech_assignment.repository.UserRepository;

@Service
public class UserJwtService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByEmail(email);

        if(user != null) {
            UserDetails springUser = User.withUsername(user.getEmail()).password(user.getPassword()).build();

            return springUser;
        }

        return null;
    }
}
