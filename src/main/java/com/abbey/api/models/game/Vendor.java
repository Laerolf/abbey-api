package com.abbey.api.models.game;

import com.abbey.api.models.game.ItemForSale;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Vendor {

    @Id
    private String _id;

    private String name;
    private Double interestFactor;
    private List<String> interests;
    private List<ItemForSale> itemsForSale;
    private Integer reputationGiven;

    @Builder
    public Vendor (){
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

    public Double getInterestFactor() {
        return this.interestFactor;
    }
    public void setInterestFactor(Double interestFactor) {
        this.interestFactor = interestFactor;
    }

    public List<String> getInterests() {
        return this.interests;
    }
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<ItemForSale> getItemsForSale() {
        return this.itemsForSale;
    }
    public void setItemsForSale(List<ItemForSale> itemsForSale) {
        this.itemsForSale = itemsForSale;
    }

    public Integer getReputationGiven() {
        return this.reputationGiven;
    }
    public void setReputationGiven(Integer reputationGiven) {
        this.reputationGiven = reputationGiven;
    }
}
