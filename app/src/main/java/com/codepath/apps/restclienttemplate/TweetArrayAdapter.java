package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by johnw on 3/27/2016.
 */
public class TweetArrayAdapter extends ArrayAdapter<Tweet> {
    public TweetArrayAdapter (Context context, List<Tweet> tweets){
        //super(context,android.R.layout.simple_list_item_1,tweets);
        super(context,0,tweets);

    }
    public String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get Tweet
        Tweet tweet = getItem(position);
        //find or inflate the template
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet,parent,false);
        }
        //find the subView to fill with data in the inflater
        ImageView ivUser = (ImageView)convertView.findViewById(R.id.ivuser);
        TextView tvUserName  = (TextView)convertView.findViewById(R.id.tvUsername);
        TextView tvBody = (TextView)convertView.findViewById(R.id.tvBody);
        TextView tvCountRetweet = (TextView)convertView.findViewById(R.id.retweetCount);
        TextView tvCountLike = (TextView)convertView.findViewById(R.id.countLike);
        TextView tvDatetime = (TextView)convertView.findViewById(R.id.DateTime);
        ImageView ivImage = (ImageView)convertView.findViewById(R.id.ivImage);





        //Populate data into the subview
        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());
        ivUser.setImageResource(android.R.color.transparent);//clear out the old image for a recycle view
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivUser);
        tvCountLike.setText(tweet.getCountLike());
        tvCountRetweet.setText(tweet.getRetweetCount());
        tvDatetime.setText(getRelativeTimeAgo(tweet.getCreateAt()));
        Picasso.with(getContext()).load(tweet.getImageUrl()).into(ivImage);

        return convertView;
    }
}
