package com.mkrlabs.restraw.view_holder;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mkrlabs.restraw.R;
import com.mkrlabs.restraw.adapter.SliderAdapterExample;
import com.mkrlabs.restraw.model.FoodItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class SliderViewHolder extends RecyclerView.ViewHolder {

    SliderView sliderView;
    private SliderAdapterExample adapter;
    public SliderViewHolder(@NonNull View itemView) {
        super(itemView);
        sliderView = itemView.findViewById(R.id.imageSlider);



    }

    public  void  setBannerStripLayout(Context context, List<FoodItem> sliderItemList){
        adapter = new SliderAdapterExample(context);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        sliderProperties(sliderItemList);
    }

    public void sliderProperties(List<FoodItem> sliderList) {
        adapter.renewItems(sliderList);
    }
}
