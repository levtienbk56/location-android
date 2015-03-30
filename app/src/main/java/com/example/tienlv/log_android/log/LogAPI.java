package com.example.tienlv.log_android.log;

import android.content.Context;

import com.example.tienlv.log_android.log.model.LogModel;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by tienlv on 1/27/15.
 */
public class LogAPI {
    public static int checkStep = 10000;        //checking cycle
    public static int upStep = 3600000;         //server push cycle
    private MySQLiteOpenHelper dataHelper;

    public static final String EVENT_SEARCH_KEY = "SEARCH_KEY";
    public static final String EVENT_SEARCH_NEAR_BY = "SEARCH_NEAR_BY";

    public LogAPI(Context context) {
        dataHelper = MySQLiteOpenHelper.getInstance(context);
    }

    /**
     * get current time
     * @return datetime as string
     */
    private String getCurrentDate() {
        Calendar c = Calendar.getInstance();

        int seconds = c.get(Calendar.SECOND);
        int minus = c.get(Calendar.MINUTE);
        int hours = c.get(Calendar.HOUR_OF_DAY);
        int days = c.get(Calendar.DATE);
        int months = c.get(Calendar.MONTH);
        int years = c.get(Calendar.YEAR);

        return hours + ":" + minus + ":" + seconds + " " + days + "/" + months + "/" + years;
    }

    public void insertLog(String eventName, String value) {
        LogModel log = new LogModel();
        log.setEventName(eventName);
        log.setDate(getCurrentDate());
        log.setValue(value);

        dataHelper.insertLog(log);
    }

    public ArrayList<LogModel> getAllLog() {
        return dataHelper.getAllLog();
    }

}
