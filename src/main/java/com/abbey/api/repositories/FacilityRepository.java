package com.abbey.api.repositories;

import com.abbey.api.models.Facility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacilityRepository extends MongoRepository<Facility,String> {
    Facility getBy_id(String _id);
}
