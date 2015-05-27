package com.example.tienlv.log_android.http;

import android.os.AsyncTask;

/**
 * Created by tienlv on 1/30/15.
 */
public abstract class HttpTask extends AsyncTask<String, Void, String> {
    protected final String TAG = "HTTP_TASK";
    protected final String USER_AGENT = "Mozilla/5.0";

    protected abstract String doInBackground(String... args) ;
}
