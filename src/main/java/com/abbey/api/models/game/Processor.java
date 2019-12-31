package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "processors")
@Data
public class Processor {

    @Id
    private String _id;

    private String name;
    private String mapName;

    @Builder.Default
    private Map<String, Object> selectedInput = new HashMap<>();

    @Builder.Default
    private List<String> input = new ArrayList<>();

    @Builder
    public Processor () {
        this._id = ObjectId.get().toHexString();
        this.selectedInput.put("resource", null);
        this.selectedInput.put("amount", 0);
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

    public String getMapName() {
        return this.mapName;
    }
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public List<String> getInput() {
        return this.input;
    }
    public void setInput(List<String> input) {
        this.input = input;
    }

    public Map<String, Object> getSelectedInput() {
        return this.selectedInput;
    }
    public void setSelectedInput(Map<String, Object> selectedInput) {
        this.selectedInput = selectedInput;
    }
}
