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
import com.example.hulya.yemekhane.dummydata.FirebaseDataList;
import com.example.hulya.yemekhane.dummydata.GenerateDummyData;
import com.example.hulya.yemekhane.viewmodel.FoodListVM;
import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by hulya on 14.08.2017.
 */

public class RecyclerViewActivity extends AppCompatActivity implements ChildEventListener {

    Toolbar toolbar;
    private RecyclerView rFoodList=null;
    private ArrayList<FoodListVM> foodList = null;
    private TextView txtDateInformation;
    private Firebase foodListRef;
    private Map<String, FirebaseDataList> firebaseDataListMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        Firebase.setAndroidContext(this);
        foodListRef = new Firebase("https://refectory-84b81.firebaseio.com/");
        foodListRef.child("Foods");
        firebaseDataListMap = new HashMap<String, FirebaseDataList>();
        firebaseDataListMap.put("Day1", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "16.08.2017"));
        firebaseDataListMap.put("Day2", new FirebaseDataList("Tarhana Çorbası", "Kabak Çorbası", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "17.08.2017"));
        firebaseDataListMap.put("Day3", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "18.08.2017"));
        firebaseDataListMap.put("Day4", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "19.08.2017"));
        firebaseDataListMap.put("Day5", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "20.08.2017"));
        firebaseDataListMap.put("Day6", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "21.08.2017"));
        firebaseDataListMap.put("Day7", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "22.08.2017"));
        foodListRef.setValue(firebaseDataListMap);

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

    @Override
    protected void onStart() {
        super.onStart();
        foodListRef.child("Day1");

    }

    public void DateInformation() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("EEEE-dd/MM/yyyy");
        txtDateInformation.setText(format.format(date).toString());
    }


}






