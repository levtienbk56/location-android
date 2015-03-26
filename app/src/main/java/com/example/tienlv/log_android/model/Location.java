package com.example.tienlv.log_android.model;


import java.util.ArrayList;

public class Location extends Item{
    private String name = "";
    private String address = "";
    private ArrayList<Disk> disks = new ArrayList<Disk>();

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

    public ArrayList<Disk> getDisks() {
        return disks;
    }

    public void setDisks(ArrayList<Disk> disks) {
        this.disks = disks;
    }

    public Location(){

    }

}
