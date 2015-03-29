package com.example.tienlv.log_android.model;

import java.util.ArrayList;


public class Album extends Item {
    private String name = "";
    private String nameCreator = "";
    private ArrayList<Dish> dishs = new ArrayList<Dish>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCreator() {
        return nameCreator;
    }

    public void setNameCreator(String nameCreator) {
        this.nameCreator = nameCreator;
    }

    public ArrayList<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(ArrayList<Dish> dishs) {
        this.dishs = dishs;
    }
}
