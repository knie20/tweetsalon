package edu.uc.it4045.tweetSalon.service;

import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.json.JSONObject;

public interface IUserService {
    TwitterUser getUserFromAPI(String handle);
    TwitterUser createUserFromJSON(JSONObject twitterUserJSON);
    Tweet createTweetFromJSON(JSONObject tweetJSON);
}
