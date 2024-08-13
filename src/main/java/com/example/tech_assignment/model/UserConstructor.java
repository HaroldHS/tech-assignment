package com.example.tech_assignment.model;

public class UserConstructor {
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String password;
    
    public UserConstructor(Integer userId, String userName, String userEmail, String userMobile, String userAddress, String userPassword) {
        this.id = userId;
        this.name = userName;
        this.email = userEmail;
        this.mobile = userMobile;
        this.address = userAddress;
        this.password = userPassword;
    }

    public UserConstructor() {
    }

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

    public String getPassword() {
        return password;
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

    @Override
    public String toString() {
        return "UserConstructor{" +
        "user_id=" + this.id +
        ", user_name='" + this.name + "'" + 
        ", user_email='" + this.email + "'" +
        ", user_mobile='" + this.mobile + "'" +
        ", user_address='" + this.address + "'";
    }
}
