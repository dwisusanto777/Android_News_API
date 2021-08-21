package com.example.course2androidnews;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.course2androidnews.adapter.MyAdapter;
import com.example.course2androidnews.databinding.ActivityCategoryDetailBinding;
import com.example.course2androidnews.retrofitconfig.ApiServiceNews;
import com.example.course2androidnews.retrofitconfig.RetrofitConfigToJson;
import com.example.course2androidnews.retrofitjson.ArticlesItem;
import com.example.course2androidnews.retrofitjson.ResponseNews;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetail extends AppCompatActivity {

    ActivityCategoryDetailBinding binding;
    TextView categoryDetail;
    RecyclerView recyclerView;
    String variabelGlobal;
    ApiServiceNews serviceNews;
    List<ArticlesItem> responseNews;
    GridLayoutManager gm;
    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        categoryDetail = binding.categoryDetail;
        recyclerView = binding.recycleDetail;
        gm = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gm);
        variabelGlobal = getIntent().getStringExtra("dataTipe");
        responseNews = new ArrayList<ArticlesItem>();
        adapter = new MyAdapter(this, responseNews);

        serviceNews = RetrofitConfigToJson.getResponse();

        switch (variabelGlobal){
            case "business":
                //categoryDetail.setText(variabelGlobal);
                tampilkanCategory(variabelGlobal);
                break;
            case "entertaintment":
//                categoryDetail.setText(variabelGlobal);
                tampilkanCategory(variabelGlobal);
                break;
            case "health":
//                categoryDetail.setText(variabelGlobal);
                tampilkanCategory(variabelGlobal);
                break;
            case "science":
//                categoryDetail.setText(variabelGlobal);
                tampilkanCategory(variabelGlobal);
                break;
            case "sport":
//                categoryDetail.setText(variabelGlobal);
                tampilkanCategory(variabelGlobal);
                break;
            case "technology":
//                categoryDetail.setText(variabelGlobal);
                tampilkanCategory(variabelGlobal);
                break;
        }
    }

    private void tampilkanCategory(String tipe){
        Log.d("LOG-DWI", tipe);
        serviceNews.getNewsDataCountryByCategory("id", tipe,"a85434ead82848caae594b826915712d").enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                responseNews = response.body().getArticles();
                adapter = new MyAdapter(getApplicationContext(), responseNews);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {

            }
        });
    }
}
