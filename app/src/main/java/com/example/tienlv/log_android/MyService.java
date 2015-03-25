package com.example.tienlv.log_android;

import java.util.ArrayList;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private final IBinder mBinder = new MyBinder();
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //do something
        //...
        Log.d("MyService", "onStartCommand");
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return mBinder;
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

}