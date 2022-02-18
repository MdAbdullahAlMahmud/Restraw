package com.mkrlabs.restraw.view_holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkrlabs.restraw.R;

public class ColdDrinksViewHolder extends RecyclerView.ViewHolder {

    public TextView coldDrinkNameTV;
    public ImageView coldDrinkImageIV;
    public ColdDrinksViewHolder(View drink_view) {
        super(drink_view);
        coldDrinkNameTV = drink_view.findViewById(R.id.coldDrinksItemName);
        coldDrinkImageIV = drink_view.findViewById(R.id.coldDrinksItemImage);

    }

    public void setColdDrinksProperty(String name ,String image){
        coldDrinkNameTV.setText(name);
        Glide.with(itemView).load(image).diskCacheStrategy(DiskCacheStrategy.ALL).into(coldDrinkImageIV);
    }
}
