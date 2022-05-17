package com.mkrlabs.restraw.ui.food_details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.mkrlabs.restraw.R;

public class FoodDetailsActivity extends AppCompatActivity {

    AppCompatImageButton backButton;
    ChipGroup chipGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        init();


        backButton.setOnClickListener(view -> onBackPressed());



        String[] ingredients = {"Thriller", "Comedy", "Adventure"};
        for(String ingredient : ingredients) {

            Chip chip = new Chip(this);
            chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chipBackgroundColor)));
            chip.setText(ingredient);
            chipGroup.addView(chip);

        }

    }



    private  void  init(){
        backButton = findViewById(R.id.backButton);
        chipGroup = findViewById(R.id.chipGroup);
    }
}