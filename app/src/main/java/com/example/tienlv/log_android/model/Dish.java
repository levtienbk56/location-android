package com.example.tienlv.log_android.model;

import android.util.Log;

import java.util.ArrayList;

public class Dish extends Item{
    private String ingredients;
    private String type;
    private ArrayList<String> images;

    public Dish(){
        super();
        ingredients = "";
        type= "";
        images = new ArrayList<>();
    }

    //for search item
    public Dish(String id, String name, String description, String thumbnail ) {
        super(id, name, description, "food", thumbnail, "");
        this.images = new ArrayList<>();
    }


    public void show(){
        Log.d("Dish Detail", "===========================================================================");
        Log.d("Dish Detail", this.id);
        Log.d("Dish Detail", this.name);
        Log.d("Dish Detail", this.thumbnail);
        Log.d("Dish Detail", "===========================================================================");
    }
    //<editor-fold desc="getter & setter ">
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
    //</editor-fold >
}
