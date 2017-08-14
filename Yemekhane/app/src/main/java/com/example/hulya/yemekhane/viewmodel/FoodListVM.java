package com.example.hulya.yemekhane.viewmodel;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by hulya on 14.08.2017.
 */

public class FoodListVM {

    private String foodType;
    private String foodName1;
    private String FoodName2;
    private ImageView foodImageLink1;
    private ImageView foodImageLink2;

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    public String getFoodName1() {
        return foodName1;
    }

    public void setFoodName1(String foodName1) {
        this.foodName1 = foodName1;
    }

    public String getFoodName2() {
        return FoodName2;
    }

    public void setFoodName2(String foodName2) {
        FoodName2 = foodName2;
    }

    public ImageView getFoodImageLink1() {
        return foodImageLink1;
    }

    public void setFoodImageLink1(ImageView foodImageLink1) {
        this.foodImageLink1 = foodImageLink1;
    }

    public ImageView getFoodImageLink2() {
        return foodImageLink2;
    }

    public void setFoodImageLink2(ImageView foodImageLink2) {
        this.foodImageLink2 = foodImageLink2;
    }



}
