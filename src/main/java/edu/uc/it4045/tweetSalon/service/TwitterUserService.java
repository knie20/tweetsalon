package edu.uc.it4045.tweetSalon.service;

import edu.uc.it4045.tweetSalon.dao.ITwitterUserDAO;
import edu.uc.it4045.tweetSalon.dao.TwitterUserDAO;
import edu.uc.it4045.tweetSalon.dto.ITwitterUser;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import edu.uc.it4045.tweetSalon.network.ITwitterAPICaller;
import edu.uc.it4045.tweetSalon.network.TwitterAPICaller;
import edu.uc.it4045.tweetSalon.util.JSONMigrator;

public class TwitterUserService {
    private static final String userRequestUrl = "https://api.twitter.com/1.1/users/show.json";

    private ITwitterUserDAO userDAO;
    private ITwitterAPICaller apiCaller;

    public TwitterUserService() {
        this.userDAO = new TwitterUserDAO();
        this.apiCaller = new TwitterAPICaller();
    }

    public TwitterUser getUserByHandle(String handle){
        ITwitterUser user = null;
        String uri = userRequestUrl + "?" + "screen_name=" + handle;

        if(userDAO.dbHasUser(handle)){
            user = (TwitterUser) userDAO.fetchUserByHandle(handle);
        }else{
            user = JSONMigrator.migrateUserFromJSON(apiCaller.sendGetRequest(uri));
        }

        return (TwitterUser) user;
    }
}
