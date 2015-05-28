package com.example.tienlv.log_android.screens.home;

import android.util.Log;

import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.model.Dish;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyzeDishData extends HttpGetTask {
    @Override
    protected void onPostExecute(String s) {
        HomePresenter.clearDish();
        try {
            s = "{\"favor\":" + s + "}";
            JSONObject json = new JSONObject(s);
            JSONArray jsonArray = json.getJSONArray("favor");
            Log.d("AnalyzeDishData", jsonArray.length() + "");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jDish = jsonArray.getJSONObject(i);

                Dish dish = new Dish();
                dish.setId(jDish.getString("id"));

                //them vao array
                HomePresenter.addDish(dish);
                dish.show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return to activity
        HomePresenter.reloadListView();
    }
}
