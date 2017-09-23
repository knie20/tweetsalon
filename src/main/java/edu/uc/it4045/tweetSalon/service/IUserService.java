package edu.uc.it4045.tweetSalon.service;

import edu.uc.it4045.tweetSalon.dto.SimpleTwitterUser;
import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;

public interface IUserService {
    /**
     * use provided handle to retrieve an user from the REST API, then converting it to TwitterUser
     * @param handle: the handle of the user
     * @return TwitterUser Object
     */
    TwitterUser getUserFromAPIByHandle(String handle);

    /**
     * use provided ID to retrieve an user from the REST API, then converting it to TwitterUser
     * @param userId: the ID of the user
     * @returnTwitterUser Object
     */
    TwitterUser getUserFromAPIById(String userId);

    /**
     * use provided handle to retrieve TwitterUser from DAO
     * @param handle the handle of the user
     * @return TwitterUser Object
     * @throws FileNotFoundException
     * @throws JSONException
     */
    SimpleTwitterUser getUserFromDBByHandle(String handle) throws FileNotFoundException, JSONException;

    /**
     * use provided ID to retrieve TwitterUser from DAO
     * @param userId: the ID of the user
     * @return TwitterUser Object
     * @throws FileNotFoundException
     * @throws JSONException
     */
    SimpleTwitterUser getUserFromDBById(String userId) throws FileNotFoundException, JSONException;

    /**
     * converts a JSON Object of an user to TwitterUser Object
     * @param twitterUserJSON: JSONObject of user
     * @return TwitterUser Object
     * @throws JSONException
     */
    SimpleTwitterUser createUserFromJSON(JSONObject twitterUserJSON) throws JSONException;

    /**
     * converts a JSON Object of a tweet to TwitterUser Object
     * @param tweetJSON: JSONObject of tweet
     * @return
     */
    Tweet createTweetFromJSON(JSONObject tweetJSON);
}
