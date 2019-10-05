package com.abbey.api.repositories;

import com.abbey.api.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GameRepository extends MongoRepository<Game,String> {
    Game findBy_id(String id);
}
