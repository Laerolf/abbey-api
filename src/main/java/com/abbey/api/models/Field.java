package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Builder
public class Field {

    @Id
    private String _id;

    private Integer harvestAmount;
    private Boolean harvestable;
    private String number;
    private Integer progress;
    private String resource;

    @Builder.Default
    private Map<String, Integer> fieldValue;

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getHarvestAmount() {
        return this.harvestAmount;
    }
    public void setHarvestAmount(Integer harvestAmount) {
        this.harvestAmount = harvestAmount;
    }

    public Boolean getHarvestable() {
        return this.harvestable;
    }
    public void setHarvestable(Boolean harvestable) {
        this.harvestable = harvestable;
    }

    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getProgress() {
        return this.progress;
    }
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getResource() {
        return this.resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Map<String, Integer> getFieldValue() {
        return this.fieldValue;
    }
    public void setFieldValue(Map<String, Integer> fieldValue) {
        this.fieldValue = fieldValue;
    }
}
