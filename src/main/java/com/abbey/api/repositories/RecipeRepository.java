package com.abbey.api.repositories;

import com.abbey.api.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    Recipe getBy_id(String _id);
}
