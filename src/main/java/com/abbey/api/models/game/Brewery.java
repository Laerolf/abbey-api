package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "breweries")
@Data
public class Brewery {

    @Id
    private String _id;

    private String selectedRecipe;
    private String selectedBeer;

    @Builder
    public Brewery(String _id, String recipe, String beer, Map<String, BreweryProcessor> breweryProcessors){
        this._id = _id;
        this.selectedRecipe = recipe;
        this.selectedBeer = beer;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRecipe() {
        return this.selectedRecipe;
    }
    public void setRecipe(String recipe) {
        this.selectedRecipe = recipe;
    }

    public String getBeer() {
        return this.selectedBeer;
    }
    public void setBeer(String beer) {
        this.selectedBeer = beer;
    }
}
