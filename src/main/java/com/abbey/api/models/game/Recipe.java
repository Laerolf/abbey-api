package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "recipes")
@Data
public class Recipe {

    @Id
    private String _id;

    private String name;
    private String resource;

    @Builder.Default
    private Map<String, Integer> ingredients = new HashMap<>();

    @Builder
    public Recipe () {
        this._id = ObjectId.get().toHexString();
    }

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

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Map<String, Integer> getIngredients() {
        return this.ingredients;
    }
    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }
}
