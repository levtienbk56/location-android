package com.example.tienlv.log_android.screens.home.http;

import android.util.Log;

import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.screens.dish.DishPresenter;
import com.example.tienlv.log_android.screens.home.HomePresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyzeDishData extends HttpGetTask {
    @Override
    protected void onPostExecute(String s) {
        HomePresenter.dishes.clear();
        try {
            s = "{\"api5\":" + s + "}";
            JSONObject json = new JSONObject(s);
            JSONArray jsonArray = json.optJSONArray("api5");
            if((jsonArray != null)){
                Log.d("AnalyzeDishData", jsonArray.length() + "");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jDish = jsonArray.getJSONObject(i);
                    Dish dish  = new Dish();
                    dish.setId(jDish.optInt("aId" ,0) + "");
                    dish.setName(jDish.optString("name", ""));
                    dish.setDescription(jDish.optString("description", ""));
                    dish.setThumbnail(jDish.optString("linkToThumbnail", ""));

                    HomePresenter.dishes.add(dish);
                }
            }else{
                Log.d("Home AnalyzeDishData", "size null");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return to activity
        HomePresenter.reloadListView();
    }
}
