package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

public class Schedule {

    @Id
    private String _id;

    private Integer time;
    private String chore;

    @Builder
    public Schedule(String _id, Integer time, String chore) {
        this._id = _id;
        this.time = time;
        this.chore = chore;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getTime() {
        return this.time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }

    public String getChore() {
        return this.chore;
    }
    public void setChore(String chore) {
        this.chore = chore;
    }
}
