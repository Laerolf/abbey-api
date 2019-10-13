package com.abbey.api.models.game;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.Map;

public class Schedule {

    @Id
    private String _id;

    private Map<String, Chore> chores;

    @Builder
    public Schedule(String _id, Map<String, Chore> chores) {
        this._id = _id;
        this.chores = chores;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Map<String, Chore> getChores(){
        return this.chores;
    }
    public void setChores(Map<String, Chore> chores){
        this.chores = chores;
    }
}
