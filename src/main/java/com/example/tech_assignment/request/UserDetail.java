package com.example.tech_assignment.request;

public class UserDetail {
    
    private String name;
    private String email;
    private String mobile;
    private String address;

    public UserDetail(String userName, String userEmail, String userMobile, String userAddress) {
        this.name = userName;
        this.email = userEmail;
        this.mobile = userMobile;
        this.address = userAddress;
    }

    public UserDetail() {
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
}
