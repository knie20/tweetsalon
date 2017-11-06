package edu.uc.it4045.tweetSalon.dto;

import java.io.Serializable;
import java.util.Calendar;

public interface ITweet extends Serializable {
    long getTweetId();

    void setTweetId(long tweetId);

    long getUserId();

    void setUserId(long userId);

    Calendar getCreatedAt();

    void setCreatedAt(Calendar createdAt);

    Calendar getAccessedAt();

    void setAccessedAt(Calendar accessedAt);

    String getText();

    void setText(String text);

    String getSource();

    void setSource(String source);

    String getLang();

    void setLang(String lang);

    Boolean getIsQuoteTweet();

    void setIsQuoteTweet(Boolean quoteTweet);

    int getQuoteCount();

    void setQuoteCount(int quoteCount);

    long getQuotedId();

    void setQuotedId(long quotedId);

    Boolean getIsRetweet();

    void setIsRetweet(Boolean retweet);

    int getRetweetCount();

    void setRetweetCount(int retweetCount);

    long getRetweetedId();

    void setRetweetedId(long retweetedId);

    int getReplyCount();

    void setReplyCount(int replyCount);

    int getFavoriteCount();

    void setFavoriteCount(int favoriteCount);

    String getHashtags();

    void setHashtags(String hashtags);

    String getUserMentions();

    void setUserMentions(String userMentions);

    String getUrls();

    void setUrls(String urls);

    String getSymbols();

    void setSymbols(String symbols);
}
