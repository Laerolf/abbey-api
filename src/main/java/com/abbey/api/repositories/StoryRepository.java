package com.abbey.api.repositories;

import com.abbey.api.models.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, String> {
    Story getBy_id(String _id);
}
