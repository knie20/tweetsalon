package edu.uc.it4045.tweetSalon.dto;

import java.util.Calendar;
import java.util.List;

public class TwitterUser implements ITwitterUser {
    private long userId;
    private Calendar createdAt;
    private String displayName;
    private String handle;
    private String lang;
    private String associatedUrl;
    private String profileImageUrl;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String description;
    private int followerCount;
    private int friendCount;
    private int statusesCount;
    private int favoritesCount;
    private int listedCount;
    private Boolean accountIsProtected;
    private Boolean accountIsVerified;

    public TwitterUser() {}

    public TwitterUser(long userId, Calendar createdAt, String displayName, String handle, String lang, String associatedUrl, String profileImageUrl, String profileSidebarBorderColor, String profileSidebarFillColor, String description, int followerCount, int friendCount, int statusesCount, int favoritesCount, int listedCount, Boolean accountIsProtected, Boolean accountIsVerified) {
        this.userId = userId;
        this.createdAt = createdAt;
        this.displayName = displayName;
        this.handle = handle;
        this.lang = lang;
        this.associatedUrl = associatedUrl;
        this.profileImageUrl = profileImageUrl;
        this.profileSidebarBorderColor = profileSidebarBorderColor;
        this.profileSidebarFillColor = profileSidebarFillColor;
        this.description = description;
        this.followerCount = followerCount;
        this.friendCount = friendCount;
        this.statusesCount = statusesCount;
        this.favoritesCount = favoritesCount;
        this.listedCount = listedCount;
        this.accountIsProtected = accountIsProtected;
        this.accountIsVerified = accountIsVerified;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAssociatedUrl() {
        return associatedUrl;
    }

    public void setAssociatedUrl(String associatedUrl) {
        this.associatedUrl = associatedUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(int friendCount) {
        this.friendCount = friendCount;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public int getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(int favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    public Boolean getAccountIsProtected() {
        return accountIsProtected;
    }

    public void setAccountIsProtected(Boolean accountIsProtected) {
        this.accountIsProtected = accountIsProtected;
    }

    public Boolean getAccountIsVerified() {
        return accountIsVerified;
    }

    public void setAccountIsVerified(Boolean accountIsVerified) {
        this.accountIsVerified = accountIsVerified;
    }
}
