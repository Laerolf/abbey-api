package com.abbey.api.repositories;

import com.abbey.api.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Player getBy_id(String _id);
}
