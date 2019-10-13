package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceRepository extends MongoRepository<Resource, String> {
    Resource getBy_id(String _id);
    Resource getByName(String name);
}
