package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeerRepository extends MongoRepository<Beer,String> {
    Beer getBy_id(String _id);
    Beer getByMapName(String mapName);
    Beer getByName(String name);
}
