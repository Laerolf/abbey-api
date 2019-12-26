package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "transmutations")
@Data
public class Transmutation {

    @Id
    private String _id;

    private String name;

    @Builder.Default
    private List<ResourceQuantity> input = new ArrayList<>();

    @Builder.Default
    private List<ResourceQuantity> output = new ArrayList<>();

    private String category;

    @Builder
    public Transmutation(){
        this._id = ObjectId.get().toHexString();
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

    public List<ResourceQuantity> getInput() {
        return this.input;
    }
    public void setInput(List<ResourceQuantity> input) {
        this.input = input;
    }

    public List<ResourceQuantity> getOutput() {
        return this.output;
    }
    public void setOutput(List<ResourceQuantity> output) {
        this.output = output;
    }

    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
