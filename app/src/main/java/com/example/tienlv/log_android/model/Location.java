package com.example.tienlv.log_android.model;


import android.util.Log;

import java.util.ArrayList;

public class Location extends Item{
    private String address;
    private String city;
    private String tel;
    private String openTime;
    private String closeTime;
    private ArrayList<Dish> dishs;
    private ArrayList<String> images;
    private ArrayList<Comment> comments;
    private ArrayList<Like> likes;

    public Location(){
        address = "";
        city = "";
        tel = "";
        openTime = "";
        closeTime = "";
        dishs = new ArrayList<>();
        images = new ArrayList<>();
        comments = new ArrayList<>();
        likes = new ArrayList<>();
    }
    //for testing
    //search item
    public Location(String id, String name, String address, String description, String thumbnail){
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.thumbnail = thumbnail;
    }

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

    public ArrayList<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(ArrayList<Dish> dishs) {
        this.dishs = dishs;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void show(){
        Log.d("location Detail", "===========================================================================");
        Log.d("location Detail", this.id);
        Log.d("location Detail", this.name);
        Log.d("location Detail", this.address);
        Log.d("location Detail", this.thumbnail);
        Log.d("location Detail", "===========================================================================");
    }
}
