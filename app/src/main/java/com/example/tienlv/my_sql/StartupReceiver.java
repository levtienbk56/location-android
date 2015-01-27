package com.example.tienlv.my_sql;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class StartupReceiver extends BroadcastReceiver{
    static final String TAG = "SR";
    final int startupID  = 1111110;
    final int startupID2  = 1111111;
    @Override
    public void onReceive(Context context, Intent intent) {
        final AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        try{
            //start for checking running app
            Intent i = new Intent(context, CheckRunningApplicationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, startupID, i, 0);
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 10000, pendingIntent);

            //start Service for upload data
            Intent i2 = new Intent(context, ServerUploadReceiver.class);
            PendingIntent pendingIntent2 = PendingIntent.getBroadcast(context, startupID2, i2, 0);

            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), LogAPI.step, pendingIntent2);

        }catch(Exception e){
            Log.i(TAG, "Exception:" +e);
        }
    }

}
