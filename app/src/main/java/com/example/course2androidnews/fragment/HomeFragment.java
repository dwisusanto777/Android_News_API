package com.example.course2androidnews.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.course2androidnews.R;
import com.example.course2androidnews.adapter.MyAdapter;
import com.example.course2androidnews.databinding.FragmentCategoryBinding;
import com.example.course2androidnews.databinding.FragmentHomeBinding;
import com.example.course2androidnews.retrofitconfig.ApiServiceNews;
import com.example.course2androidnews.retrofitconfig.RetrofitConfigToJson;
import com.example.course2androidnews.retrofitjson.ArticlesItem;
import com.example.course2androidnews.retrofitjson.ResponseNews;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ApiServiceNews apiServiceNews;
    List<ArticlesItem> responseNews;
    String title;
    RecyclerView recyclerView;
    MyAdapter adapter;
    GridLayoutManager gm;
    View view;
    FragmentHomeBinding binding;
    SpinKitView spinKitView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        responseNews = new ArrayList<ArticlesItem>();
        spinKitView = binding.spinKit;
        recyclerView = binding.mainRecycleView;
        gm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gm);
        adapter = new MyAdapter(getContext(), responseNews);
        recyclerView.setAdapter(adapter);

        apiServiceNews = RetrofitConfigToJson.getResponse();
        apiServiceNews.getAllNewsDataByCountry("id","a85434ead82848caae594b826915712d").enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                Log.d("Berhasil",response+"");
                ArticlesItem a = response.body().getArticles().get(1);
                Log.d("Berhasil",a.getTitle()+" - "+a.getDescription());
                spinKitView.setVisibility(View.VISIBLE);
                if(response.isSuccessful()){
                    spinKitView.setVisibility(View.GONE);
                    responseNews = response.body().getArticles();
                    adapter = new MyAdapter(getContext(), responseNews);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Log.d("Gagal",t+"");
            }
        });

        return view;
    }
}