package com.example.tienlv.log_android.screens.location.http;

import android.util.Log;

import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.DishOL;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.dish.DishPresenter;
import com.example.tienlv.log_android.screens.location.LocationPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyzeDishData extends HttpGetTask {
    @Override
    protected void onPostExecute(String s) {
        LocationPresenter.location = new Location();
        LocationPresenter.dishOLs.clear();

        try {
            JSONObject json = new JSONObject(s);
            LocationPresenter.location.setId("" + json.optInt("aId", 0));
            LocationPresenter.location.setName("" + json.optString("name", ""));
            LocationPresenter.location.setDescription("" + json.optString("description", ""));
            LocationPresenter.location.setAddress("" + json.optString("address", ""));
            LocationPresenter.location.setDescription("" + json.optString("description", ""));

            JSONArray jsonArray = json.optJSONArray("images");
            if(jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    LocationPresenter.location.getImages().add(jsonArray.getString(i));
                }
            }

            jsonArray = json.getJSONArray("fol");
            JSONObject js;
            for (int i = 0; i < jsonArray.length(); i++) {
                DishOL dishOL = new DishOL();
                js = jsonArray.getJSONObject(i);

                dishOL.setId(js.optInt("fl_id", 0) +"");
                dishOL.setPrice(js.optInt("price", 0));
                dishOL.getLocation().setId(js.optInt("location_id", 0) + "");
                dishOL.getDish().setName(js.optString("foodName", ""));

                Log.d("AnalyzeDishData", "dishOL size: "+ dishOL.getDish().getName());
                LocationPresenter.dishOLs.add(dishOL);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("AnalyzeDishData", "dishOL size: "+LocationPresenter.dishOLs.size());
        Log.d("AnalyzeDishData", "location name: "+LocationPresenter.location.getName());
        //return to activity
        LocationPresenter.reloadView();
    }
}
