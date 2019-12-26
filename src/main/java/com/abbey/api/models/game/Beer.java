package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "beers")
@Data
public class Beer {

    @Id
    private String _id;

    private String mapName;

    private Double alcoholLevel;
    private String category;
    private String description;
    private String name;
    private String discoverer;
    private Map<String, String> discoverDate;

    @Builder
    public Beer (){
        this._id = ObjectId.get().toHexString();
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Double getAlcoholLevel() {
        return this.alcoholLevel;
    }
    public void setAlcoholLevel(Double alcoholLevel) {
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

    public String getDiscoverer() {
        return this.discoverer;
    }
    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    public Map<String, String> getDiscoverDate() {
        return this.discoverDate;
    }
    public void setDiscoverDate(Map<String, String> discoverDate) {
        this.discoverDate = discoverDate;
    }

    public String getMapName() {
        return this.mapName;
    }
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
