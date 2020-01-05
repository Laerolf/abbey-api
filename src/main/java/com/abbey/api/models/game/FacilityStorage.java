package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class FacilityStorage {

    private int capacity;
    private List<ResourceQuantity> items;

    @Builder
    public FacilityStorage(){
        this.capacity = 100;
        this.items = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ResourceQuantity> getItems() {
        return this.items;
    }
    public void setItems(List<ResourceQuantity> items) {
        this.items = items;
    }
}
