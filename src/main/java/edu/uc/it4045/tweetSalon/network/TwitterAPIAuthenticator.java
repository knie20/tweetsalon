package edu.uc.it4045.tweetSalon.network;

import edu.uc.it4045.tweetSalon.util.CachingUtility;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TwitterAPIAuthenticator {
    private static final String base64BearerTokenCredentials = "cmFia0FaeUdrMTh6bUN4SGtqODNCMFNOSTpBbmE4eUdaTDFlQXByT3k3VTdwT29sUTFRVmN0elNqc0l6M3RxNW93V0VHSmcxTEtZTA==";
    private static final String oAuthObtainPath = "https://api.twitter.com/oauth2/token?grant_type=client_credentials";
    private static final String oAuthInvalidatePath = "https://api.twitter.com/oauth2/token?access_token=";

    public static String obtainBearerToken() throws IOException, JSONException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(oAuthObtainPath);
        httpPost.addHeader("Authorization", "Basic " + base64BearerTokenCredentials);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        AbstractResponseHandler<String> responseHandler = new BasicResponseHandler();
        String res = httpClient.execute(httpPost, responseHandler);
        JSONObject resJSON = new JSONObject(res);
        String bearerToken = resJSON.get("access_token").toString();
        return bearerToken;
    }

    public static void invalidateBearerToken(String token) throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(oAuthInvalidatePath);
        httpPost.addHeader("Authorization", "Basic " + token);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        JSONObject JSONResponse = (JSONObject) response.getEntity();
        String invalidatedToken = JSONResponse.get("access_token").toString();
        System.out.println("bearer token: " + invalidatedToken + " is now invalidated.");
    }

    public static void cacheBearerToken(String token){
        CachingUtility cache = new CachingUtility();
        cache.putInCache("bearerToken", token);
    }

    public static String getBearerTokenFromCache(){
        CachingUtility cache = new CachingUtility();
        return cache.getFromCache("bearerToken");
    }
}
