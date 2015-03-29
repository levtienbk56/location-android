package com.example.tienlv.log_android.screens.home;

import com.example.tienlv.log_android.model.Dish;

import java.util.ArrayList;

public class HomePresenter {
    private static IHomeActivity activity;
    private static ArrayList<Dish> arrayList = new ArrayList<Dish>();

    public HomePresenter(HomeActivity activity) {
        this.activity = activity;
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
}
