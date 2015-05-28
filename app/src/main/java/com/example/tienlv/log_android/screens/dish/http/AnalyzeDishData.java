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
            DishPresenter.dish.setId("" + json.getInt("aId"));
            DishPresenter.dish.setName("" + json.getString("name"));
            DishPresenter.dish.setDescription("" + json.getString("description"));

            JSONArray jsonArray = json.getJSONArray("images");
            for (int i = 0; i < jsonArray.length(); i++) {
                DishPresenter.dish.getImages().add(jsonArray.getString(i));
            }

            jsonArray = json.optJSONArray("fol");
            if(jsonArray != null) {
                JSONObject js;
                for (int i = 0; i < jsonArray.length(); i++) {
                    DishOL dishOL = new DishOL();
                    js = jsonArray.getJSONObject(i);

                    dishOL.setId(js.getInt("fl_id") + "");
                    dishOL.setPrice(js.getInt("price"));
                    dishOL.getLocation().setId(js.getInt("location_id") + "");
                    dishOL.getLocation().setAddress(js.getString("address") + "");

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
