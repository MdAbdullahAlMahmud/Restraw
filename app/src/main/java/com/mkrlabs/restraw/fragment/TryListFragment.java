package com.mkrlabs.restraw.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.adapter.TryListAdapter;
import com.mkrlabs.restraw.model.FoodItem;

import java.util.ArrayList;
import java.util.List;


public class TryListFragment extends Fragment {


    private RecyclerView recyclerView;
    private TryListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_try_list, container, false);
        setUpRecycleView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<FoodItem> foodItems = new ArrayList<>();

        foodItems.add(new FoodItem("Pizza1","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-homemade-pizza-horizontal-1542312378.png?crop=1.00xw:1.00xh;0,0&resize=480:*"));
        foodItems.add(new FoodItem("Coffee","https://media-cldnry.s-nbcnews.com/image/upload/t_nbcnews-fp-1200-630,f_auto,q_auto:best/newscms/2019_33/2203981/171026-better-coffee-boost-se-329p.jpg"));
        foodItems.add(new FoodItem("Pizza2","https://content3.jdmagicbox.com/comp/delhi/e9/011pxx11.xx11.190326213521.q7e9/catalogue/pizza-by-paradoxx-delhi-pizza-outlets-3w7liamrdx.jpg"));
        foodItems.add(new FoodItem("Pizza3","https://www.irishtimes.com/polopoly_fs/1.4245295.1588671124!/image/image.jpg_gen/derivatives/ratio_16x9_w1200/image.jpg"));
        foodItems.add(new FoodItem("Pizza4","https://c.ndtvimg.com/2020-07/ds980vng_pizza_625x300_07_July_20.jpg"));

        adapter = new TryListAdapter(getContext(),foodItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpRecycleView(View view) {
        recyclerView= view.findViewById(R.id.tryListRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}