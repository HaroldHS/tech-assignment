package com.example.tech_assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserInfo {

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

    public UserInfo(Integer userId, String userName, String userEmail, String userMobile, String userAddress, String userPassword) {
        this.id = userId;
        this.name = userName;
        this.email = userEmail;
        this.mobile = userMobile;
        this.address = userAddress;
        this.password = userPassword;
    }

    public UserInfo() {
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}