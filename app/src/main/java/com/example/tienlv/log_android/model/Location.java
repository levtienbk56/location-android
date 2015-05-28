package com.example.tienlv.log_android.model;


import android.util.Log;

import java.util.ArrayList;

public class Location extends Item{
    private String address;
    private String city;
    private String tel;
    private String openTime;
    private String closeTime;
    private ArrayList<DishOL> dishOLs;
    private ArrayList<String> images;

    public Location(){
        super();
        address = "";
        city = "";
        tel = "";
        openTime = "";
        closeTime = "";
        dishOLs = new ArrayList<>();
        images = new ArrayList<>();
    }

    public Location (String id, String name, String description, String thumbnail, String address){
        super(id, name, description, "location", thumbnail, "");
        this.address = address;
        dishOLs = new ArrayList<>();
        images = new ArrayList<>();
    }

    public void show(){
        Log.d("location Detail", "===========================================================================");
        Log.d("location Detail", this.id);
        Log.d("location Detail", this.name);
        Log.d("location Detail", this.address);
        Log.d("location Detail", this.thumbnail);
        Log.d("location Detail", "===========================================================================");
    }

    //<editor-fold desc = "getter & setter">

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public ArrayList<DishOL> getDishOLs() {
        return dishOLs;
    }

    public void setDishOLs(ArrayList<DishOL> dishOLs) {
        this.dishOLs = dishOLs;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    //</editor-fold>
}
