package com.example.tech_assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name", length = 255)
    private String name;
    
    @Column(name = "user_email", length = 255)
    private String email;
    
    @Column(name = "user_mobile", length = 255)
    private String mobile;
    
    @Column(name = "user_address", length = 255)
    private String address;
    
    @Column(name = "user_password", length = 255)
    private String password;

    public User(Integer userId, String userName, String userEmail, String userMobile, String userAddress, String userPassword) {
        this.id = userId;
        this.name = userName;
        this.email = userEmail;
        this.mobile = userMobile;
        this.address = userAddress;
        this.password = userPassword;
    }

}