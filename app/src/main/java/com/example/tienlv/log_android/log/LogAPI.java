package com.example.tienlv.log_android.log;

import android.content.Context;

import com.example.tienlv.log_android.log.model.Log;
import com.example.tienlv.log_android.log.utils.Utils;

import java.util.ArrayList;

public class LogAPI {
    public static int checkStep = 15000;        //checking cycle
    public static int upStep = 3600000;         //server push cycle
    private MySQLiteOpenHelper dataHelper;

    public static final String EVENT_SEARCH_BY_KEY = "SEARCH_KEY";                  //tu khoa tim kiem
    public static final String EVENT_SEARCH_NEAR_BY = "SEARCH_NEAR_BY";             //vi tri cua nguoi dung
    public static final String EVENT_VIEW_DETAIL_DISH = "VIEW_DETAIL_DISH";         //xem chi tiet mon an
    public static final String EVENT_VIEW_DETAIL_LOCATION = "VIEW_DETAIL_LOCATION"; //xem chi tiet dia diem/restaurant
    public static final String EVENT_VIEW_DETAIL_DISH_OL = "VIEW_DETAIL_DISH_OL";   //xem chi tiet dia diem/restaurant
    public static final String EVENT_RUNNING_APP = "RUNNING_APP";                   //app dang chay
    public static final String EVENT_LIKE_DISH= "LIKE_DISH";                        //mon an nguoi dung like

    public LogAPI(Context context) {
        dataHelper = MySQLiteOpenHelper.getInstance(context);
    }

    public void insertLog(String eventName, String value) {
        Log log = new Log();
        log.setEventName(eventName);
        log.setDate(Utils.getCurrentDate());
        log.setValue(value);

        dataHelper.insertLog(log);
    }

    public ArrayList<Log> getAllLog() {
        return dataHelper.getAllLog();
    }

}
