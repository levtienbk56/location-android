package com.example.tienlv.log_android.model;

import java.util.ArrayList;


public class Album extends Item {
    private String name = "";
    private String nameCreator = "";
    private ArrayList<Disk> disks = new ArrayList<Disk>();

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

    public ArrayList<Disk> getDisks() {
        return disks;
    }

    public void setDisks(ArrayList<Disk> disks) {
        this.disks = disks;
    }
}
