package com.example.tienlv.log_android.model;

import android.util.Log;

import java.util.ArrayList;

public class Dish extends Item{
    private int price;
    private String address;
    private String locationID;
    private int likeCount;
    private int commentCount;
    private String ingredients;
    private ArrayList<String> images;
    private ArrayList<Comment> comments;
    private ArrayList<Like> likes;

    public Dish(){
        name = "";
        id = "";
        locationID = "";
        address = "";
        price = 0;
        thumbnail = "";
        description = "";
        type= "";
        createBy = "";
        likeCount = 0;
        commentCount = 0;
        ingredients = "";
        images = new ArrayList<>();
        comments = new ArrayList<>();
        likes = new ArrayList<>();
    }

    //search item
    public Dish(String id, String name, String address, String description, String thumbnail) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.thumbnail = thumbnail;
        this.name = name;
        this.images = new ArrayList<>();
    }

    public Dish (String name, int likeCount, String address){
        this.name = name;
        this.address = address;
        this.likeCount  = likeCount;
        this.images = new ArrayList<>();
    }

    public void show(){
        Log.d("Dish Detail", "===========================================================================");
        Log.d("Dish Detail", this.id);
        Log.d("Dish Detail", this.name);
        Log.d("Dish Detail", this.address);
        Log.d("Dish Detail", this.thumbnail);
        Log.d("Dish Detail", "===========================================================================");
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
