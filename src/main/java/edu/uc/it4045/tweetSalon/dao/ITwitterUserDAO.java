package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.TwitterUser;

public interface ITwitterUserDAO {
    void addUser(TwitterUser user);

    public Boolean dbHasUser(long userId);

    public Boolean dbHasUser(String handle);

    TwitterUser fetchUserById(long userId);

    TwitterUser fetchUserByHandle(String handle);

    void updateUserById(long userId, TwitterUser user);

    void deleteUserById(long userId);

    void deleteUserByHandle(String handle);

    void closeSession();
}
