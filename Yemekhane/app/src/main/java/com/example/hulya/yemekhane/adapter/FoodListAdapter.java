package com.example.hulya.yemekhane.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hulya.yemekhane.R;
import com.example.hulya.yemekhane.viewmodel.FoodListVM;

import java.util.ArrayList;

/**
 * Created by hulya on 14.08.2017.
 */

public class FoodListAdapter extends RecyclerView.Adapter {
    private ArrayList<FoodListVM> foodList = null;
    public FoodListAdapter(RecyclerView recyclerView, ArrayList<FoodListVM> foodList) {
    }

    public FoodListAdapter(ArrayList<FoodListVM> foodList) {
        this.foodList = foodList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_foodlist,parent,false);


        return new FoodListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FoodListVM selectedFoodListVM = getItem(position);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
    private FoodListVM getItem(int position){
        return foodList.get(position);
    }
}
