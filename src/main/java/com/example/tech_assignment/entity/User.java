package com.example.tech_assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String address;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getMobile() {
        return mobile;
    }
    public String getAddress() {
        return address;
    }

    public void setUser(Integer userId, String userName, String userEmail, String userMobile, String userAddress) {
        this.id = userId;
        this.name = userName;
        this.email = userEmail;
        this.mobile = userMobile;
        this.address = userAddress;
    }

}