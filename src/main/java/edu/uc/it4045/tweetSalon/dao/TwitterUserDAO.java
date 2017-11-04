package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import edu.uc.it4045.tweetSalon.persistence.HibernateUtility;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TwitterUserDAO {

    public void addUser(TwitterUser user){
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<TwitterUser> getAllUsers(){
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<TwitterUser> list = session.createCriteria(TwitterUser.class).list();
        session.close();
        return list;
    }

    public TwitterUser getUserById(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        return (TwitterUser) session.get(TwitterUser.class, id);
    }

    public TwitterUser getUserByHandle(String handle){
        Session session = HibernateUtility.getSessionFactory().openSession();
        return (TwitterUser) session.get(TwitterUser.class, handle);
    }
}
