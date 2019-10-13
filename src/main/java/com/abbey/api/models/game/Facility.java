package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Facility {

    @Id
    private String _id;

    private Double collectAmount;
    private Boolean collectable;
    private String name;
    private Integer progress;
    @Builder.Default
    private List<ResourceChance> resourceChances = new ArrayList<>();
    @Builder.Default
    private Map<String, ResourceQuantity> storage = new HashMap<>();
    private Boolean inProgress;
    private Boolean collected;
    private Integer assignedMonks;

    @Builder
    public Facility(){
        this._id = ObjectId.get().toHexString();
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Double getCollectAmount() {
        return this.collectAmount;
    }
    public void setCollectAmount(Double collectAmount) {
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

    public List<ResourceChance> getResources() {
        return this.resourceChances;
    }
    public void setResources(List<ResourceChance> resourceChances) {
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

