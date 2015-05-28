package com.example.tienlv.log_android.model;

public class DishOL{
    private String id;
    private int price;
    private Dish dish;
    private Location location;

    //<editor-fold desc="getter & setter ">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    //</editor-fold >

    public DishOL(){
        id= "";
        price = 0;
        dish = new Dish();
        location = new Location();
    }

    public DishOL(String id, int price, Dish dish, Location location) {
        this.id = id;
        this.price = price;
        this.dish = dish;
        this.location = location;
    }
}
