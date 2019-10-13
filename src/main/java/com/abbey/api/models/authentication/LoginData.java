package com.abbey.api.models.authentication;

import lombok.Builder;

public class LoginData {

    private String username;
    private String password;

    @Builder
    public LoginData(String username, String password){
        this.username = username;
        this.password = password;
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
}
