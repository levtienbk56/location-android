package com.example.tienlv.log_android.screens.dish;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.DishOL;
import com.example.tienlv.log_android.screens.dish.http.AnalyzeDishData;
import com.example.tienlv.log_android.screens.dish_on_location.DishOLActivity;

import java.util.ArrayList;

public class DishPresenter {
    public static DishActivity activity;
    public static Dish dish;
    public static ArrayList<DishOL> dishOLs;
    public static LogAPI logAPI;

    public DishPresenter(DishActivity activity) {
        DishPresenter.activity = activity;
        logAPI = new LogAPI(activity);
        dish = new Dish();
        dishOLs = new ArrayList<>();

        //get dishId from previous activity
        Bundle extra = DishPresenter.activity.getIntent().getExtras();
        String dishId = extra.getString("EXTRA_DISH_ID");
        loadDishData(dishId);
        Log.d("DishActivity", "Dish ID: " + dishId);
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

    //<editor-fold desc="load dish's detail data from Internet">
    public void loadDishData(String dishId) {
        AnalyzeDishData task = new AnalyzeDishData();
        task.execute("http://52.74.170.49:8080/foodie/food/details/id?id=" + dishId);
    }
    //</editor-fold>

    public static void reloadView() {
        activity.reloadView();
    }


}
