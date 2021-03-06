package com.example.tienlv.log_android.log.model;

/**
 * Created by tienlv on 1/26/15.
 */
public class Log extends AbstractModel {
    private String eventName;
    private String date;
    private String value;


    public Log(int _id, String eventName, String date, String value) {
        this._id = _id;
        this.eventName = eventName;
        this.date = date;
        this.value = value;
    }
    public Log(){}

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
