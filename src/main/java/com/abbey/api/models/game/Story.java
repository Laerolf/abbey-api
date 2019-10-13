package com.abbey.api.models.game;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class Story {

    @Id
    private String _id;

    @Builder.Default
    private Map<String, String> chapters = new HashMap<>();

    @Builder.Default
    private List<String> randomFacts = new ArrayList<>();

    @Builder.Default
    private List<String> abbotNames = new ArrayList<>();

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

    public List<String> getRandomFacts() {
        return this.randomFacts;
    }
    public void setRandomFacts(List<String> randomFacts) {
        this.randomFacts = randomFacts;
    }

    public List<String> getAbbotNames() {
        return this.abbotNames;
    }
    public void setAbbotNames(List<String> abbotNames) {
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
