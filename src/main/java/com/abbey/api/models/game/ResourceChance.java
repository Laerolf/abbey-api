package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;

@Data
public class ResourceChance {

    private String resource;
    private Integer chance;

    @Builder
    public ResourceChance(){}

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getChance() {
        return this.chance;
    }
    public void setChance(Integer chance) {
        this.chance = chance;
    }
}
