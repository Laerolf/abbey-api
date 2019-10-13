package com.abbey.api.models.authentication;

import com.abbey.api.models.Feedback;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationFeedback extends Feedback {

    private Map<String, String> data;

    @Builder
    public AuthenticationFeedback(String message, Boolean successful){
        super(message,successful);
        this.data = new HashMap<>();
    }

    public Map<String, String> getData() {
        return this.data;
    }
    public void addData (String dataKey, String dataValue) {
        this.data.put(dataKey, dataValue);
    }
}
