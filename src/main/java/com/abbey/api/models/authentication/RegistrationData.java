package com.abbey.api.models.authentication;

import lombok.Builder;

import java.util.Set;

public class RegistrationData {

    private String venueName;
    private String username;
    private String password;
    private String confirmPassword;
    private Set roles;

    @Builder
    public RegistrationData(String venueName, String username, String password, String confirmPassword){
        this.venueName = venueName;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getVenueName() {
        return this.venueName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public Set<Role> getRoles(){
        return this.roles;
    }
}
