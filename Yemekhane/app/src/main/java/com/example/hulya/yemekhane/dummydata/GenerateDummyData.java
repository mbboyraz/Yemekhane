package com.example.hulya.yemekhane.dummydata;

import com.example.hulya.yemekhane.R;
import com.example.hulya.yemekhane.viewmodel.FoodListVM;

import java.util.ArrayList;

/**
 * Created by hulya on 14.08.2017.
 */

public class GenerateDummyData {

    public static ArrayList<FoodListVM> generateDummyList() {

        ArrayList<FoodListVM> foodList = new ArrayList<>();

        FoodListVM foodListVM = new FoodListVM();
        foodListVM.setFoodType("ÇORBALAR");
        foodListVM.setFoodName1("Naneli Dövme Çorba");
        foodListVM.setFoodName2("Ev Usulü Tel Şehriye Çorba");
        foodListVM.setFoodImageLink1(R.mipmap.nanelicorba);
        foodListVM.setFoodImageLink2(R.mipmap.telsehriye2);
        foodList.add(foodListVM);

        foodListVM = new FoodListVM();
        foodListVM.setFoodType("BAŞLANGIÇ");
        foodListVM.setFoodName1("Nohutlu Pilav");
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

        return foodList;


    }
}
