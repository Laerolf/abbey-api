package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class FacilityStorage {

    private int capacity;

    @Builder.Default
    private List<ResourceQuantity> items = new ArrayList<>();

    @Builder
    public FacilityStorage(){
        this.capacity = 100;
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
