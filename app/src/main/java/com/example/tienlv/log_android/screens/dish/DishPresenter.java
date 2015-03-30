package com.example.tienlv.log_android.screens.dish;

import android.graphics.drawable.Drawable;

import com.example.tienlv.log_android.model.Dish;

public class DishPresenter {
    private static IDishActivity activity;
    private static Dish dish;

    public DishPresenter(DishActivity activity) {
        this.activity = activity;
    }

    public static void replaceDish(Dish mdish) {
        dish = mdish;
    }

    public static void reloadView() {
        activity.reloadView();
    }

    public Dish getDish() {
        return dish;
    }
}
