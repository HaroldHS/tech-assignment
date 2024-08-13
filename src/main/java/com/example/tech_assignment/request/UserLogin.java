package com.example.tech_assignment.request;

public class UserLogin {
    private String email;
    private String password;

    public UserLogin(String userEmail, String userPassword) {
        this.email = userEmail;
        this.password = userPassword;
    }

    public UserLogin() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "UserLogin{" +
        ", user_email='" + this.email + "'" +
        ", user_mobile='" + this.password + "'";
    }
}
