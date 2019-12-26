package com.abbey.api.models.game;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "players")
@Builder
public class Player {

    @Id
    private String _id;

    private String name;
    private Double goldenCoins;
    private Integer reputation;

    @Builder.Default
    private Map<String, Integer> counter = new HashMap<>();

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

    public Double getGoldenCoins() {
        return this.goldenCoins;
    }
    public void setGoldenCoins(Double goldenCoins) {
        this.goldenCoins = goldenCoins;
    }

    public Integer getReputation() {
        return this.reputation;
    }
    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Map<String, Integer> getCounter() {
        return this.counter;
    }
    public void setCounter(Map<String, Integer> counter) {
        this.counter = counter;
    }
}
