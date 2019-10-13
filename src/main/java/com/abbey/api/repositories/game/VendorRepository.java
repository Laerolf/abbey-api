package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Vendor getBy_id(String _id);
    Vendor getByName(String name);
}
