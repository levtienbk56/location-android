package com.example.tienlv.log_android.http;

import android.util.Log;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tienlv on 2/5/15.
 */
public class HttpPutTask extends HttpTask {
    /**
     * @param args args[0]: url, args[1]: data
     * @return
     */
    @Override
    protected String doInBackground(String... args) {
        try {
            URL url = new URL(args[0]);
            String data = args[1];

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

            Log.d(TAG, "http put data: " + data);
            osw.write(data);
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
