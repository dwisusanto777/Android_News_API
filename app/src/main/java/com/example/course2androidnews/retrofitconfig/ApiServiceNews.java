package com.example.course2androidnews.retrofitconfig;

import com.example.course2androidnews.retrofitjson.ResponseNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceNews {
    @GET("v2/top-headlines")
    Call<ResponseNews> getAllNewsDataByCountry(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("v2/top-headlines")
    Call<ResponseNews> getNewsDataCountryByCategory(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );
}
