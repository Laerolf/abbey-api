package com.abbey.api.repositories.game;

import com.abbey.api.models.game.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, String> {
    Story getBy_id(String _id);
}
