package com.example.tienlv.log_android.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tienlv on 2/5/15.
 */
public class HttpGetTask extends HttpTask {

    @Override
    protected String doInBackground(String... args) {
        try {

            URL url = new URL(args[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            Log.d(TAG, "Sending 'GET' request to URL : " + url);
            Log.d(TAG, "Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            Log.d(TAG, response.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
