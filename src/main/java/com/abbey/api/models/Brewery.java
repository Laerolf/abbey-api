package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

public class Brewery {

    @Id
    private String _id;

    private String recipe;
    private String beer;

    @Builder
    public Brewery(String _id, String recipe, String beer){
        this._id = _id;
        this.recipe = recipe;
        this.beer = beer;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRecipe() {
        return this.recipe;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getBeer() {
        return this.beer;
    }
    public void setBeer(String beer) {
        this.beer = beer;
    }
}
