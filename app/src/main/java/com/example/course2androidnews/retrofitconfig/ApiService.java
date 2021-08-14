package com.example.course2androidnews.retrofitconfig;


import com.example.course2androidnews.retrofitjson.ResponseNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<ResponseNews> AmbilDataMovie(
            @Query("api_key") String apiKey
    );
}
