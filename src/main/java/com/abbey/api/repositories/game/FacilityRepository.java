package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Facility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacilityRepository extends MongoRepository<Facility,String> {
    Facility getBy_id(String _id);
    Facility getByName(String name);
}
