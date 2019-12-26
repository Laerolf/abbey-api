package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "facilities")
@Data
public class Facility {

    @Id
    private String _id;

    private Boolean unlocked;
    private Double collectAmount;
    private Boolean collectable;
    private String name;
    private Integer progress;
    private Date lastTimeVisited;
    private Double progressStep;
    private int totalProcessTime;
    private int job;

    @Builder.Default
    private List<ResourceChance> resourceChances = new ArrayList<>();
    @Builder.Default
    private FacilityStorage storage = new FacilityStorage();

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

    public Boolean getUnlocked() {
        return this.unlocked;
    }
    public void setUnlocked(Boolean unlocked) {
        this.unlocked = unlocked;
    }

    public List<ResourceChance> getResourceChances() {
        return this.resourceChances;
    }
    public void setResourceChances(List<ResourceChance> resourceChances) {
        this.resourceChances = resourceChances;
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

    public Date getLastTimeVisited() {
        return this.lastTimeVisited;
    }
    public void setLastTimeVisited(Date lastTimeVisited) {
        this.lastTimeVisited = lastTimeVisited;
    }

    public Integer getProgress() {
        return this.progress;
    }
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Double getProgressStep() {
        return this.progressStep;
    }
    public void setProgressStep(Double progressStep) {
        this.progressStep = progressStep;
    }

    public int getTotalProcessTime() {
        return this.totalProcessTime;
    }
    public void setTotalProcessTime(int totalProcessTime) {
        this.totalProcessTime = totalProcessTime;
    }

    public int getJob() {
        return this.job;
    }
    public void setJob(int job) {
        this.job = job;
    }

    public FacilityStorage getStorage() {
        return this.storage;
    }
    public void setStorage(FacilityStorage storage) {
        this.storage = storage;
    }
}

