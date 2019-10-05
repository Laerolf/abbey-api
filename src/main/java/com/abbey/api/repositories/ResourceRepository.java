package com.abbey.api.repositories;

import com.abbey.api.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceRepository extends MongoRepository<Resource, String> {
    Resource getBy_id(String _id);
}
