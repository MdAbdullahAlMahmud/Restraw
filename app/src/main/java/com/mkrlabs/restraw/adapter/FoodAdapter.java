package com.mkrlabs.restraw.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.model.FoodItem;
import com.mkrlabs.restraw.ui.food_details.FoodDetailsActivity;
import com.mkrlabs.restraw.utils.KeyName;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodItemViewHolder> {

    private List<FoodItem> foodItemList;
    private Context context;

    public FoodAdapter(List<FoodItem> foodItemList, Context context) {
        this.foodItemList = foodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item,parent,false);

        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        FoodItem foodItem = foodItemList.get(position);
        Glide.with(holder.itemView).load(foodItem.getFoodImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.foodImageRV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodDetailsActivity.class);
                intent.putExtra(KeyName.FOOD_DETAILS,foodItem);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    class FoodItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView foodImageRV;
        public FoodItemViewHolder(@NonNull View itemView) {
            super(itemView);
             foodImageRV = itemView.findViewById(R.id.foodItemImage);
        }
    }
}
