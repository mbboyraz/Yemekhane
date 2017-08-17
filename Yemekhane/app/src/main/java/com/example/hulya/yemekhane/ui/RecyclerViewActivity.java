package com.example.hulya.yemekhane.ui;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;


/**
 * Created by hulya on 14.08.2017.
 */

public class RecyclerViewActivity extends AppCompatActivity implements ValueEventListener {

    Toolbar toolbar;
    private RecyclerView rFoodList = null;
    private TextView txtDateInformation;
    private Firebase foodListRef;
    private Map<String,ArrayList<FoodListVM>> foodList = null;
    private Map<String, FirebaseDataList> firebaseDataListMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        Firebase.setAndroidContext(this);
//        foodListRef = new Firebase("https://refectory-84b81.firebaseio.com/");
//        foodListRef.child("Foods");
//        firebaseDataListMap = new HashMap<String, FirebaseDataList>();
//        firebaseDataListMap.put("Day1", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "16.08.2017"));
//        firebaseDataListMap.put("Day2", new FirebaseDataList("Tarhana Çorbası", "Kabak Çorbası", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "17.08.2017"));
//        firebaseDataListMap.put("Day3", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "18.08.2017"));
//        firebaseDataListMap.put("Day4", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "19.08.2017"));
//        firebaseDataListMap.put("Day5", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "20.08.2017"));
//        firebaseDataListMap.put("Day6", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "21.08.2017"));
//        firebaseDataListMap.put("Day7", new FirebaseDataList("Naneli Dövme Çorba", "Ev Usulü Tel Şehriye Çorba", "Nohutlu Pilav", "Soslu Makarna", "Domates Soslu Köfte", "Fajita Soslu Tavuk Kavurma",
//                "Bamya", "İzmir Kumru", "Ayran", "Special Salata", "22.08.2017"));
//        foodListRef.setValue(firebaseDataListMap);

        initView();
        DateInformation();

    }

    private void initView() {
        txtDateInformation = (TextView) findViewById(R.id.txtDateInformation);
        rFoodList = (RecyclerView) findViewById(R.id.activity_recycler_view_foodList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rFoodList.setLayoutManager(mLayoutManager);
        rFoodList.setItemAnimator(new DefaultItemAnimator());

        Firebase foodListRef = new Firebase("https://refectory-84b81.firebaseio.com/Day1");
        foodListRef.addListenerForSingleValueEvent(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        foodListRef.child("Day1");
    }

    public void DateInformation() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("EEEE-dd/MM/yyyy");
        txtDateInformation.setText(format.format(date).toString());
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        foodList = new Map<String, ArrayList<FoodListVM>>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object o) {
                return false;
            }

            @Override
            public boolean containsValue(Object o) {
                return false;
            }

            @Override
            public ArrayList<FoodListVM> get(Object o) {
                return null;
            }

            @Override
            public ArrayList<FoodListVM> put(String s, ArrayList<FoodListVM> foodListVMs) {
                return null;
            }

            @Override
            public ArrayList<FoodListVM> remove(Object o) {
                return null;
            }

            @Override
            public void putAll(@NonNull Map<? extends String, ? extends ArrayList<FoodListVM>> map) {

            }

            @Override
            public void clear() {

            }

            @NonNull
            @Override
            public Set<String> keySet() {
                return null;
            }

            @NonNull
            @Override
            public Collection<ArrayList<FoodListVM>> values() {
                return null;
            }

            @NonNull
            @Override
            public Set<Entry<String, ArrayList<FoodListVM>>> entrySet() {
                return null;
            }
        };

        FoodListVM foodListVM = new FoodListVM();
        foodListVM.setFoodType("ÇORBALAR");
        foodListVM.setFoodName1(dataSnapshot.child("Soup1").getValue().toString());
        foodListVM.setFoodName2(dataSnapshot.child("Soup2").getValue().toString());
        foodListVM.setFoodImageLink1(R.mipmap.nanelicorba);
        foodListVM.setFoodImageLink2(R.mipmap.telsehriye2);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("BAŞLANGIÇ");
        foodListVM.setFoodName1(dataSnapshot.child("Entree1").getValue().toString());
        foodListVM.setFoodName2("Soslu Makarna");
        foodListVM.setFoodImageLink1(R.mipmap.pilav2);
        foodListVM.setFoodImageLink2(R.mipmap.soslumakarna);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("ANA YEMEK");
        foodListVM.setFoodName1("Domates Soslu Köfte");
        foodListVM.setFoodName2("Fajita Soslu Tavuk Kavurma");
        foodListVM.setFoodName3("Bamya");
        foodListVM.setFoodImageLink1(R.mipmap.soslukofte);
        foodListVM.setFoodImageLink2(R.mipmap.fajita);
        foodListVM.setFoodImageLink3(R.mipmap.bamya);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("ALTERNATİF");
        foodListVM.setFoodName1("İzmir Kumru");
        foodListVM.setFoodName2("Ayran");
        foodListVM.setFoodName3("Special Salata");
        foodListVM.setFoodImageLink1(R.mipmap.kumru);
        foodListVM.setFoodImageLink2(R.mipmap.ayran);
        foodListVM.setFoodImageLink3(R.mipmap.specialsalata);
        foodList.add(foodListVM);

        FoodListAdapter foodListAdapter = new FoodListAdapter(foodList);

        rFoodList.setAdapter(foodListAdapter);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}






