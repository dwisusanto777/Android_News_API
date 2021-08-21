package com.example.course2androidnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.course2androidnews.adapter.MyAdapter;
import com.example.course2androidnews.fragment.AboutFragment;
import com.example.course2androidnews.fragment.CategoryFragment;
import com.example.course2androidnews.fragment.HomeFragment;
import com.example.course2androidnews.retrofitconfig.ApiServiceNews;
import com.example.course2androidnews.retrofitconfig.RetrofitConfigToJson;
import com.example.course2androidnews.retrofitjson.ArticlesItem;
import com.example.course2androidnews.retrofitjson.ResponseNews;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// API Newsapi.org a85434ead82848caae594b826915712d
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragmentClick(new HomeFragment());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private boolean fragmentClick(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutGanti, fragment).commit();
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int userId = item.getItemId();
        Fragment fragment = null;
        switch (userId) {
            case R.id.homeBtn:
                fragment = new HomeFragment();
                break;
            case R.id.categoryBtn:
                fragment = new CategoryFragment();
                break;
            case R.id.aboutBtn:
                fragment = new AboutFragment();
                break;
        }
        return fragmentClick(fragment);
    }
}