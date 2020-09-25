package com.example.flicksterandroid.models;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.facebook.stetho.common.ArrayListAccumulator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String title;
    String overview;
    String backdropPath;

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
    }
    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJSONArray.length(); i++) {
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath); // fetching all available sizes, appending to base url, then adding in relative path
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
