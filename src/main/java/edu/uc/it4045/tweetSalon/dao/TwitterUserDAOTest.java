package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.ITwitterUser;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TwitterUserDAOTest {
    TwitterUser user1 = new TwitterUser(0,
            Calendar.getInstance(),
            Calendar.getInstance(),
            "hi",
            "hi",
            "one",
            "hi",
            "hi",
            "hi",
            "hi",
            "hi",
            "hi",
            1,
            1,
            1,
            1,
            1,
            false,
            false);
    TwitterUser user2 = new TwitterUser(1,
            Calendar.getInstance(),
            Calendar.getInstance(),
            "hi",
            "hi",
            "two",
            "hi",
            "hi",
            "hi",
            "hi",
            "hi",
            "hi",
            1,
            1,
            1,
            1,
            1,
            false,
            false);
    @Test
    void addUser() {
        TwitterUserDAO dao = new TwitterUserDAO();

        dao.addUser((TwitterUser) user1);
    }

    @Test
    void fetchUserById() {
        ITwitterUserDAO dao = new TwitterUserDAO();
        TwitterUser user = dao.fetchUserById(1);
        System.out.println(user);
    }

    @Test
    void fetchUserByHandle() {
        ITwitterUserDAO dao = new TwitterUserDAO();
        System.out.println(dao.fetchUserByHandle("one"));
    }

    @Test
    void updateUserById() {
        ITwitterUserDAO dao = new TwitterUserDAO();
        dao.updateUserById(1, user2);
    }

    @Test
    void deleteUserById() {
        ITwitterUserDAO dao = new TwitterUserDAO();
        dao.deleteUserById(1);
    }

    @Test
    void deleteUserByHandle() {
        ITwitterUserDAO dao = new TwitterUserDAO();
        dao.deleteUserByHandle("hi");
    }

    @Test
    void closeSession() {
    }

}