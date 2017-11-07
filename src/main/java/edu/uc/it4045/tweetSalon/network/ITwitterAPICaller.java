package edu.uc.it4045.tweetSalon.network;

import org.json.JSONObject;

public interface ITwitterAPICaller {
    JSONObject sendGetRequest(String uri);
}
