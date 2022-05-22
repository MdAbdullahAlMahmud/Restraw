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
import com.mkrlabs.restraw.adapter.Adapter;
import com.mkrlabs.restraw.model.FoodItem;
import com.mkrlabs.restraw.model.ModelClass;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<ModelClass> modelClassList;
    private Adapter adapter;
    private RecyclerView homeRV;
    private String url = "https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_home, container, false);
        setUpRecycleView(view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        modelClassList = new ArrayList<>();
        // food item

        List<FoodItem> foodItems = new ArrayList<>();

        foodItems.add(new FoodItem("Pizza1","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-homemade-pizza-horizontal-1542312378.png?crop=1.00xw:1.00xh;0,0&resize=480:*"));
        foodItems.add(new FoodItem("Pizza2","https://content3.jdmagicbox.com/comp/delhi/e9/011pxx11.xx11.190326213521.q7e9/catalogue/pizza-by-paradoxx-delhi-pizza-outlets-3w7liamrdx.jpg"));
        foodItems.add(new FoodItem("Pizza3","https://www.irishtimes.com/polopoly_fs/1.4245295.1588671124!/image/image.jpg_gen/derivatives/ratio_16x9_w1200/image.jpg"));
        foodItems.add(new FoodItem("Pizza4","https://c.ndtvimg.com/2020-07/ds980vng_pizza_625x300_07_July_20.jpg"));
        foodItems.add(new FoodItem("Pizza5","https://c.ndtvimg.com/2020-07/ds980vng_pizza_625x300_07_July_20.jpg"));
        foodItems.add(new FoodItem("Pizza6","https://c.ndtvimg.com/2020-07/ds980vng_pizza_625x300_07_July_20.jpg"));

        ModelClass food_section = new ModelClass(ModelClass.FOOD_ITEM_LAYOUT,foodItems,"Pizza");
        ModelClass burger_section = new ModelClass(ModelClass.FOOD_ITEM_LAYOUT,foodItems,"Burger");

        ModelClass banner_section = new ModelClass(ModelClass.BANNER_STRIP_ITEM_LAYOUT,getSliderFoodList());

        modelClassList.add(banner_section);
        modelClassList.add(food_section);

        modelClassList.add(burger_section);
        modelClassList.add(burger_section);
        modelClassList.add(burger_section);
        modelClassList.add(burger_section);




        adapter = new Adapter(modelClassList,getContext());

        homeRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private List<FoodItem> getSliderFoodList(){
        List<FoodItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            FoodItem sliderItem = new FoodItem();
            sliderItem.setFoodName("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setFoodImage("https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8ZmFzdCUyMGZvb2R8ZW58MHx8MHx8&w=1000&q=80");
            } else {
                sliderItem.setFoodImage("https://images.unsplash.com/photo-1615996001375-c7ef13294436?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fGZhc3QlMjBmb29kfGVufDB8fDB8fA%3D%3D&w=1000&q=80");
            }
            sliderItemList.add(sliderItem);
        }
        return sliderItemList;
    }

    private void setUpRecycleView(View view) {
        homeRV= view.findViewById(R.id.homeRV);
        homeRV.setHasFixedSize(true);
        homeRV.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}