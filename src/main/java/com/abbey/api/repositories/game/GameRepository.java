package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game,String> {
    Game findBy_id(String id);
}
