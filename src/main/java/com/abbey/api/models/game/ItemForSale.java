package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;

@Data
public class ItemForSale {

    private Double value;
    private String name;
    private String resource;

    @Builder
    public ItemForSale(){}

    public Double getValue() {
        return this.value;
    }
    public void setValue(Double value) {
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
