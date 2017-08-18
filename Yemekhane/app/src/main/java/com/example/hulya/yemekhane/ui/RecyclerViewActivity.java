package com.example.hulya.yemekhane.ui;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.hulya.yemekhane.R;
import com.example.hulya.yemekhane.adapter.FoodListAdapter;
import com.example.hulya.yemekhane.dummydata.FirebaseDataList;
import com.example.hulya.yemekhane.viewmodel.FoodListVM;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by hulya on 14.08.2017.
 */

public class RecyclerViewActivity extends AppCompatActivity implements ValueEventListener {

    Toolbar toolbar;
    SwipeRefreshLayout swiper;
    private RecyclerView rFoodList = null;
    private ArrayList<FoodListVM> foodList = null;
    private TextView txtDateInformation;
    private Firebase foodListRef;
    private Map<String, FirebaseDataList> firebaseDataListMap;
    private String day;
    private int i = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        toolbar.setTitleTextColor(Color.WHITE);
        swiper = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        Firebase.setAndroidContext(this);
        setSupportActionBar(toolbar);

        initView();
        GetData(i);
        DateInformation();

    }




    private void initView() {
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        rFoodList = (RecyclerView) findViewById(R.id.activity_recycler_view_foodList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rFoodList.setLayoutManager(mLayoutManager);
        rFoodList.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void DateInformation() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("EEEE-dd/MM/yyyy");
        txtDateInformation.setText(format.format(date).toString());
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        FoodListVM foodListVM = new FoodListVM();

        List<Map<String, List<FoodListVM>>> mapListfoodList = new ArrayList<>();
        Map<String, List<FoodListVM>> map1 = new HashMap<>();

        List<FoodListVM> foodList = new ArrayList<>();


        foodListVM.setFoodType("ÇORBALAR");
        foodListVM.setFoodName1(dataSnapshot.child("Soup1").getValue().toString());
        foodListVM.setFoodName2(dataSnapshot.child("Soup2").getValue().toString());
        foodListVM.setFoodImageLink1(R.mipmap.nanelicorba);
        foodListVM.setFoodImageLink2(R.mipmap.telsehriye2);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("BAŞLANGIÇ");
        foodListVM.setFoodName1(dataSnapshot.child("Entree1").getValue().toString());
        foodListVM.setFoodName2(dataSnapshot.child("Entree2").getValue().toString());
        foodListVM.setFoodImageLink1(R.mipmap.pilav2);
        foodListVM.setFoodImageLink2(R.mipmap.soslumakarna);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("ANA YEMEK");
        foodListVM.setFoodName1(dataSnapshot.child("MainFood1").getValue().toString());
        foodListVM.setFoodName2(dataSnapshot.child("MainFood2").getValue().toString());
        foodListVM.setFoodName3(dataSnapshot.child("MainFood3").getValue().toString());
        foodListVM.setFoodImageLink1(R.mipmap.soslukofte);
        foodListVM.setFoodImageLink2(R.mipmap.fajita);
        foodListVM.setFoodImageLink3(R.mipmap.bamya);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("ALTERNATİF");
        foodListVM.setFoodName1(dataSnapshot.child("Alternatif1").getValue().toString());
        foodListVM.setFoodName2(dataSnapshot.child("Alternatif2").getValue().toString());
        foodListVM.setFoodName3(dataSnapshot.child("Alternatif3").getValue().toString());
        foodListVM.setFoodImageLink1(R.mipmap.kumru);
        foodListVM.setFoodImageLink2(R.mipmap.ayran);
        foodListVM.setFoodImageLink3(R.mipmap.specialsalata);
        foodList.add(foodListVM);

        map1.put(day,foodList);
        mapListfoodList.add(map1);

        Context context = null;
        FoodListAdapter foodListAdapter = new FoodListAdapter((ArrayList<FoodListVM>) foodList, swiper, this);

        rFoodList.setAdapter(foodListAdapter);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
    }
    public void GetData(int i){
        foodListRef = new Firebase("https://refectory-84b81.firebaseio.com/");foodListRef.child("Day6").addListenerForSingleValueEvent(this);
    }


}






