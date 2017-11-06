package edu.uc.it4045.tweetSalon.network;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TwitterAPICaller {

    private TwitterAPIAuthenticator auth = new TwitterAPIAuthenticator();

    /**
     * sends GET request to the Twitter API. Includes bearer token in the header.
     * @param uri the URI of the GET request
     * @return JSON string
     */
    public JSONObject sendGetRequest(String uri) {
        JSONObject content = null;
        String bearerToken = "";
        CloseableHttpResponse response = null;

        //check if bearer token is in cache
        if(null == auth.getBearerTokenFromCache()){
            //not in cache, obtain one and cache it
            try {
                bearerToken = auth.obtainBearerToken();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            auth.cacheBearerToken(bearerToken);
        }else {
            //token is in cache, obtain it
            bearerToken = auth.getBearerTokenFromCache();
        }

        // set up a GET request with the Authorization header
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Authorization", bearerToken);
        try {
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                content = new JSONObject(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
