package edu.uc.it4045.tweetSalon.dto;

import java.io.Serializable;
import java.util.Calendar;

public class Tweet implements ITweet {
    private long tweetId;
    private long userId;
    private Calendar createdAt;
    private Calendar accessedAt;
    private String text;
    private String source;
    private String lang;
    private Boolean isQuoteTweet;
    private long quotedId;
    private Boolean isRetweet;
    private long retweetedId;
    private int quoteCount;
    private int retweetCount;
    private int replyCount;
    private int favoriteCount;
    private String hashtags;
    private String userMentions;
    private String urls;
    private String symbols;

    public Tweet(String tweetId) { }

    public Tweet(long tweetId,
                 long userId,
                 Calendar createdAt,
                 Calendar accessedAt,
                 String text,
                 String source,
                 String lang,
                 Boolean isQuoteTweet,
                 long quotedId,
                 Boolean isRetweet,
                 long retweetedId,
                 int quoteCount,
                 int retweetCount,
                 int replyCount,
                 int favoriteCount,
                 String hashtags,
                 String userMentions,
                 String urls,
                 String symbols) {
        this.tweetId = tweetId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.accessedAt = accessedAt;
        this.text = text;
        this.source = source;
        this.lang = lang;
        this.isQuoteTweet = isQuoteTweet;
        this.quotedId = quotedId;
        this.isRetweet = isRetweet;
        this.retweetedId = retweetedId;
        this.quoteCount = quoteCount;
        this.retweetCount = retweetCount;
        this.replyCount = replyCount;
        this.favoriteCount = favoriteCount;
        this.hashtags = hashtags;
        this.userMentions = userMentions;
        this.urls = urls;
        this.symbols = symbols;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
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

    public Calendar getAccessedAt() {
        return accessedAt;
    }

    public void setAccessedAt(Calendar accessedAt) {
        this.accessedAt = accessedAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getIsQuoteTweet() {
        return isQuoteTweet;
    }

    public void setIsQuoteTweet(Boolean quoteTweet) {
        isQuoteTweet = quoteTweet;
    }

    public int getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(int quoteCount) {
        this.quoteCount = quoteCount;
    }

    public long getQuotedId() {
        return quotedId;
    }

    public void setQuotedId(long quotedId) {
        this.quotedId = quotedId;
    }

    public Boolean getIsRetweet() {
        return isRetweet;
    }

    public void setIsRetweet(Boolean retweet) {
        isRetweet = retweet;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public long getRetweetedId() {
        return retweetedId;
    }

    public void setRetweetedId(long retweetedId) {
        this.retweetedId = retweetedId;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public String getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(String userMentions) {
        this.userMentions = userMentions;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }
}
