package com.abbey.api.models;

import lombok.Builder;

@Builder
public class ItemForSale {

    private Float value;
    private String name;
    private String resource;

    public Float getValue() {
        return this.value;
    }
    public void setValue(Float value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }
}
