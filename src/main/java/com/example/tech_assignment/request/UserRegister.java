package com.example.tech_assignment.request;

public class UserRegister {
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String password;
    
    public UserRegister(Integer userId, String userName, String userEmail, String userMobile, String userAddress, String userPassword) {
        this.id = userId;
        this.name = userName;
        this.email = userEmail;
        this.mobile = userMobile;
        this.address = userAddress;
        this.password = userPassword;
    }

    public UserRegister() {
    }

    public Integer getId() {
        return this.id;
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

    @Override
    public String toString() {
        return "UserRegister{" +
        "user_id=" + this.id +
        ", user_name='" + this.name + "'" + 
        ", user_email='" + this.email + "'" +
        ", user_mobile='" + this.mobile + "'" +
        ", user_address='" + this.address + "'";
    }
}
