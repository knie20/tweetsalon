package edu.uc.it4045.tweetSalon.network;

import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwitterAPICallerTest {
    @Test
    void sendGetRequest() {
        TwitterAPICaller caller = new TwitterAPICaller();
        JSONObject user = caller.sendGetRequest("https://api.twitter.com/1.1/users/show.json?screen_name=twitterdev");
        System.out.println(user);
    }

}