package com.example.tienlv.log_android.log.model;

/**
 * Created by tienlv on 1/26/15.
 */
public class Event extends AbstractModel {
    private String name;

    public Event(int id, String name){
        this._id = id;
        this.name = name;
    }
    public Event(){

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
