package com.mkrlabs.restraw.model;

import java.util.List;

public class ModelClass {

    public static final int BANNER_STRIP_ITEM_LAYOUT= 0;
    public static final int FOOD_ITEM_LAYOUT= 1;
    // global section
    int viewType;

    // global section

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    // food section

    private List<FoodItem> foodItemList;
    private String title;

    public ModelClass(int viewType, List<FoodItem> foodItemList, String title) {
        this.viewType = viewType;
        this.foodItemList = foodItemList;
        this.title = title;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // food section


    // Banner Strip

    private List<FoodItem> sliderItemList;

    public ModelClass(int viewType ,List<FoodItem> sliderItemList) {
        this.sliderItemList = sliderItemList;
        this.viewType =viewType;
    }

    public List<FoodItem> getSliderItemList() {
        return sliderItemList;
    }

    public void setSliderItemList(List<FoodItem> sliderItemList) {
        this.sliderItemList = sliderItemList;
    }

    // Banner Strip



}
