package edu.uc.it4045.tweetSalon.dao;

import edu.uc.it4045.tweetSalon.dto.ITweet;
import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.persistence.HibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * used to retrieve and store Tweet objects from and to the tweets table
 */
public class TweetDAO implements ITweetDAO {
    Session session;

    public TweetDAO() {
        this.session = HibernateUtility.getSessionFactory().openSession();
    }

    /**
     * add this tweet to the tweets table in the database
     * @param tweet
     */
    public void addTweet(Tweet tweet){
        session.beginTransaction();
        session.save(tweet);
        session.getTransaction().commit();
    }

    /**
     * get every tweet from the tweets table. Not recommended when the table is super large
     * @return
     */
    public List<Tweet> fetchAllTweets(){
        List<Tweet> list = session.createCriteria(Tweet.class).list();
        return list;
    }

    /**
     * get a tweet by its ID
     * @param tweetId ID for the tweet to be fetched
     * @return
     */
    public Tweet fetchTweetById(long tweetId){
        return (Tweet) session.get(Tweet.class, tweetId);
    }

    /**
     * get all tweets by this user stored in the database
     * @param userId
     * @return
     */
    public List<Tweet> fetchTweetsByUserId(long userId){
        Query query = session.createQuery("from Tweet where userId = :userId");
        query.setParameter("userId", userId);
        return query.list();
    }

    /**
     * update this tweet with fresh data from the API. should be called when the user is
     * requested and the data hasn't been updated for a long amount of time.
     * @param tweetId ID for the tweet to be updated
     * @param tweet the Tweet object used to update the corresponding row
     */
    public void updateTweetById(long tweetId, Tweet tweet){
        Query query = session.createQuery("update Tweet " +
                "set accessedAt = :accessedAt," +
                "set quoteCount = :quoteCount," +
                "set retweetCount = :retweetCount," +
                "set replyCount = :replyCount," +
                "set favoriteCount = : favoriteCount," +
                "where tweetId = :tweetId");
        query.setParameter("quoteCount", tweet.getQuoteCount())
                .setParameter("accessedAt", tweet.getAccessedAt())
                .setParameter("retweetCount", tweet.getRetweetCount())
                .setParameter("replyCount", tweet.getReplyCount())
                .setParameter("favoriteCount", tweet.getFavoriteCount())
                .setParameter("tweetId", tweetId);
        query.executeUpdate();
    }

    /**
     * remove this tweet from the DB
     * @param tweetId ID for the tweet in question
     */
    public void removeTweetById(long tweetId){
        Query query = session.createQuery("delete Tweet where tweetId = :tweetId");
        query.setParameter("tweetId", tweetId);
        query.executeUpdate();
    }

    /**
     * remove every tweet from this user from the DB
     * @param userId ID of the user in question
     */
    public void removeTweetByUser(long userId){
        Query query = session.createQuery("delete Tweet where userId = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    /**
     * closes the hibernate session. Call after finished with the DAO
     */
    public void closeSession(){
        session.close();
    }
}
