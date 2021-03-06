package com.abbey.api.models.game;

import lombok.Data;

@Data
public class ResourceQuantity {

    private String resource;
    private Number quantity;

    public ResourceQuantity(){}

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Number getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }
}
