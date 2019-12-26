package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Schedule {

    @Id
    private String _id;

    private Chore currentChore;
    private Map<String, Chore> chores;

    @Builder
    public Schedule(String _id, Chore currentChore, Map<String, Chore> chores) {
        this._id = _id;
        this.currentChore = currentChore;
        this.chores = chores;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Chore getCurrentChore() {
        return this.currentChore;
    }
    public void setCurrentChore(Chore currentChore) {
        this.currentChore = currentChore;
    }

    public Map<String, Chore> getChores(){
        return this.chores;
    }
    public void setChores(Map<String, Chore> chores){
        this.chores = chores;
    }
}
