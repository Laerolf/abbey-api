package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Transmutation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransmutationRepository extends MongoRepository<Transmutation, String> {
    Transmutation getBy_id(String _id);
    Transmutation getByName(String name);
}
