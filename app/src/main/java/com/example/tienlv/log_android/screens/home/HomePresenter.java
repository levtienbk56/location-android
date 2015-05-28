package com.example.tienlv.log_android.screens.home;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.example.tienlv.log_android.http.HttpTask;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.screens.dish.DishActivity;
import com.example.tienlv.log_android.screens.home.http.AnalyzeDishData;
import com.example.tienlv.log_android.screens.search.SearchActivity;

import java.util.ArrayList;

public class HomePresenter {
    private static HomeActivity activity;
    public static ArrayList<Dish> dishes = new ArrayList<Dish>();
    public static LogAPI logAPI;

    public HomePresenter(HomeActivity activity) {
        this.activity = activity;
        logAPI = new LogAPI(activity);

        // Start receiver with the name StartupReceiver_Manual_Start
        // Check AndroidManifest.xml file
        activity.getBaseContext().getApplicationContext().sendBroadcast( new Intent("StartupReceiver_Manual_Start"));

        loadData();
    }

    /**
     * action for search Button :)
     */
    public void openSearch() {
        //insert db
        //logAPI.insertLog(LogAPI.EVENT_SEARCH_BY_KEY, s);

        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }


    public static void detailDish(int position) {
        logAPI.insertLog(LogAPI.EVENT_VIEW_DETAIL_DISH, dishes.get(position).getId());

        Intent intent = new Intent(activity.getBaseContext(), DishActivity.class);
        intent.putExtra("EXTRA_DISH_ID", dishes.get(position).getId());
        activity.startActivity(intent);
    }

    public void loadData() {
        HttpTask task = new AnalyzeDishData();
        task.execute("http://52.74.170.49:8080/foodie/populated");
    }

    public static void reloadListView(){
        activity.reloadListView();
    }

}
