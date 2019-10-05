package com.abbey.api.models;

import lombok.Builder;

@Builder
public class WorkbenchSlot {

    private Integer quantity;
    private String resource;
    private String number;

    public Integer getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
