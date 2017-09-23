package edu.uc.it4045.tweetSalon.dto;

import java.util.List;

public class TwitterUser implements ITwitterUser {
    private String userId;
    private String createdAt;
    private String name;
    private String handle;
    private List statuses;
    private int statusesCount;
    private int favoritesCount;


    public TwitterUser() {

    }

    public TwitterUser(String userId, String createdAt, String name, String handle, List statuses, int statusesCount, int favouritesCount) {
        this.userId = userId;
        this.createdAt = createdAt;
        this.name = name;
        this.handle = handle;
        this.statuses = statuses;
        this.statusesCount = statusesCount;
        this.favoritesCount = favouritesCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public List getStatuses() {
        return statuses;
    }

    public void setStatuses(List statuses) {
        this.statuses = statuses;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public int getFavouritesCount() {
        return favoritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favoritesCount = favouritesCount;
    }
}
