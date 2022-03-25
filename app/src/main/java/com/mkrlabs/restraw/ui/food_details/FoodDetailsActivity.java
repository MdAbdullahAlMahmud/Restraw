package com.mkrlabs.restraw.ui.food_details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

import com.mkrlabs.restraw.R;

public class FoodDetailsActivity extends AppCompatActivity {

    AppCompatImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        init();


        backButton.setOnClickListener(view -> onBackPressed());
    }



    private  void  init(){
        backButton = findViewById(R.id.backButton);
    }
}