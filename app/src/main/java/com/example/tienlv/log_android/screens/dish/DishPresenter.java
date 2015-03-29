package com.example.tienlv.log_android.screens.dish;

import com.example.tienlv.log_android.model.Dish;

public class DishPresenter {
    private static IDishActivity activity;
    private static Dish dish;

    public DishPresenter(DishActivity activity) {
        this.activity = activity;
    }

    public static void replaceDish(Dish mdish){
        dish = mdish;
    }
}
