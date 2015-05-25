package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tienlv.log_android.http.HttpTask;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.screens.dish.DishActivity;
import com.example.tienlv.log_android.screens.search.SearchActivity;

import java.util.ArrayList;

public class HomePresenter {
    private static HomeActivity activity;
    private static ArrayList<Dish> arrayList = new ArrayList<Dish>();
    private LogAPI logAPI;

    public HomePresenter(HomeActivity activity) {
        this.activity = activity;
        logAPI = new LogAPI(activity);

        //========most important initialize ============//
        //it dont need now,
        //initStartupReceiver();


        //temp data in list view
        Dish dish1 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish2=  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish3 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish4 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish5 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish6 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish7 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        Dish dish8 =  new Dish("Chè tự chọn Bách Khoa", 12, "121 Tạ QUang Bửu, p.Bách Khoa, Hai Bà Trưng");
        arrayList.add(dish1);
        arrayList.add(dish2);
        arrayList.add(dish3);
        arrayList.add(dish4);
        arrayList.add(dish5);
        arrayList.add(dish6);
        arrayList.add(dish7);
        arrayList.add(dish8);
    }

    public static void addDish(Dish dish){
        arrayList.add(dish);
    }

    public static void clearDish(){
        arrayList.clear();
    }

    public static ArrayList<Dish> getDishList(){
        return arrayList;
    }

    public static void reloadListView(){
        activity.reloadListView();
    }

    /**
     * action for search Button :)
     */
    public void openSearch() {
        //insert db
        //logAPI.insertLog(LogAPI.EVENT_SEARCH_KEY, s);

        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }



    public void searchNear(View v) {
        //insert db
        //logAPI.insertLog(LogAPI.EVENT_SEARCH_NEAR_BY, homePresenter.locateUser());

        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }

    public void detailDisk(int position) {
        //logAPI.insertLog(LogAPI.EVENT_VIEW_DETAIL_DISH, homePresenter.getDishList().get(position).getId());

        Intent intent = new Intent(activity.getBaseContext(), DishActivity.class);
        intent.putExtra("EXTRA_DISH_NO", position);
        activity.startActivity(intent);
    }

    /**
     * get trend dish from server
     */
    public void requestDishs() {
        HttpTask task = new AnalyzeDishData();
        task.execute("http://54.169.170.248:8080/Foodie/webresources/food/newest");

    }
}
