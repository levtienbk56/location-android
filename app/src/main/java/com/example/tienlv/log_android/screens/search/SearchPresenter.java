package com.example.tienlv.log_android.screens.search;

import android.content.Intent;

import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.dish.DishActivity;
import com.example.tienlv.log_android.screens.location.LocationActivity;

import java.util.ArrayList;

public class SearchPresenter {
    private static SearchActivity activity;
    public static ArrayList<Dish> dishes;
    public static ArrayList<Location> locations;

    // <editor-fold desc=" Getter & Setter">
    public static ArrayList<Dish> getDishes() {
        return dishes;
    }

    public static void setDishes(ArrayList<Dish> dishes) {
        SearchPresenter.dishes = dishes;
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

    public static void setLocations(ArrayList<Location> locations) {
        SearchPresenter.locations = locations;
    }
    // </editor-fold">

    public SearchPresenter(SearchActivity activity){
        this.activity = activity;
        dishes = new ArrayList<>();
        locations = new ArrayList<>();


        //test listview with temp data
        Dish dish = new Dish("d0001", "bò lúc lắc", "36 Lê Thanh Nghị, Hà nội", "ăn rồi lại muốn quay lại",  "");
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);
        dishes.add(dish);

        //test listview with temp data
        Location location = new Location("l0001", "Phở cuốn Hương Mai", "27 Ngũ Xã, Quận Ba Đình, Hà Nội", "món ngon, không gian thoáng đãng", "");
        locations.add(location);
        locations.add(location);
        locations.add(location);
        locations.add(location);
        locations.add(location);
        locations.add(location);
        locations.add(location);
    }

    //<editor-fold desc = "navigate to activity"
    public static void detailDish(int position){
        Intent intent = new Intent(activity, DishActivity.class);
        intent.putExtra("EXTRA_DISH_ID", dishes.get(position).getId());
        activity.startActivity(intent);
    }
    public static void detailLocation(int position){
        Intent intent = new Intent(activity, LocationActivity.class);
        intent.putExtra("EXTRA_LOCATION_ID", locations.get(position).getId());
        activity.startActivity(intent);
    }
    //</editor-fold>

    public static void loadData(){
        //TODO: load data from internet, when click SearchButton. use http task
        //..
    }
}
