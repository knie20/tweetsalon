package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.Tweet;

import java.util.List;

public interface ITweetDAO {
    void addTweet(Tweet tweet);

    Tweet fetchTweetById(int tweetId);

    List<Tweet> fetchTweetsByUserId(String userId);

    void updateTweetById(String tweetId, Tweet tweet);

    void removeTweetById(String tweetId);

    void removeTweetByUser(String userId);

    void closeSession();
}
