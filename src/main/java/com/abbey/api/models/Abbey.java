package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

public class Abbey {

    @Id
    private String _id;

    @Builder.Default
    private Map<String, Department> departments = new HashMap<>();
    private Schedule schedule;
    private int totalAmtOfMonks;

    @Builder
    public Abbey (String _id, Map<String, Department> departments, Schedule schedule, int totalAmtOfMonks){
        this._id = _id;
        this.departments = departments;
        this.schedule = schedule;
        this.totalAmtOfMonks = totalAmtOfMonks;
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id){
        this._id = _id;
    }

    public Map<String, Department> getDepartments() {
        return this.departments;
    }
    public void setDepartments(Map<String, Department> departments) {
        this.departments = departments;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getTotalAmtOfMonks() {
        return this.totalAmtOfMonks;
    }
    public void setTotalAmtOfMonks(int totalAmtOfMonks) {
        this.totalAmtOfMonks = totalAmtOfMonks;
    }
}
