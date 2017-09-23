package edu.uc.it4045.tweetSalon.service;

import edu.uc.it4045.tweetSalon.dao.IUserDAO;
import edu.uc.it4045.tweetSalon.dao.UserDAO;
import edu.uc.it4045.tweetSalon.dto.SimpleTwitterUser;
import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;

public class UserService implements IUserService {

    IUserDAO userDAO = new UserDAO();

    public UserService() throws FileNotFoundException {
    }

    public TwitterUser getUserFromAPIByHandle(String handle) {
        return null;
    }

    public TwitterUser getUserFromAPIById(String userId) {
        return null;
    }

    public SimpleTwitterUser getUserFromDBByHandle(String handle){
        JSONObject JSONUser;
        SimpleTwitterUser user = null;
        try{
            JSONUser = userDAO.fetchUserByHandle(handle);
            user = createUserFromJSON(JSONUser);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }

    public SimpleTwitterUser getUserFromDBById(String userId){
        JSONObject JSONUser;
        SimpleTwitterUser user = null;
        try{
            JSONUser = userDAO.fetchUserById(userId);
            user = createUserFromJSON(JSONUser);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;

    }

    public SimpleTwitterUser createUserFromJSON(JSONObject twitterUserJSON) throws JSONException {
        SimpleTwitterUser user = new SimpleTwitterUser((String) twitterUserJSON.get("id_str"), (String) twitterUserJSON.get("screen_name"));
        return user;
    }

    public Tweet createTweetFromJSON(JSONObject tweetJSON) {
        return null;
    }
}
