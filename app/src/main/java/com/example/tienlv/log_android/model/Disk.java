package com.example.tienlv.log_android.model;

/**
 * Created by tienlv on 3/25/15.
 */
public class Disk {
    String name = "";
    int price = 0;
    String address = "";

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
}
