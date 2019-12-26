package com.abbey.api.repositories.authentication;

import com.abbey.api.models.authentication.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
    Role findBy_Id(String _id);
}
