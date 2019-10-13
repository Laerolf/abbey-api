package com.abbey.api.repositories.game;

import com.abbey.api.models.game.BreweryProcessor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BreweryProcessorRepository extends MongoRepository<BreweryProcessor, String> {
    BreweryProcessor getBy_id(String _id);
    BreweryProcessor getByName(String name);
}
