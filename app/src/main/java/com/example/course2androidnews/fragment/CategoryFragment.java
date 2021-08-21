package com.example.course2androidnews.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.course2androidnews.CategoryDetail;
import com.example.course2androidnews.R;
import com.example.course2androidnews.databinding.FragmentCategoryBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    TextView business, entertaintment, health, science, sport, technology;
    FragmentCategoryBinding binding;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
//        view = inflater.inflate(R.layout.fragment_category, container, false);;
        business = binding.business;
        entertaintment = binding.entertainment;
        health = binding.health;
        science = binding.science;
        sport = binding.sport;
        technology = binding.technology;

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CategoryDetail.class);
                i.putExtra("dataTipe", "business");
                startActivity(i);
            }
        });
        entertaintment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CategoryDetail.class);
                i.putExtra("dataTipe", "entertaintment");
                startActivity(i);
            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CategoryDetail.class);
                i.putExtra("dataTipe", "health");
                startActivity(i);
            }
        });
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CategoryDetail.class);
                i.putExtra("dataTipe", "science");
                startActivity(i);
            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CategoryDetail.class);
                i.putExtra("dataTipe", "sport");
                startActivity(i);
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CategoryDetail.class);
                i.putExtra("dataTipe", "technology");
                startActivity(i);
            }
        });

        return view;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
}