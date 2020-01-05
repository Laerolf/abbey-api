package com.abbey.api.models.authentication;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Entity
@Document(collection = "roles")
@Data
public class Role {

    @Id
    private String id;

    private ERole name;

    public Role() {
        this.id = ObjectId.get().toHexString();
    }

    public Role(ERole name) {
        this.id = ObjectId.get().toHexString();
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }
    public void setName(ERole name) {
        this.name = name;
    }
}
