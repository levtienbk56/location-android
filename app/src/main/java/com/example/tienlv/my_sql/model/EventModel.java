package com.example.tienlv.my_sql.model;

/**
 * Created by tienlv on 1/26/15.
 */
public class EventModel {
    private String name;
    private int _id;

    public EventModel(int id, String name){
        this._id = id;
        this.name = name;
    }
    public EventModel(){

    }

    public String getName() {
        return name;
    }

    public int get_id() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
