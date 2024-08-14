package com.example.tech_assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tech_assignment.model.UserInfo;
import com.example.tech_assignment.repository.UserRepository;
import com.example.tech_assignment.request.UserLogin;
import com.example.tech_assignment.request.UserRegister;
import com.example.tech_assignment.response.LoginResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserRegister userRegister){

        UserInfo user = new UserInfo(
        userRegister.getId(),
        userRegister.getName(),
        userRegister.getEmail(),
        userRegister.getMobile(),
        userRegister.getAddress(),
        this.passwordEncoder.encode(userRegister.getPassword())
        );

        userRepository.save(user);

        return userRegister.getName();
    }

    @Override
    public LoginResponse loginUser(UserLogin userLogin) {

        LoginResponse result;
        UserInfo user = userRepository.findByEmail(userLogin.getEmail());

        if(user != null) {
            String currPassword = userLogin.getPassword();
            String realPassword = user.getPassword();
            Boolean matchPassword = this.passwordEncoder.matches(currPassword, realPassword);

            if(matchPassword) {
                result = new LoginResponse("[+] Valid credential", true);
            } else {
                result = new LoginResponse("[-] Invalid credential", false);
            }
        } else {
            result = new LoginResponse("[-] Email is not exist", false);
        }

        return result;
    }

}
