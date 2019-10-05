package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

public class Beer {

    @Id
    private String _id;

    private Float alcoholLevel;
    private String category;
    private String description;
    private String name;

    @Builder
    public Beer (String _id, Float alcoholLevel, String category, String description, String name){
        this._id = _id;
        this.alcoholLevel = alcoholLevel;
        this.category = category;
        this.description = description;
        this.name = name;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Float getAlcoholLevel() {
        return this.alcoholLevel;
    }
    public void setAlcoholLevel(Float alcoholLevel) {
        this.alcoholLevel = alcoholLevel;
    }

    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
