package com.example.tienlv.log_android.screens.location;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.DishOL;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.dish_on_location.DishOLActivity;
import com.example.tienlv.log_android.screens.location.http.AnalyzeDishData;


import java.util.ArrayList;

public class LocationPresenter {
    public static LocationActivity activity;
    public static Location location;
    public static ArrayList<DishOL> dishOLs;
    public static LogAPI logAPI;

    public LocationPresenter(LocationActivity activity) {
        LocationPresenter.activity = activity;
        logAPI = new LogAPI(activity);
        location = new Location();
        dishOLs = new ArrayList<>();

        //get dishId from previous activity
        Bundle extra = LocationPresenter.activity.getIntent().getExtras();
        String locationId = extra.getString("EXTRA_LOCATION_ID");
        Log.d("Location", "Location ID: " + locationId);
        loadDishData(locationId);
    }


    //<editor-fold desc="load dish's detail data from Internet">
    public void loadDishData(String locationId) {
        AnalyzeDishData task = new AnalyzeDishData();
        task.execute("http://52.74.170.49:8080/foodie/location/details/id?id=" + locationId);
    }
    //</editor-fold>

    public static void reloadView() {
        activity.reloadView();
    }

    //<editor-fold desc= "jump to dish on location detail screen"
    public static void detailDishOL(int position) {
        //write log
        logAPI.insertLog(LogAPI.EVENT_VIEW_DETAIL_DISH_OL, dishOLs.get(position).getId());

        Intent intent = new Intent(activity, DishOLActivity.class);
        intent.putExtra("EXTRA_DISH_OL_ID", dishOLs.get(position).getId());
        activity.startActivity(intent);
    }
    //</editor-fold>
}
