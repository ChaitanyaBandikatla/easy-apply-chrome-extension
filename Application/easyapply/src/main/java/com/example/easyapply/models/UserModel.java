package com.example.easyapply.models;

import java.util.Date;

/**
 * User DTO model
 */
public class UserModel {
    private int userId;
    private String username;
    private String password;
    private String email;
    private Date lastLogin;

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
