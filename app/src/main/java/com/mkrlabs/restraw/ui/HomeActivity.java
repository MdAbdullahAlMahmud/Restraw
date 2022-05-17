package com.mkrlabs.restraw.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.adapter.Adapter;
import com.mkrlabs.restraw.model.FoodItem;
import com.mkrlabs.restraw.model.ModelClass;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<ModelClass> modelClassList;
    private Adapter adapter;
    private RecyclerView homeRV;
    ChipNavigationBar bottomNavigation;
    private DrawerLayout home_drawer;
    private TextView navProfileTV,navTryList,navSetting,navRate,navAbout,navVersion,navLogoutTV;
    private ImageButton navButton;

    private String url = "https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inits();
        initLeftDrawer();
        initLeftDrawerClickListener();
        setUpRecycleView();

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




        adapter = new Adapter(modelClassList,this);

        homeRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        bottomNavigation.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Log.v("tag",i+"");
            }
        });

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_drawer.openDrawer(GravityCompat.START);
            }
        });



    }

/*
 ModelClass burger_section = new ModelClass(ModelClass.FOOD_ITEM_LAYOUT,foodItems,"Burger");
        ModelClass cold_section = new ModelClass(ModelClass.FOOD_ITEM_LAYOUT,foodItems,"Cold Drinks");
        ModelClass chik_section = new ModelClass(ModelClass.FOOD_ITEM_LAYOUT,foodItems,"Pizza");
 */

    private void inits(){
        navButton= findViewById(R.id.navButton);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        home_drawer = findViewById(R.id.home_drawer);

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

    private void setUpRecycleView() {
        homeRV= findViewById(R.id.homeRV);
        homeRV.setHasFixedSize(true);
        homeRV.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initLeftDrawerClickListener() {


       /* navContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Intent intent = new Intent(HomeActivity.this, ContactUsActivity.class);
                startActivity(intent);
                home_drawer.closeDrawer(GravityCompat.START);*//*
            }
        });
        navFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Intent intent = new Intent(HomeActivity.this, FeedbackActivity.class);
                startActivity(intent);
                home_drawer.closeDrawer(GravityCompat.START);*//*
            }
        });

        navFAQTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Intent intent = new Intent(HomeActivity.this, FAQActivity.class);
                startActivity(intent);
                home_drawer.closeDrawer(GravityCompat.START);*//*
            }
        });

        navProfileTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               *//* Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
                home_drawer.closeDrawer(GravityCompat.START);*//*
            }
        });



        navLogoutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               *//* userLogOut();
                home_drawer.closeDrawer(GravityCompat.START);*//*
            }
        });*/

    }



    private void initLeftDrawer() {
        navProfileTV=findViewById(R.id.navProfileTV);
        navTryList=findViewById(R.id.navTryList);
        navSetting=findViewById(R.id.navSettings);
        navRate=findViewById(R.id.navRateTv);
        navAbout=findViewById(R.id.navAboutTv);
        navVersion=findViewById(R.id.navVersion);
        navLogoutTV=findViewById(R.id.navLogoutTV);

    }

}