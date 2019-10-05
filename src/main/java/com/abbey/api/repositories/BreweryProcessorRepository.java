package com.abbey.api.repositories;

import com.abbey.api.models.BreweryProcessor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BreweryProcessorRepository extends MongoRepository<BreweryProcessor, String> {
    BreweryProcessor getBy_id(String _id);
}
