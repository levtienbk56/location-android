package com.example.tienlv.log_android.model;

import java.util.ArrayList;

public class Disk {
    private String name = "";
    private int price = 0;
    private String address = "";
    private ArrayList<String> images = new ArrayList<String>();

    public Disk(){

    }

    public String getName() {
        return name;
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
}
