package com.abbey.api.models.authentication;

import lombok.Builder;

@Builder
public class AuthenticationData {

    private String token;

    public AuthenticationData(String token){
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
