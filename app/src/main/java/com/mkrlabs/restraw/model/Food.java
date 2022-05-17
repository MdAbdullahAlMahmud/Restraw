package com.mkrlabs.restraw.model;

import java.util.Date;

public class Food {
    private String name;
    private double price;
    private String  image;
    private Category category;
    private double promoOffer;
    private Date promoOfferValidate;
    private long restaurant_id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPromoOffer() {
        return promoOffer;
    }

    public void setPromoOffer(double promoOffer) {
        this.promoOffer = promoOffer;
    }

    public Date getPromoOfferValidate() {
        return promoOfferValidate;
    }

    public void setPromoOfferValidate(Date promoOfferValidate) {
        this.promoOfferValidate = promoOfferValidate;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
