package com.abbey.api.repositories;

import com.abbey.api.models.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BeerRepository extends MongoRepository<Beer,String> {
    Beer getBy_id(String _id);
}
