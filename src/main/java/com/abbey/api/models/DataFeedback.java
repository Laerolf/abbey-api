package com.abbey.api.models;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

public class DataFeedback extends Feedback {

    private Map<String, Object> data;

    @Builder
    public DataFeedback(String message, Boolean successful){
        super(message,successful);
        this.data = new HashMap<>();
    }

    public Map<String, Object> getData(){
        return this.data;
    }
}
