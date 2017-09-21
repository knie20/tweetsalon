package edu.uc.it4045.tweetSalon.dto;

import java.util.List;

public class Tweet {
    private String tweetId;
    private String createdAt;
    private String text;
    private String sourceHTML;
    private boolean isRetweet;
    private int retweetCount;
    private int favoriteCount;
    private List hashtags;
    private List UserMentions;
    private List urls;
    private List symbols;

    public Tweet(String tweetId) {
    }

    public Tweet(String tweetId, String createdAt, String text, String sourceHTML, boolean isRetweet, int retweetCount, int favoriteCount, List hashtags, List userMentions, List urls, List symbols) {
        this.tweetId = tweetId;
        this.createdAt = createdAt;
        this.text = text;
        this.sourceHTML = sourceHTML;
        this.isRetweet = isRetweet;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
        this.hashtags = hashtags;
        UserMentions = userMentions;
        this.urls = urls;
        this.symbols = symbols;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSourceHTML() {
        return sourceHTML;
    }

    public void setSourceHTML(String sourceHTML) {
        this.sourceHTML = sourceHTML;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public List getHashtags() {
        return hashtags;
    }

    public void setHashtags(List hashtags) {
        this.hashtags = hashtags;
    }

    public List getUserMentions() {
        return UserMentions;
    }

    public void setUserMentions(List userMentions) {
        UserMentions = userMentions;
    }

    public List getUrls() {
        return urls;
    }

    public void setUrls(List urls) {
        this.urls = urls;
    }

    public List getSymbols() {
        return symbols;
    }

    public void setSymbols(List symbols) {
        this.symbols = symbols;
    }
}
