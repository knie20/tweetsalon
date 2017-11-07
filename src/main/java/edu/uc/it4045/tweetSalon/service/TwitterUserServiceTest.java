package edu.uc.it4045.tweetSalon.service;

import edu.uc.it4045.tweetSalon.dto.ITwitterUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwitterUserServiceTest {
    @Test
    void getUserByHandle() {
        TwitterUserService userService = new TwitterUserService();
        ITwitterUser user = userService.getUserByHandle("realDonaldTrump");
        System.out.println(user);
    }

}