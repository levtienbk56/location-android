package com.example.tienlv.log_android.receiver;

import java.util.List;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import android.content.pm.ResolveInfo;
import android.os.PowerManager;
import android.util.Log;

import com.example.tienlv.log_android.MySQLiteOpenHelper;
import com.example.tienlv.log_android.model.EventModel;


public class CheckRunningApplicationReceiver extends BroadcastReceiver {

    public final String TAG = "CRAR"; // CheckRunningApplicationReceiver
    PackageManager packageManager;
    private MySQLiteOpenHelper dataHelper;

    @Override
    public void onReceive(Context aContext, Intent anIntent) {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            ResolveInfo resolveInfo = aContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
            String currentHomePackage = resolveInfo.activityInfo.packageName;

            //check whenever phone is interactive?
            if (isActive(aContext)) {
                dataHelper = MySQLiteOpenHelper.getInstance(aContext);

                packageManager = aContext.getPackageManager();
                List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

                ActivityManager am = (ActivityManager) aContext.getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningTaskInfo> alltasks = am.getRunningTasks(1); //get first app

                EventModel event;
                for (ActivityManager.RunningTaskInfo aTask : alltasks) {
                    for (PackageInfo pi : packageList) {
                        //only insert into DB: app is installed and except Launcher
                        if (aTask.topActivity.getPackageName().equals(pi.packageName.toString())
                                && !aTask.topActivity.getPackageName().equals(currentHomePackage)) {
                            String s = packageManager.getApplicationLabel(pi.applicationInfo).toString();
                            Log.d(TAG, "top app: " +s);

                            event = new EventModel();
                            event.setName(s);
                            dataHelper.insertEvent(event);
                        }
                    }

                }
            } else {
                Log.d(TAG, "phone sleeping");
            }

        } catch (Throwable t) {
            Log.i(TAG, "Throwable caught: "
                    + t.getMessage(), t);
        }

    }

    private boolean isActive(Context context) {
        //chỉ kiểm tra Running app khi User có tương tác vs điện thoại
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);

        if (android.os.Build.VERSION.SDK_INT < 20) {
            return pm.isScreenOn();
        } else {
            return pm.isInteractive();
        }
    }
}