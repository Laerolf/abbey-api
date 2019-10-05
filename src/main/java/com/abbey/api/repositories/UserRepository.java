package com.abbey.api.repositories;

import com.abbey.api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User getBy_id(String _id);
}
