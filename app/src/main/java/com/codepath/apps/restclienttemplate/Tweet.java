package com.codepath.apps.restclienttemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by johnw on 3/26/2016.
 */
public class Tweet {
    private String body;
    private long uid;
    private User user;
    private String imageUrl;
    private String createAt;
    private String retweetCount;
    private String countLike;

    public String getRetweetCount() {
        return retweetCount;
    }

    public String getCountLike() {
        return countLike;
    }

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreateAt() {
        return createAt;
    }

    public User getUser() {
        return user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static Tweet fromJSON(JSONObject jsonObject){
        Tweet tweet = new Tweet();
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createAt = jsonObject.getString("created_at");
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
            tweet.retweetCount = jsonObject.getString("retweet_count");
          //  tweet.countLike = jsonObject.getString("favourites_count");
            JSONArray array = jsonObject.getJSONObject("extended_entities").getJSONArray("media");
            tweet.imageUrl = array.getJSONObject(array.length()).getString("media_url");

        }catch (JSONException e){
            e.printStackTrace();
        }
        return tweet;
    }
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray){
        ArrayList<Tweet> tweets = new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);
                if(tweet!=null){
                    tweets.add(tweet);
                }
            }catch (JSONException e){
                e.printStackTrace();
                continue;
            }

        }

        return tweets;
    }
}
