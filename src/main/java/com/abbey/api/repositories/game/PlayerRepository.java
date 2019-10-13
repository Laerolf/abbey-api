package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Player getBy_id(String _id);
}
