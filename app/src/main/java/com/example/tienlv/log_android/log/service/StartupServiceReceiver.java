/**
 * khong dung den
 */


package com.example.tienlv.log_android.log.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartupServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, MyService.class);
        context.startService(service);
    }
}