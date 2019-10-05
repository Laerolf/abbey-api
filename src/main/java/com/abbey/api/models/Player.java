package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@Builder
public class Player {

    @Id
    private String _id;

    private String name;
    private Float goldenCoins;
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

    public Float getGoldenCoins() {
        return this.goldenCoins;
    }
    public void setGoldenCoins(Float goldenCoins) {
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

/*

 name: {type: String, default: null},
    goldenCoins: {
        type: Number,
        min: 0,
        default: 100
    },
    reputation: {
        type: Number,
        min: 0,
        default: 0
    },
    counter: {
        type: Map,
        of: Number,
        default: new Map
    }

 */
