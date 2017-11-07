package edu.uc.it4045.tweetSalon.network;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TwitterAPIAuthenticatorTest {
    @Test
    void obtainBearerToken() {
        try {
            TwitterAPIAuthenticator.cacheBearerToken(TwitterAPIAuthenticator.obtainBearerToken());
            String token = TwitterAPIAuthenticator.getBearerTokenFromCache();
            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}