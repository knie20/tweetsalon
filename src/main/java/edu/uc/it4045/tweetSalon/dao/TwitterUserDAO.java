package edu.uc.it4045.tweetSalon.dao;

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
     * @param id the Id of the user to be retrieved
     * @return
     */
    public TwitterUser fetchUserById(int id){
        return (TwitterUser) session.get(TwitterUser.class, id);
    }

    /**
     * retrieve user from database with given handle. returns null if user doesn't exist
     * @param handle the handle of the user to be retrieved
     * @return TwitterUser object
     */
    public TwitterUser fetchUserByHandle(String handle){
        Query query = session.createQuery("from twitter_users where handle = :handle");
        query.setParameter("handle", handle);
        return (TwitterUser) query.list().get(0);
    }

    /**
     * update user information with given TwitterUser object
     * @param userId the id of the user to be updated
     * @param user the TwitterUser object to update the user row with
     */
    public void updateUserById(String userId, TwitterUser user){
        Query query = session.createQuery("update twitter_users " +
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
    public void deleteUserById(String userId){
        Query query = session.createQuery("delete from twitter_users where userId = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    /**
     * remove user with given handle from DB
     * @param handle
     */
    public void deleteUserByHandle(String handle){
        Query query = session.createQuery("delete from twitter_users where handle = :handle");
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
