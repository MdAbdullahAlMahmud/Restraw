package com.mkrlabs.restraw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.model.FoodItem;

import java.util.List;

public class TryListAdapter extends  RecyclerView.Adapter<TryListAdapter.TryListViewHolder>{

    private Context context;
    private List<FoodItem> tryList;

    public TryListAdapter(Context context, List<FoodItem> tryList) {
        this.context = context;
        this.tryList = tryList;
    }

    @NonNull
    @Override
    public TryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.try_list_item,parent,false);
        return new TryListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TryListViewHolder holder, int position) {
        FoodItem foodItem = tryList.get(position);

        holder.name.setText(foodItem.getFoodName());
        holder.price.setText("$"+getRandomPrice());
        Glide.with(holder.itemView).
                load(foodItem.getFoodImage()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.image);


    }

    private String getRandomPrice() {
        int min = 1;
        int max = 50;
        int b = (int)(Math.random()*(max-min+1)+min);
        return String.valueOf(b);

    }

    @Override
    public int getItemCount() {
        return tryList.size();
    }

    class TryListViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView price;
        public ImageView image;


        public TryListViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.try_list_item_name);
            price = itemView.findViewById(R.id.try_list_item_price);
            image = itemView.findViewById(R.id.try_list_item_image);
        }
    }
}
