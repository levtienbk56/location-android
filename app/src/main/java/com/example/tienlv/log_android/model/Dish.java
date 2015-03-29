package com.example.tienlv.log_android.model;

import android.util.Log;

import java.util.ArrayList;

public class Dish extends Item{
    private String name = "";
    private int price = 0;
    private String address = "";
    private String describe = "";
    private ArrayList<String> images = new ArrayList<String>();

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    private int likeCount = 0;

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }


    public void show(){
        Log.d("Dish Detail", "===========================================================================");
        Log.d("Dish Detail", this.id);
        Log.d("Dish Detail", this.name);
        Log.d("Dish Detail", this.address);
        Log.d("Dish Detail", this.images.get(0));
        Log.d("Dish Detail", "===========================================================================");
    }
}
