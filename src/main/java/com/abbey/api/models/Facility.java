package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@Builder
public class Facility {

    @Id
    private String _id;

    private Float collectAmount;
    private Boolean collectable;
    private String name;
    private Integer progress;
    @Builder.Default
    private Map<String, Float> resourceChances = new HashMap<>();
    @Builder.Default
    private Map<String, ResourceQuantity> storage = new HashMap<>();
    private Boolean inProgress;
    private Boolean collected;
    private Integer assignedMonks;

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Float getCollectAmount() {
        return this.collectAmount;
    }
    public void setCollectAmount(Float collectAmount) {
        this.collectAmount = collectAmount;
    }

    public Boolean getCollectable() {
        return this.collectable;
    }
    public void setCollectable(Boolean collectable) {
        this.collectable = collectable;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getProgress() {
        return this.progress;
    }
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Map<String, Float> getResources() {
        return this.resourceChances;
    }
    public void setResources(Map<String, Float> resourceChances) {
        this.resourceChances = resourceChances;
    }

    public Map<String, ResourceQuantity> getStorage() {
        return this.storage;
    }
    public void setStorage(Map<String, ResourceQuantity> storage) {
        this.storage = storage;
    }

    public Boolean getInProgress() {
        return this.inProgress;
    }
    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Boolean getCollected() {
        return this.collected;
    }
    public void setCollected(Boolean collected) {
        this.collected = collected;
    }

    public Integer getAssignedMonks() {
        return this.assignedMonks;
    }
    public void setAssignedMonks(Integer assignedMonks) {
        this.assignedMonks = assignedMonks;
    }
}

