package com.abbey.api.models.game;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Workbench {

    @Id
    private String _id;

    @Builder.Default
    private List<WorkbenchSlot> slots = new ArrayList<>();

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public List<WorkbenchSlot> getSlots() {
        return this.slots;
    }
    public void setSlots(List<WorkbenchSlot> slots) {
        this.slots = slots;
    }
}
