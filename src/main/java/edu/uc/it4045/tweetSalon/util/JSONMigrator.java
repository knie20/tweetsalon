package edu.uc.it4045.tweetSalon.util;

import edu.uc.it4045.tweetSalon.dto.ITweet;
import edu.uc.it4045.tweetSalon.dto.ITwitterUser;
import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

/**
 * helper class to convert JSON objects into DTO objects
 */
public class JSONMigrator {

    /**
     * Takes in a JSON object and instantiate a TwitterUser class
     * @param obj the JSON object
     * @return a TwitterUser
     */
    public static ITwitterUser migrateUserFromJSON(JSONObject obj){
        ITwitterUser user = null;
        try {
            user = new TwitterUser(
                    Long.parseLong(obj.getString("id_str")),
                    MiscUtils.parseCalendarFromString(obj.getString("created_at")),
                    Calendar.getInstance(),
                    obj.getString("time_zone"),
                    obj.getString("name"),
                    obj.getString("screen_name"),
                    obj.getString("lang"),
                    obj.getString("url"),
                    obj.getString("profile_image_url_https"),
                    obj.getString("profile_sidebar_border_color"),
                    obj.getString("profile_sidebar_fill_color"),
                    obj.getString("description"),
                    obj.getInt("followers_count"),
                    obj.getInt("friends_count"),
                    obj.getInt("statuses_count"),
                    obj.getInt("favourites_count"),
                    obj.getInt("listed_count"),
                    obj.getBoolean("protected"),
                    obj.getBoolean("verified")
                    );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Takes in a JSON object and instantiate a Tweet class
     * @param obj a JSON object
     * @return A tweet
     */
    public static ITweet migrateTweetFromJSON(JSONObject obj){
        ITweet tweet = null;
        try{
            tweet = new Tweet(
                    Long.parseLong(obj.getString("id_str")),
                    Long.parseLong(obj.getJSONObject("user").getString("id_str")),
                    MiscUtils.parseCalendarFromString(obj.getString("created_at")),
                    Calendar.getInstance(),
                    obj.getString("text"),
                    obj.getString("source"),
                    obj.getString("lang"),
                    obj.getBoolean("is_quote_status"),
                    Long.parseLong(obj.getString("quoted_status_id_str")),
                    obj.has("retweeted_status"),
                    Long.parseLong(obj.has("retweeted_status") ? obj.getJSONObject("retweeted_status").getString("id_str") : ""),
                    obj.getInt("quote_count"),
                    obj.getInt("retweet_count"),
                    obj.getInt("reply_count"),
                    obj.getInt("favorites_count"),
                    "",
                    "",
                    "",
                    ""
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tweet;
    }
}
