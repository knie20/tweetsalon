package edu.uc.it4045.tweetSalon.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.uc.it4045.tweetSalon.dto.ITwitterUser;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import edu.uc.it4045.tweetSalon.persistence.HibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * used to interact with the database with regards to the twitter_users table.
 */
public class TwitterUserDAO implements ITwitterUserDAO {
    private Session session;

    public TwitterUserDAO() {
        session = HibernateUtility.getSessionFactory().openSession();
    }

    /**
     * insert this TwitterUser into the twitter_users table
     * @param user the TwitterUser to be inserted
     */
    public void addUser(TwitterUser user){
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * check if the user exists by the given ID
     * @param userId
     * @return true if user exists, false if user does not
     */
    public Boolean dbHasUser(long userId){
        Query query = session.createQuery("from TwitterUser where userId = :userId");
        query.setParameter("userId", userId);
        if(query.list().get(0) == null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * check if the user exists by the given handle
     * @param handle
     * @return true if user exists, false if user does not
     */
    public Boolean dbHasUser(String handle){
        Query query = session.createQuery("from TwitterUser where handle = :handle");
        query.setParameter("handle", handle);
        System.out.println("traps are gay " + query.list());
        if(query.list().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    /**
     * get all users. not recommended for regular use
     * @return a List of all TwitterUsers in the database
     */
    public List<TwitterUser> fetchAllUsers(){
        List<TwitterUser> list = session.createCriteria(TwitterUser.class).list();
        session.close();
        return list;
    }

    /**
     * retrieve user by the given Id. returns null if user doesn't exist
     * @param userId the Id of the user to be retrieved
     * @return
     */
    public TwitterUser fetchUserById(long userId){
        return (TwitterUser) session.get(TwitterUser.class, userId);
    }

    /**
     * retrieve user from database with given handle. returns null if user doesn't exist
     * @param handle the handle of the user to be retrieved
     * @return TwitterUser object
     */
    public TwitterUser fetchUserByHandle(String handle){
        ITwitterUser user = null;
        Query query = session.createQuery("from TwitterUser where handle = :handle");
        query.setParameter("handle", handle);
        List list = query.list();

        if(!list.isEmpty()) {
            user = (ITwitterUser) query.list().get(0);
        }
        return (TwitterUser) user;
    }

    /**
     * update user information with given TwitterUser object
     * @param userId the id of the user to be updated
     * @param user the TwitterUser object to update the user row with
     */
    public void updateUserById(long userId, TwitterUser user){
        Query query = session.createQuery("update TwitterUser " +
                "set accessedAt = :accessedAt," +
                "set timeZone = :timeZone," +
                "set displayName = :displayName," +
                "set lang = :lang," +
                "set associatedUrl = : associatedUrl," +
                "set profileImageUrl = :profileImageUrl," +
                "set profileSidebarBorderColor = :profileSidebarBorderColor," +
                "set profileSidebarFillColor = :profileSidebarFillColor," +
                "set description = :description," +
                "set followerCount = :followerCount," +
                "set friendCount = :friendCount," +
                "set statusesCount = :statusesCount," +
                "set favoritesCount = :favoritesCount," +
                "set listedCount = :listedCount," +
                "set accountIsProtected = :accountIsProtected," +
                "set accountIsVerified = :accountIsVerified," +
                "where userId = :userId");
        query.setParameter("timeZone", user.getTimeZone())
                .setParameter("accessedAt", user.getAccessedAt())
                .setParameter("displayName", user.getDisplayName())
                .setParameter("lang", user.getLang())
                .setParameter("associatedUrl", user.getAssociatedUrl())
                .setParameter("profileImageUrl", user.getProfileImageUrl())
                .setParameter("profileSidebarBorderColor", user.getProfileSidebarBorderColor())
                .setParameter("profileSidebarFillColor", user.getProfileSidebarFillColor())
                .setParameter("description", user.getDescription())
                .setParameter("followerCount", user.getFollowerCount())
                .setParameter("friendCount", user.getFriendCount())
                .setParameter("statusesCount", user.getStatusesCount())
                .setParameter("favoritesCount", user.getFavoritesCount())
                .setParameter("listedCount", user.getListedCount())
                .setParameter("accountIsProtected", user.getAccountIsProtected())
                .setParameter("accountIsVerified", user.getAccountIsVerified())
                .setParameter("userId", userId);
        query.executeUpdate();
    }

    /**
     * remove user with given Id from DB
     * @param userId
     */
    public void deleteUserById(long userId){
        Query query = session.createQuery("delete TwitterUser where userId = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    /**
     * remove user with given handle from DB
     * @param handle
     */
    public void deleteUserByHandle(String handle){
        Query query = session.createQuery("delete TwitterUser where handle = :handle");
        query.setParameter("handle", handle);
        query.executeUpdate();
    }

    /**
     * closes the hibernate session. Call after finished with the DAO
     */
    public void closeSession(){
        session.close();
    }
}
