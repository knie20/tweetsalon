package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.Tweet;

import java.util.List;

public interface ITweetDAO {
    void addTweet(Tweet tweet);

    Tweet fetchTweetById(long tweetId);

    List<Tweet> fetchTweetsByUserId(long userId);

    void updateTweetById(long tweetId, Tweet tweet);

    void removeTweetById(long tweetId);

    void removeTweetByUser(long userId);

    void closeSession();
}
