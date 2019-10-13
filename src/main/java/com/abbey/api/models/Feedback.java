package com.abbey.api.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Feedback {

    private String message;
    private Boolean successful;

    public Boolean getSuccessful() {
        return this.successful;
    }
    public void setSuccessful (Boolean successful){
        this.successful = successful;
    }

    public String getMessage() {
        return this.message;
    }
    public void setMessage (String message){
        this.message = message;
    }
}
