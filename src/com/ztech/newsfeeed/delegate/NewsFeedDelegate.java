package com.ztech.newsfeeed.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.*;

public class NewsFeedDelegate {
	String genre, newsFeed;
	public String getNewsFeed(String genreType) throws Exception {
		if(genreType.equals("TOPNEWS")) {
			genre = "";
		}
		else {
			genre = "/headlines/section/topic/" + genreType;
		}
		URL rssURL = new URL("https://news.google.com/news/rss" + genre);
		BufferedReader br = new BufferedReader(new InputStreamReader(rssURL.openStream()));
		StringBuilder rssStringBuilder = new StringBuilder("");
		String line;
		while ((line = br.readLine()) != null) {
			rssStringBuilder.append(line);
		}
		genre = rssStringBuilder.toString();
		JSONObject object = (JSONObject) XML.toJSONObject(genre);
		JSONObject jsonObject = (JSONObject) object.get("rss");
		object = (JSONObject) jsonObject.get("channel");
		newsFeed = XML.toString(object);
		return newsFeed;
	}
}
