package com.example.tienlv.my_sql.model;

/**
 * Created by tienlv on 1/26/15.
 */
public class LogModel {
    private int _id;
    private String eventName;
    private String date;
    private String value;


    public LogModel(int _id, String eventName, String date, String value) {
        this._id = _id;
        this.eventName = eventName;
        this.date = date;
        this.value = value;
    }
    public LogModel(){}

    public int get_id() {
        return _id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
