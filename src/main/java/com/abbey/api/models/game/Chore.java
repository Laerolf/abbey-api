package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chore {

    private String name;
    private Float time;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Float getTime() {
        return this.time;
    }
    public void setTime(Float time) {
        this.time = time;
    }
}
