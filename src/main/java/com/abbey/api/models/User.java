package com.abbey.api.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Builder
public class User {

    @Id
    private String _id;

    private String username;
    private String password;
    private Date registrationDate;
    private Date lastLoginDate;

    private String gameId;
    private String playerId;

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getGameId() {
        return this.gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return this.playerId;
    }
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
