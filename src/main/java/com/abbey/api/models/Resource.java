package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

@Builder
public class Resource {

    @Id
    private String _id;

    private String name;
    private Boolean growable;
    private String category;
    private Float value;

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGrowable() {
        return this.growable;
    }
    public void setGrowable(Boolean growable) {
        this.growable = growable;
    }

    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Float getValue() {
        return this.value;
    }
    public void setValue(Float value) {
        this.value = value;
    }
}