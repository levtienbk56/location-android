package com.example.tienlv.log_android.model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

public class DeviceInfo extends AbstractModel{
    int os;
    String os_string;
    String manufacturer;
    String _id;  //imei
    String model;
    static DeviceInfo mInstance;

    final String TAG = "DEVICE";
    private final String ICE_CREAM_SANDWICH = "4.0";
    private final String ICE_CREAM_SANDWICH_MR1 = "4.0.3";
    private final String JELLY_BEAN = "4.1";
    private final String JELLY_BEAN_MR1 = "4.2";
    private final String JELLY_BEAN_MR2 = "4.3";
    private final String KITKAT = "4.4";
    private final String KITKAT_WATCH = "4.4W";
    private final String LOLLIPOP = "5";

    public static DeviceInfo getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DeviceInfo(ctx.getApplicationContext());
        }
        return mInstance;
    }


    public DeviceInfo(Context context) {

        manufacturer = Build.MANUFACTURER;
        model = Build.MODEL;

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        _id = telephonyManager.getDeviceId();
        if (_id == null) {
            _id = "NULL";
        }

        os = Build.VERSION.SDK_INT;
        switch (os) {
            case 14:
                os_string = ICE_CREAM_SANDWICH;
                break;
            case 15:
                os_string = ICE_CREAM_SANDWICH_MR1;
                break;
            case 16:
                os_string = JELLY_BEAN;
                break;
            case 17:
                os_string = JELLY_BEAN_MR1;
                break;
            case 18:
                os_string = JELLY_BEAN_MR2;
                break;
            case 19:
                os_string = KITKAT;
                break;
            case 20:
                os_string = KITKAT_WATCH;
                break;
            case 21:
                os_string = LOLLIPOP;
                break;
            default:
                os_string = "-1";   //unknown
        }
    }

    public void showAll() {
        Log.d(TAG, "manufacturer: " + manufacturer);
        Log.d(TAG, "model: " + model);
        Log.d(TAG, "os: " + os);
        Log.d(TAG, "_id: " + _id);
    }
}
