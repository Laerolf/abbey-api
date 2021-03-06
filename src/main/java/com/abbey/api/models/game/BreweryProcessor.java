package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "brewery-processors")
@Data
public class BreweryProcessor {

    @Id
    private String _id;

    private Boolean gainable;

    @Builder.Default
    private List<ResourceQuantity> input = new ArrayList<>();
    private String name;

    @Builder.Default
    private List<ResourceQuantity> output = new ArrayList<>();
    private Integer progress;

    @Builder
    public BreweryProcessor (){
        this._id = ObjectId.get().toHexString();
    }

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Boolean getGainable() {
        return this.gainable;
    }
    public void setGainable(Boolean gainable) {
        this.gainable = gainable;
    }

    public List<ResourceQuantity> getInput() {
        return this.input;
    }
    public void setInput(List<ResourceQuantity> input) {
        this.input = input;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<ResourceQuantity> getOutput() {
        return this.output;
    }
    public void setOutput(List<ResourceQuantity> output) {
        this.output = output;
    }

    public Integer getProgress() {
        return this.progress;
    }
    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
