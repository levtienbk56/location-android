package com.example.tienlv.my_sql;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class ServerUploadReceiver extends BroadcastReceiver {

    public final String TAG = "ServerUploadReceiver"; // ServerUploadReceiver
    private MySQLiteOpenHelper dataHelper;

    @Override
    public void onReceive(Context aContext, Intent anIntent) {
        try {
            Log.d(TAG, "try upload to server");
            //upload when wifi is connected
            if (isConnectedViaWifi(aContext)) {
                // which is data select from DB?
                // then  delete after upload?
                dataHelper = MySQLiteOpenHelper.getInstance(aContext);
                dataHelper.deleteAllEvent();
                Log.d(TAG, "wifi connected, uploading...");
            }else{
                Log.d(TAG, "network not available");
            }

        } catch (Throwable t) {
            Log.i(TAG, "Throwable caught: " + t.getMessage(), t);
        }

    }

    private boolean isConnectedViaWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWifi.isConnected();
    }
}