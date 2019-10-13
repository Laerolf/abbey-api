package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    Recipe getBy_id(String _id);
    Recipe getByName(String name);
}
