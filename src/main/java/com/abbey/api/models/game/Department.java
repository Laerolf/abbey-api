package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
public class Department {

    @Id
    private String _id;

    private String name;
    private Integer monks;

    @Builder.Default
    private Map<String,Integer> assignedMonks = new HashMap<>();

    @Builder
    public Department(String _id, String name, Integer monks){
        this._id = _id;
        this.name = name;
        this.monks = monks;
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

    public Integer getMonks() {
        return this.monks;
    }
    public void setMonks(Integer monks) {
        this.monks = monks;
    }

    public Map<String, Integer> getAssignedMonks() {
        return this.assignedMonks;
    }
    public void setAssignedMonks(Map<String, Integer> assignedMonks) {
        this.assignedMonks = assignedMonks;
    }
}
