package com.example.tienlv.log_android.screens.location;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.home.HomePresenter;

public class LocationActivity extends Activity implements ILocationActivity {
    private LocationPresenter presenter;
    LogAPI logAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //init
        presenter = new LocationPresenter(this);
        //logAPI = new LogAPI(this);


        //get locationID from previous activity
        Bundle extra = getIntent().getExtras();
        String locationId = extra.getString("EXTRA_LOCATION_ID");
        LocationPresenter.loadLocationData(locationId);
        Log.d("LocationActivity", "locationId: " + locationId);
    }

    public void reloadView() {

    }

    /*
    public void like(View v){
        //change image
        ImageButton ib = (ImageButton) findViewById(R.id.ib_like);
        ib.setImageResource(R.drawable.heart);

        //insert db
        logAPI.insertLog(LogAPI.EVENT_LIKE_DISH, presenter.getDish().getId());
    }
    */

}
