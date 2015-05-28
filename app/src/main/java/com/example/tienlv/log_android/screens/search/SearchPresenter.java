package com.example.tienlv.log_android.screens.search;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.dish.DishActivity;
import com.example.tienlv.log_android.screens.location.LocationActivity;
import com.example.tienlv.log_android.screens.search.http.AnalyzeDishData;

import java.util.ArrayList;

public class SearchPresenter {
    private static final String  TAG = "SEARCH_PRESENTER";
    private static SearchActivity activity;
    public static ArrayList<Dish> dishes;
    public static ArrayList<Location> locations;
    public static Fragment diskFragment;
    public static Fragment locationFragment;
    public static Fragment albumFragment;
    public static LogAPI logAPI;

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
        logAPI = new LogAPI(activity);

        diskFragment = new DishFragment();
        locationFragment = new LocationFragment();
        albumFragment = new AlbumFragment();

        dishes = new ArrayList<>();
        locations = new ArrayList<>();

        //loadData("ngon");
        //testData();
    }

    //<editor-fold desc = "navigate to activity"
    public static void detailDish(int position){
        //write log
        logAPI.insertLog(LogAPI.EVENT_VIEW_DETAIL_DISH, dishes.get(position).getId());

        Intent intent = new Intent(activity, DishActivity.class);
        intent.putExtra("EXTRA_DISH_ID", dishes.get(position).getId());
        activity.startActivity(intent);
    }
    public static void detailLocation(int position){
        //write log
        logAPI.insertLog(LogAPI.EVENT_VIEW_DETAIL_LOCATION, locations.get(position).getId());

        Intent intent = new Intent(activity, LocationActivity.class);
        intent.putExtra("EXTRA_LOCATION_ID", locations.get(position).getId());
        activity.startActivity(intent);
    }
    //</editor-fold>

    public static void loadData(String keyword){
        //write log
        logAPI.insertLog(LogAPI.EVENT_SEARCH_BY_KEY, keyword);

        AnalyzeDishData task = new AnalyzeDishData();
        task.execute("http://52.74.170.49:8080/foodie/search/query?q=" + keyword);
    }

    public static void reloadView(){
        DishFragment.reloadListView();
        LocationFragment.reloadListView();
    }

    //<editor-fold desc = "test with temp data"
    private void testData(){
        //test listview with temp data
        Dish dish = new Dish("12", "Phở & lẩu bò", "ăn rồi lại muốn quay lại", "");
        Dish dish1 = new Dish("2", "Phở Thìn",  "bát to, nhiều thịt, nên giá cũng đắt",  "");
        Dish dish2 = new Dish("3", "Phở  Bò Huế", "quán ngay ngã tư sở. địa điểm đông khác nên hơi chật chội",  "");
        Dish dish3 = new Dish("21", "phở Bò Huế", "ăn rồi lại muốn quay lại",  "");
        dishes.add(dish);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish3);
        dishes.add(dish1);
        dishes.add(dish2);

        //test listview with temp data
        Location location = new Location("1", "Phở cuốn Hương Mai", "món ngon, không gian thoáng đãng","", "27 Ngũ Xã, Quận Ba Đình, Hà Nội");
        Location location1 = new Location("12", "Phở Bò 36",  "món ngon, không gian thoáng đãng","", "36 Lê Thanh Nghị, Hà nội");
        Location location2 = new Location("23", "cafe BrotherHood",  "món ngon, không gian thoáng đãng","", "số 2, đường Láng, Hà nội");
        locations.add(location);
        locations.add(location1);
        locations.add(location2);
        locations.add(location1);
        locations.add(location1);
        locations.add(location);
        locations.add(location);
    }
    //</editor-fold>

}
