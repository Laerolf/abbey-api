package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;

@Data
public class ResourceQuantity {

    private String resource;
    private Double quantity;

    @Builder
    public ResourceQuantity(){ }

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Double getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
