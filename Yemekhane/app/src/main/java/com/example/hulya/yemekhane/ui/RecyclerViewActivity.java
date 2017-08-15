package com.example.hulya.yemekhane.ui;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.hulya.yemekhane.R;
import com.example.hulya.yemekhane.adapter.FoodListAdapter;
import com.example.hulya.yemekhane.dummydata.GenerateDummyData;
import com.example.hulya.yemekhane.viewmodel.FoodListVM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by hulya on 14.08.2017.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    private RecyclerView rFoodList=null;
    private ArrayList<FoodListVM> foodList = null;
    private TextView txtDateInformation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);


        initView();
        DateInformation();

    }

    private void initView(){
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        rFoodList = (RecyclerView)findViewById(R.id.activity_recycler_view_foodList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rFoodList.setLayoutManager(mLayoutManager);
        rFoodList.setItemAnimator(new DefaultItemAnimator());

        foodList = GenerateDummyData.generateDummyList();

        FoodListAdapter foodListAdapter = new FoodListAdapter(foodList);

        rFoodList.setAdapter(foodListAdapter);
    }


    public void DateInformation() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("EEEE-dd/MM/yyyy");
        txtDateInformation.setText(format.format(date).toString());
    }
    }






