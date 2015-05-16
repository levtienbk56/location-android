package com.example.tienlv.log_android.screens.dish;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.location.LocationActivity;

import java.util.ArrayList;

public class DishPresenter {
    private static DishActivity activity;
    private static Dish dish = new Dish();
    private static Location location = new Location();

    //<editor-fold desc = " getter & setter ">
    public Dish getDish() {
        return dish;
    }

    public static void setDish(Dish dish) {
        DishPresenter.dish = dish;
    }

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location) {
        DishPresenter.location = location;
    }

    //</editor-fold>

    public DishPresenter(DishActivity activity) {
        this.activity = activity;
        Dish dish = new Dish();
        location = new Location();
    }

    //<editor-fold desc= "jump to location detail screen"
    public static void openLocationDetail() {
        Intent intent = new Intent(activity, LocationActivity.class);
        intent.putExtra("EXTRA_LOCATION_ID", location.getId());
        activity.startActivity(intent);
    }
    //</editor-fold>

    //<editor-fold desc="load dish and location data from Internet">
    public void loadDishData(String dishId) {
        //TODO: use HTTP Client get Task to load dish's data from internet
        //TODO: location data, also

        //test with temp data
        dish.setName("Bò Lúc Lắc");
        dish.setId(dishId);
        dish.setLikeCount(12);
        dish.setCommentCount(2);
        dish.setAddress("41 Nguyễn Khắc Như, Ba Đình, Hà Nội");
        dish.setPrice(200);
        dish.setDescription("trời se se lạnh mà được ăn đồ nướng thì tuyệt vời. ăn lần một lại muốn ăn lần hai.");

        //test with temp data
        location.setName("Cafe 41 - For Everyone");
        location.setAddress("41 Nguyễn Khắc Như, Ba Đình, Hà Nội");

        //reload view
        activity.reloadView();
    }
    //</editor-fold>
}
