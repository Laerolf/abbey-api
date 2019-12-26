package com.abbey.api.models.game;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "stories")
@Data
@Builder
public class Story {

    @Id
    private String _id;

    @Builder.Default
    private Map<String, String> chapters;

    @Builder.Default
    private Map<String, String> randomFacts;

    @Builder.Default
    private Map<String, String> abbotNames;

    private StoryAnswers storyAnswers;
    private Boolean completeStory;

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public Map<String, String> getChapters() {
        return this.chapters;
    }
    public void setChapters(Map<String, String> chapters) {
        this.chapters = chapters;
    }

    public Map<String, String> getRandomFacts() {
        return this.randomFacts;
    }
    public void setRandomFacts(Map<String, String> randomFacts) {
        this.randomFacts = randomFacts;
    }

    public Map<String, String> getAbbotNames() {
        return this.abbotNames;
    }
    public void setAbbotNames(Map<String, String> abbotNames) {
        this.abbotNames = abbotNames;
    }

    public StoryAnswers getStoryAnswers() {
        return this.storyAnswers;
    }
    public void setStoryAnswers(StoryAnswers storyAnswers) {
        this.storyAnswers = storyAnswers;
    }

    public Boolean getCompleteStory() {
        return this.completeStory;
    }
    public void setCompleteStory(Boolean completeStory) {
        this.completeStory = completeStory;
    }
}
