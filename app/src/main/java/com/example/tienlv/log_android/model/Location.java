package com.example.tienlv.log_android.model;


import java.util.ArrayList;

public class Location extends Item{
    private String name = "";
    private String address = "";
    private ArrayList<Dish> dishs = new ArrayList<Dish>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(ArrayList<Dish> dishs) {
        this.dishs = dishs;
    }

    public Location(){

    }

}
