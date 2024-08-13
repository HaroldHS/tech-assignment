package com.example.tech_assignment.response;

public class LoginResponse {
    String message;
    Boolean status;

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginResponse() {
    }
    
    public String getMessage() {
        return this.message;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
