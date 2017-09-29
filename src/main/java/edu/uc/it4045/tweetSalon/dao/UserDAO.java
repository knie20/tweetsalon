package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserDAO implements IUserDAO {
    private File file;
    private Scanner reader;

    public UserDAO() throws FileNotFoundException {
        this.file = new File("/home/knie20/Documents/tweetSalon/src/main/java/edu/uc/it4045/tweetSalon/dao/users.json");
        this.reader = new Scanner(this.file);
    }

    /**
     *
     * @param userId
     * @return corresponding user as JSON Object
     */
    public JSONObject fetchUserById(String userId){
        JSONObject user = null;
        JSONObject retUser = null;
        JSONArray users = null;

        try {
            String str = reader.next();
            users = new JSONArray(str);
            for (int n = 0; n < users.length(); n++){
                user = users.getJSONObject(n);
                if (user.get("id_str").equals(userId)){
                    retUser = user;
                }
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return retUser;
    }

    public JSONObject fetchUserByHandle(String handle){
        JSONObject user = null;
        JSONObject retUser = null;

        try {
            String str = reader.useDelimiter("\\").next();
            System.out.println(str);
            user = new JSONObject(str);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return user;


    }
}
