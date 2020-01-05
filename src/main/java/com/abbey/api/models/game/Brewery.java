package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "breweries")
@Data
public class Brewery {

    @Id
    private String _id;

    private String recipe;
    private String beer;

    private Map<String, BreweryProcessor> breweryProcessors;

    @Builder
    public Brewery(String _id, String recipe, String beer, Map<String, BreweryProcessor> breweryProcessors){
        this._id = _id;
        this.recipe = recipe;
        this.beer = beer;
        this.breweryProcessors = breweryProcessors;
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

    public Map<String, BreweryProcessor> getBreweryProcessors() {
        return this.breweryProcessors;
    }
    public void setBreweryProcessors(Map<String, BreweryProcessor> breweryProcessors) {
        this.breweryProcessors = breweryProcessors;
    }
}
