package edu.uc.it4045.tweetSalon.network;

import edu.uc.it4045.tweetSalon.util.CachingUtility;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TwitterAPIAuthenticator {
    private final String base64BearerTokenCredentials = "cmFia0FaeUdrMTh6bUN4SGtqODNCMFNOSTpBbmE4eUdaTDFlQXByT3k3VTdwT29sUTFRVmN0elNqc0l6M3RxNW93V0VHSmcxTEtZTA==";
    private final String oAuthObtainPath = "https://api.twitter.com/oauth2/token?grant_type=client_credentials";
    private final String oAuthInvalidatePath = "https://api.twitter.com/oauth2/token?access_token=";

    public String obtainBearerToken() throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(oAuthObtainPath);
        httpPost.addHeader("Authorization", "Basic " + base64BearerTokenCredentials);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        JSONObject JSONResponse = (JSONObject) response.getEntity();
        String bearerToken = JSONResponse.get("access_token").toString();
        return bearerToken;
    }

    public void invalidateBearerToken(String token) throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(oAuthInvalidatePath);
        httpPost.addHeader("Authorization", "Basic " + token);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        JSONObject JSONResponse = (JSONObject) response.getEntity();
        String invalidatedToken = JSONResponse.get("access_token").toString();
        System.out.println("bearer token: " + invalidatedToken + " is now invalidated.");
    }

    public void cacheBearerToken(String token){
        CachingUtility cache = new CachingUtility();
        cache.putInCache("bearerToken", token);
    }

    public String getBearerTokenFromCache(){
        CachingUtility cache = new CachingUtility();
        return cache.getFromCache("bearerToken");
    }
}
