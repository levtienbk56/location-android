package com.example.tienlv.log_android.screens.search;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

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

    public static void loadData(String keyword){
        Log.d(TAG, "keyword: " +keyword);
        AnalyzeDishData task = new AnalyzeDishData();
        task.execute("http://52.74.170.49:8080/foodie/search/query?q=" + keyword);
        reloadView();
    }

    public static void reloadView(){
        DishFragment.reloadListView();
        LocationFragment.reloadListView();
    }

    //<editor-fold desc = "test with temp data"
    private void testData(){
        //test listview with temp data
        Dish dish = new Dish("d0001", "Phở & lẩu bò", "36 Lê Thanh Nghị, Hà nội", "ăn rồi lại muốn quay lại",  "");
        Dish dish1 = new Dish("d0002", "Phở Thìn", "Lò Đúc, quận Hai Bà Trưng, Hà Nội", "bát to, nhiều thịt, nên giá cũng đắt",  "");
        Dish dish2 = new Dish("d0001", "Phở  Bò Huế", "số 2, đường Láng, Hà nội", "quán ngay ngã tư sở. địa điểm đông khác nên hơi chật chội",  "");
        Dish dish3 = new Dish("d0001", "phở Bò Huế", "36 Võ thị Sáu, tp.Hồ CHí Minh", "ăn rồi lại muốn quay lại",  "");
        dishes.add(dish);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish3);
        dishes.add(dish1);
        dishes.add(dish2);

        //test listview with temp data
        Location location = new Location("l0001", "Phở cuốn Hương Mai", "27 Ngũ Xã, Quận Ba Đình, Hà Nội", "món ngon, không gian thoáng đãng", "");
        Location location1 = new Location("l0001", "Phở Bò 36", "36 Lê Thanh Nghị, Hà nội", "món ngon, không gian thoáng đãng", "");
        Location location2 = new Location("l0001", "cafe BrotherHood", "số 2, đường Láng, Hà nội", "món ngon, không gian thoáng đãng", "");
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
