package com.BilBay.bilbay.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;
    private String email;
    private List<String> roles;
    private String username;

    public UserInfoResponse(Long id, String email, List<String> roles, String username) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

