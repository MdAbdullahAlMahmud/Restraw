package com.mkrlabs.restraw.model;

import java.io.Serializable;

public class FoodItem implements Serializable {

    private String foodName;
    private String foodImage;

    public FoodItem(){}
    public FoodItem(String foodName, String foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
}
