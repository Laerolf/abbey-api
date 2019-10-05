package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Builder
public class Game {

    @Id
    private String _id;

    private Abbey abbey;
    private Brewery brewery;

    @Builder.Default
    private List<Field> fields = new ArrayList<>();

    @Builder.Default
    private Map<String, ResourceQuantity> stock;

    private Story story;
    private Workbench workbench;

    public Abbey getAbbey() {
        return this.abbey;
    }
    public void setAbbey(Abbey abbey) {
        this.abbey = abbey;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Brewery getBrewery() {
        return this.brewery;
    }
    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public List<Field> getFields() {
        return this.fields;
    }
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Map<String, ResourceQuantity> getStock() {
        return this.stock;
    }
    public void setStock(Map<String, ResourceQuantity> stock) {
        this.stock = stock;
    }

    public Story getStory() {
        return this.story;
    }
    public void setStory(Story story) {
        this.story = story;
    }

    public Workbench getWorkbench() {
        return this.workbench;
    }
    public void setWorkbench(Workbench workbench) {
        this.workbench = workbench;
    }
}
