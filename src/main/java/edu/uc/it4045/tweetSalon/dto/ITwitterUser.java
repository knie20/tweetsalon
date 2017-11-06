package edu.uc.it4045.tweetSalon.dto;

import java.io.Serializable;
import java.util.Calendar;

public interface ITwitterUser extends Serializable {
    long getUserId();

    void setUserId(long userId);

    Calendar getCreatedAt();

    void setCreatedAt(Calendar createdAt);

    Calendar getAccessedAt();

    void setAccessedAt(Calendar accessedAt);

    String getTimeZone();

    void setTimeZone(String timeZone);

    String getDisplayName();

    void setDisplayName(String displayName);

    String getHandle();

    void setHandle(String handle);

    String getLang();

    void setLang(String lang);

    String getAssociatedUrl();

    void setAssociatedUrl(String associatedUrl);

    String getProfileImageUrl();

    void setProfileImageUrl(String profileImageUrl);

    String getProfileSidebarBorderColor();

    void setProfileSidebarBorderColor(String profileSidebarBorderColor);

    String getProfileSidebarFillColor();

    void setProfileSidebarFillColor(String profileSidebarFillColor);

    String getDescription();

    void setDescription(String description);

    int getFollowerCount();

    void setFollowerCount(int followerCount);

    int getFriendCount();

    void setFriendCount(int friendCount);

    int getStatusesCount();

    void setStatusesCount(int statusesCount);

    int getFavoritesCount();

    void setFavoritesCount(int favoritesCount);

    int getListedCount();

    void setListedCount(int listedCount);

    Boolean getAccountIsProtected();

    void setAccountIsProtected(Boolean accountIsProtected);

    Boolean getAccountIsVerified();

    void setAccountIsVerified(Boolean accountIsVerified);
}
