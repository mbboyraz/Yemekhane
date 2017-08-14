package com.example.hulya.yemekhane.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hulya.yemekhane.R;

/**
 * Created by hulya on 14.08.2017.
 */

public class FoodListViewHolder extends  RecyclerView.ViewHolder {
    public TextView foodType = null;
    public ImageView image1 = null;
    public ImageView image2 = null;

    public FoodListViewHolder(View itemView) {
        super(itemView);
        initView();
    }
    public void initView(){
        foodType = itemView.findViewById(R.id.foodType);
        image1 = itemView.findViewById(R.id.foodImage1);
        image2 = itemView.findViewById(R.id.foodImage2);
    }
}
