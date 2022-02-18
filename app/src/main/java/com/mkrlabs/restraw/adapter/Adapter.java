package com.mkrlabs.restraw.adapter;

import static com.mkrlabs.restraw.model.ModelClass.BANNER_STRIP_ITEM_LAYOUT;
import static com.mkrlabs.restraw.model.ModelClass.FOOD_ITEM_LAYOUT;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.model.ModelClass;
import com.mkrlabs.restraw.view_holder.ColdDrinksViewHolder;
import com.mkrlabs.restraw.view_holder.FoodViewHolder;
import com.mkrlabs.restraw.view_holder.SliderViewHolder;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    public List<ModelClass> modelClassList;
    private  RecyclerView.RecycledViewPool recycledViewPool;
    private Context context;

    public Adapter(List<ModelClass> modelClassList, Context context) {
        this.modelClassList = modelClassList;
        this.context = context;
        recycledViewPool=new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){

            case FOOD_ITEM_LAYOUT:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_layout,parent,false);
                return new FoodViewHolder(view);

            case BANNER_STRIP_ITEM_LAYOUT:
                View drink_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout,parent,false);
                return  new SliderViewHolder(drink_view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ModelClass modelClass = modelClassList.get(position);
        switch (holder.getItemViewType()){


            case BANNER_STRIP_ITEM_LAYOUT:
                ((SliderViewHolder)holder).setBannerStripLayout(context,modelClass.getSliderItemList());
                break;
            case FOOD_ITEM_LAYOUT:
                ((FoodViewHolder)holder).setFoodRecycleView(modelClass.getFoodItemList(),context,"Pizza");
                break;
            default:
                return;
        }


    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    @Override
    public int getItemViewType(int position) {

        switch (modelClassList.get(position).getViewType()){
            case 0:
                return BANNER_STRIP_ITEM_LAYOUT;
            case 1:
                return FOOD_ITEM_LAYOUT;

            default:
                return -1;
        }
    }


}
