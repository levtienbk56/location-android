package com.example.tienlv.log_android.screens.search.http;

import android.util.Log;

import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Item;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.home.HomePresenter;
import com.example.tienlv.log_android.screens.search.SearchPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnalyzeDishData extends HttpGetTask {
    @Override
    protected void onPostExecute(String s) {
        SearchPresenter.dishes.clear();
        SearchPresenter.locations.clear();

        try {
            s = "{\"api1\":" + s + "}";
            JSONObject json = new JSONObject(s);
            JSONArray jsonArray = json.optJSONArray("api1");
            if(jsonArray != null) {
                Log.d("AnalyzeDishData", jsonArray.length() + "");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jDish = jsonArray.getJSONObject(i);

                    String type = jDish.optString("type", "");
                    String aId = "" + jDish.optInt("aId", 0);
                    String name = jDish.optString("name", "");
                    String description = jDish.optString("description", "");
                    String linkToThumbnail = jDish.optString("linkToThumbnail", "");

                    if (type.equals("food")) {
                        Dish dish = new Dish();
                        dish.setId(aId);
                        dish.setName(name);
                        dish.setDescription(description);
                        dish.setThumbnail(linkToThumbnail);

                        SearchPresenter.dishes.add(dish);
                    } else {
                        Location l = new Location();
                        l.setId(aId);
                        l.setName(name);
                        l.setDescription(description);
                        l.setThumbnail(linkToThumbnail);

                        SearchPresenter.locations.add(l);
                    }
                }
            }else{
                Log.d("AnalyzeDishData", "null array");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return to activity
        SearchPresenter.reloadView();
    }
}
