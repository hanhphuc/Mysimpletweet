package com.codepath.apps.restclienttemplate;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	/*public static final String REST_CONSUMER_KEY = "JjokLouA2Lg2DhtCkK4Yhema2";       // Change this
	public static final String REST_CONSUMER_SECRET = "DlHmQfyzMqMx1UMGCPJOVNKxbNq5nVB7ezOfZIszYonJfQZG7f"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://TweetAppClient"; // Change this (here and in manifest)*/

	public static final String REST_CONSUMER_KEY = "SafO0qpzocuZ5TrB2Gv5UCQHR";       // Change this
	public static final String REST_CONSUMER_SECRET = "LYCo2sNVh9VLrqdmdOJ5o7G5xUN0pREDAwZGRY7sJ8VrP4MYSJ"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://NTMHanh"; // Change this (here and in manifest)

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}

	public void getHomeTimeline(AsyncHttpResponseHandler hanlder){
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		client.get(apiUrl, null, hanlder);

	}
	// CHANGE THIS
	// DEFINE METHODS for different API endpoints here


	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}