package com.example.hulya.yemekhane.dummydata;

import com.example.hulya.yemekhane.R;
import com.example.hulya.yemekhane.viewmodel.FoodListVM;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by hulya on 14.08.2017.
 */

public class GenerateDummyData {

    ArrayList<FoodListVM> foodList = new ArrayList<>();

    public ArrayList<FoodListVM> generateDummyList(ValueEventListener valueEventListener) {

        return foodList;
    }
}
