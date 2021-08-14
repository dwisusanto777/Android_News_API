package com.example.course2androidnews.retrofitconfig;

public class RetrofitConfigToJson {
    public static String URL_API = "https://newsapi.org/";

    public static ApiServiceNews getResponse(){
        return RetrofitInstance.getInstance(URL_API).create(ApiServiceNews.class);
    }

}
