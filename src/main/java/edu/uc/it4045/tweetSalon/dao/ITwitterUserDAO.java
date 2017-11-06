package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.TwitterUser;

public interface ITwitterUserDAO {
    void addUser(TwitterUser user);

    TwitterUser fetchUserById(int id);

    TwitterUser fetchUserByHandle(String handle);

    void updateUserById(String userId, TwitterUser user);

    void deleteUserById(String userId);

    void deleteUserByHandle(String handle);

    void closeSession();
}
