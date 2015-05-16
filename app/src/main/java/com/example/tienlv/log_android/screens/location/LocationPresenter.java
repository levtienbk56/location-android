package com.example.tienlv.log_android.screens.location;

import android.content.Intent;

import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Location;

import java.util.ArrayList;

public class LocationPresenter {
    private static LocationActivity activity;
    private static Location location;
    public static ArrayList<Dish> dishes = new ArrayList<>();

    public LocationPresenter(LocationActivity activity) {
        this.activity = activity;

        //for test
        Dish dish = new Dish("d0001", "bò lúc lắc", "36 Lê Thanh Nghị, Hà nội", "ăn rồi lại muốn quay lại",  "");
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
    }

    public static void reloadView() {
        activity.reloadView();
    }

    public static void loadLocationData(String locationID){
        //TODO: load location/restaurant data from internet
        //..

        //reload view
        activity.reloadView();
    }
}
