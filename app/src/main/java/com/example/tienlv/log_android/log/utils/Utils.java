package com.example.tienlv.log_android.log.utils;

import java.util.Calendar;

/**
 * Created by tienlv on 3/30/15.
 */
public class  Utils {
    /**
     * get current time
     *
     * @return datetime as string
     */
    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();

        int seconds = c.get(Calendar.SECOND);
        int minus = c.get(Calendar.MINUTE);
        int hours = c.get(Calendar.HOUR_OF_DAY);
        int days = c.get(Calendar.DATE);
        int months = c.get(Calendar.MONTH);
        int years = c.get(Calendar.YEAR);

        return hours + ":" + minus + ":" + seconds + " " + days + "/" + months + "/" + years;
    }

}
