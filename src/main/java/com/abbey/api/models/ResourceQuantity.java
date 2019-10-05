package com.abbey.api.models;

import lombok.Builder;

public class ResourceQuantity {

    private String resource;
    private Float quantity;

    @Builder
    public ResourceQuantity(String resource, Float quantity){
        this.resource = resource;
        this.quantity = quantity;
    }

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Float getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}
