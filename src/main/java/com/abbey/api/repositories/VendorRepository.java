package com.abbey.api.repositories;

import com.abbey.api.models.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Vendor getBy_id(String _id);
}
