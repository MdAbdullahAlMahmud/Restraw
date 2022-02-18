package com.mkrlabs.restraw.view_holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.adapter.FoodAdapter;
import com.mkrlabs.restraw.model.FoodItem;

import java.util.List;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    public RecyclerView food_rv;
    public TextView foodHeaderSectionTitle;
    public FoodAdapter adapter ;

    public FoodViewHolder(View itemView) {
        super(itemView);
        food_rv = itemView.findViewById(R.id.rv_food);
        foodHeaderSectionTitle =itemView.findViewById(R.id.foodHeaderSectionTitle);

    }

    public void setFoodRecycleView(List<FoodItem> foodItemList , Context context,String title){

        foodHeaderSectionTitle.setText(title);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        food_rv.setLayoutManager(linearLayoutManager);
        food_rv.setHasFixedSize(true);

        adapter = new FoodAdapter(foodItemList,context);
        food_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
