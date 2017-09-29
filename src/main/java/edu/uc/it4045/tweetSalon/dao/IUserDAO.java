package edu.uc.it4045.tweetSalon.dao;

import org.json.JSONObject;

public interface IUserDAO {

    /**
     * use an user's ID to get the corresponding TwitterUser Object from the Database
     * @param userId: ID of user
     * @return TwitterUser Object
     */
    JSONObject fetchUserById(String userId);

    /**
     * use an user's handle to get the corresponding TwitterUser Object from the Database
     * @param handle: handle of user
     * @return TwitterUser Object
     */
    JSONObject fetchUserByHandle(String handle);
}
