package com.example.tienlv.log_android.screens.location;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Location;

public class LocationActivity extends Activity implements ILocationActivity {
    LogAPI logAPI;
    public DishOLAdapter dishOLAdapter;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //init
        LocationPresenter presenter = new LocationPresenter(this);
        //logAPI = new LogAPI(this);

        listView = (ListView) findViewById(R.id.lv_dish_ol_detail_location);
        dishOLAdapter = new DishOLAdapter(this, LocationPresenter.dishOLs);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LocationPresenter.detailDishOL(position);
            }
        });

    }

    public void reloadView() {
        Location loc = LocationPresenter.location;

        //how to view image
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        ImageView imageView = (ImageView) findViewById(R.id.image_avatar_detail_location);

        //load image avatar dish
        if (!loc.getThumbnail().equals("")){
            ImageLoader imageLoader = new ImageLoader(this);
            imageLoader.displayImage(loc.getThumbnail() , imageView, width);
        }

        TextView tvName = (TextView) findViewById(R.id.tv_name_detail_location);
        TextView tvAddress = (TextView) findViewById(R.id.tv_address_detail_location);
        TextView tvTime = (TextView) findViewById(R.id.tv_time_detail_location);
        TextView tvPhone = (TextView) findViewById(R.id.tv_phone_detail_location);
        TextView tvDes = (TextView) findViewById(R.id.tv_description_detail_location);

        tvName.setText(loc.getName());
        tvAddress.setText(loc.getAddress());
        tvTime.setText("mở cửa: " + loc.getOpenTime() + "-" + loc.getCloseTime());
        tvPhone.setText("phone: " + loc.getTel());
        tvDes.setText(loc.getDescription());

        //reload listView
        dishOLAdapter.notifyDataSetChanged();
        listView.setAdapter(dishOLAdapter);
    }

}
