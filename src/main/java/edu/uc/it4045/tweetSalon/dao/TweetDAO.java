package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.persistence.HibernateUtility;
import org.hibernate.Session;

public class TweetDAO {
    public void addTweet(Tweet tweet){
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tweet);
        session.getTransaction().commit();
        session.close();
    }
}
