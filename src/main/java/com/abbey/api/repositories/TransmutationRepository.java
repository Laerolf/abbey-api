package com.abbey.api.repositories;

import com.abbey.api.models.Transmutation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransmutationRepository extends MongoRepository<Transmutation, String> {
    Transmutation getBy_id(String _id);
}
