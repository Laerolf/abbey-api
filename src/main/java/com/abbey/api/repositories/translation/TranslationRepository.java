package com.abbey.api.repositories.translation;

import com.abbey.api.models.translation.Translation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TranslationRepository extends MongoRepository<Translation, String> {
    Translation getByLanguage(String language);
}
