package com.example.tienlv.log_android.screens.dish_on_location.http;

import android.util.Log;

import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.DishOL;
import com.example.tienlv.log_android.screens.dish.DishPresenter;
import com.example.tienlv.log_android.screens.dish_on_location.DishOLPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyzeDishData extends HttpGetTask {
    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject json = new JSONObject(s);
            DishOL dishOL = new DishOL();
            dishOL.setId(json.optInt("fl_id", 0) + "");
            dishOL.setPrice(json.optInt("price", 0));
            dishOL.getDish().setName(json.optString("foodName", ""));
            dishOL.getDish().setDescription(json.optString("description",""));
            dishOL.getDish().setThumbnail(json.optString("thumbnail", ""));
            dishOL.getLocation().setAddress(json.optString("address", ""));
            dishOL.getLocation().setId(json.optInt("location_id", 0) + "");

            DishOLPresenter.dishOL = dishOL;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("DIshOL AnalyzeData", "address: " + DishOLPresenter.dishOL.getLocation().getAddress());
        //return to activity
        DishOLPresenter.reloadView();
    }
}
