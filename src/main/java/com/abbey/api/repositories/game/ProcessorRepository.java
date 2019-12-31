package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Processor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessorRepository extends MongoRepository<Processor,String> {
    Processor getBy_id(String _id);
    Processor getByName(String name);
}
