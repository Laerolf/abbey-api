package com.abbey.api.models;

import lombok.Builder;

@Builder
public class StoryAnswers {

    private String abbotName;
    private Boolean boughtBeer;
    private String fatherName;
    private String gender;
    private Boolean likeStory;
    private Boolean listenedToStory;
    private String placeName;
    private String playerName;
    private String randomFact;

    public String getAbbotName() {
        return this.abbotName;
    }
    public void setAbbotName(String abbotName) {
        this.abbotName = abbotName;
    }

    public Boolean getBoughtBeer() {
        return this.boughtBeer;
    }
    public void setBoughtBeer(Boolean boughtBeer) {
        this.boughtBeer = boughtBeer;
    }

    public String getFatherName() {
        return this.fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getLikeStory() {
        return this.likeStory;
    }
    public void setLikeStory(Boolean likeStory) {
        this.likeStory = likeStory;
    }

    public Boolean getListenedToStory() {
        return this.listenedToStory;
    }
    public void setListenedToStory(Boolean listenedToStory) {
        this.listenedToStory = listenedToStory;
    }

    public String getPlaceName() {
        return this.placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlayerName() {
        return this.playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRandomFact() {
        return this.randomFact;
    }
    public void setRandomFact(String randomFact) {
        this.randomFact = randomFact;
    }
}
