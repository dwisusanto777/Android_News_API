package com.example.course2androidnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.course2androidnews.adapter.MyAdapter;
import com.example.course2androidnews.retrofitconfig.ApiServiceNews;
import com.example.course2androidnews.retrofitconfig.RetrofitConfigToJson;
import com.example.course2androidnews.retrofitjson.ArticlesItem;
import com.example.course2androidnews.retrofitjson.ResponseNews;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// API Newsapi.org a85434ead82848caae594b826915712d
public class MainActivity extends AppCompatActivity {

    ApiServiceNews apiServiceNews;
    List<ArticlesItem> responseNews;
    String title;
    RecyclerView recyclerView;
    MyAdapter adapter;
    GridLayoutManager gm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseNews = new ArrayList<ArticlesItem>();
        recyclerView = findViewById(R.id.mainRecycleView);
        gm = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gm);
        adapter = new MyAdapter(this, responseNews);
        recyclerView.setAdapter(adapter);

        apiServiceNews = RetrofitConfigToJson.getResponse();
        apiServiceNews.getAllNewsDataByCountry("id","a85434ead82848caae594b826915712d").enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                Log.d("Berhasil",response+"");
                ArticlesItem a = response.body().getArticles().get(1);
                Log.d("Berhasil",a.getTitle()+" - "+a.getDescription());
                responseNews = response.body().getArticles();
                adapter = new MyAdapter(getApplicationContext(), responseNews);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Log.d("Gagal",t+"");
            }
        });
    }
}