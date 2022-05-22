package com.mkrlabs.restraw.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.fragment.HomeFragment;
import com.mkrlabs.restraw.fragment.ProfileFragment;
import com.mkrlabs.restraw.fragment.TourMapFragment;
import com.mkrlabs.restraw.fragment.TryListFragment;


public class HomeActivity extends AppCompatActivity {


    ChipNavigationBar bottomNavigation;
    private DrawerLayout home_drawer;
    private TextView navProfileTV,navTryList,navSetting,navRate,navAbout,navVersion,navLogoutTV;
    private ImageButton navButton;
    private FrameLayout frameContainer;
    private TextView toolBarName;
    private String RESTRURENT_NAME = "Adda Cofee";

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inits();
        initLeftDrawer();
        initLeftDrawerClickListener();

        bottomNavigation.setItemSelected(R.id.home,true);
        setUpFragment(new HomeFragment(),RESTRURENT_NAME);




        bottomNavigation.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int item) {
                System.out.println(item);
                switch (item) {
                    case R.id.home:
                        setUpFragment(new HomeFragment(),RESTRURENT_NAME);
                        return;
                    case R.id.tryList:
                        setUpFragment(new TryListFragment(), "Try List");
                        return;
                    case R.id.takeTour:
                        setUpFragment(new TourMapFragment(),"Explore");
                        return;
                    case R.id.profile:
                        setUpFragment(new ProfileFragment(),"Profile");
                        return;



                }

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
@Override
public void onBackPressed() {
    if (bottomNavigation.getSelectedItemId() != R.id.home) {
        bottomNavigation.setItemSelected(R.id.home,true);
    } else {
        super.onBackPressed();
    }
}

    private void setUpFragment(Fragment fragment,String name) {

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, fragment)
                    .commit();
            toolBarName.setText(name);
        }

    }

    private void inits(){
        frameContainer = findViewById(R.id.frameContainer);
        navButton= findViewById(R.id.navButton);
        toolBarName= findViewById(R.id.toolBarName);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        home_drawer = findViewById(R.id.home_drawer);

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