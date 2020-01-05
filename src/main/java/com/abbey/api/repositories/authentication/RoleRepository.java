package com.abbey.api.repositories.authentication;

import com.abbey.api.models.authentication.ERole;
import com.abbey.api.models.authentication.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(ERole role);
    Role findById(Integer id);
}
