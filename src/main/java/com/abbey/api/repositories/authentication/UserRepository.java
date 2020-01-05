package com.abbey.api.repositories.authentication;

import com.abbey.api.models.authentication.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User getById(Long id);
    User getByUsername(String username);
    User findByUsername(String username);
}
