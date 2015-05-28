package com.example.tienlv.log_android.screens.dish.http;

import android.util.Log;

import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.DishOL;
import com.example.tienlv.log_android.screens.dish.DishPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyzeDishData extends HttpGetTask {
    @Override
    protected void onPostExecute(String s) {
        DishPresenter.dish = new Dish();
        DishPresenter.dishOLs.clear();

        try {
            JSONObject json = new JSONObject(s);
            DishPresenter.dish.setId("" + json.optInt("aId", 0));
            DishPresenter.dish.setName("" + json.optString("name", ""));
            DishPresenter.dish.setDescription("" + json.optString("description", ""));

            JSONArray jsonArray = json.optJSONArray("images");
            if(jsonArray!=null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    DishPresenter.dish.getImages().add(jsonArray.getString(i));
                }
            }

            jsonArray = json.optJSONArray("fol");
            if(jsonArray != null) {
                JSONObject js;
                for (int i = 0; i < jsonArray.length(); i++) {
                    DishOL dishOL = new DishOL();
                    js = jsonArray.getJSONObject(i);

                    dishOL.setId(js.optInt("fl_id", 0) + "");
                    dishOL.setPrice(js.optInt("price", 0));
                    dishOL.getLocation().setId(js.optInt("location_id", 0) + "");
                    dishOL.getLocation().setAddress(js.optString("address", "") + "");

                    DishPresenter.dishOLs.add(dishOL);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("AnalyzeDishData", "dishOL size: "+DishPresenter.dishOLs.size());
        Log.d("AnalyzeDishData", "dish name: "+DishPresenter.dish.getName());
        //return to activity
        DishPresenter.reloadView();
    }
}
