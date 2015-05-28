package com.example.tienlv.log_android.screens.dish_on_location;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.DishOL;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.dish_on_location.http.AnalyzeDishData;
import com.example.tienlv.log_android.screens.location.LocationActivity;

public class DishOLPresenter {
    public static DishOLActivity activity;
    public static DishOL dishOL;
    public static Location location;
    public static LogAPI logAPI;

    public DishOLPresenter(DishOLActivity activity){
        DishOLPresenter.activity = activity;
        logAPI = new LogAPI(activity);
        dishOL = new DishOL();
        location = new Location();

        //get dishId from previous activity
        Bundle extra = DishOLPresenter.activity.getIntent().getExtras();
        String dishOLId = extra.getString("EXTRA_DISH_OL_ID");
        Log.d("DishOL", "dish ol ID: " + dishOLId);
        loadDishOLData(dishOLId);
    }

    //<editor-fold desc="load dish on location's detail data from Internet">
    public void loadDishOLData(String dishOL) {
        AnalyzeDishData task = new AnalyzeDishData();
        task.execute("http://52.74.170.49:8080/foodie/foodonlocation/details/id?id=" + dishOL);
    }
    //</editor-fold>

    public static void reloadView() {
        activity.reloadView();
    }

    public static void detailLocation(){
        //write log
        logAPI.insertLog(LogAPI.EVENT_VIEW_DETAIL_LOCATION, dishOL.getLocation().getId());

        Intent intent = new Intent(activity, LocationActivity.class);
        intent.putExtra("EXTRA_LOCATION_ID", dishOL.getLocation().getId());
        activity.startActivity(intent);
    }

}
