package com.example.tienlv.log_android.screens.dish_on_location;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.dish.DishPresenter;

public class DishOLActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_ol);

        //init
        DishOLPresenter presenter = new DishOLPresenter(this);
    }

    public void reloadView() {
        TextView tvName = (TextView) findViewById(R.id.tv_name_dish_ol);
        TextView tvPrice = (TextView) findViewById(R.id.tv_price_dish_ol);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description_dish_ol);
        TextView tvNameLocation = (TextView) findViewById(R.id.tv_name_location_dish_ol);
        TextView tvAddress = (TextView) findViewById(R.id.tv_address_dish_ol);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_location_dish_ol);

        tvName.setText(DishOLPresenter.dishOL.getDish().getName());
        tvPrice.setText(DishOLPresenter.dishOL.getPrice()+"$");
        tvDescription.setText(DishOLPresenter.dishOL.getDish().getDescription()+"$");
        tvNameLocation.setText(DishOLPresenter.dishOL.getLocation().getName());
        tvAddress.setText(DishOLPresenter.dishOL.getLocation().getAddress());
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DishOLPresenter.detailLocation();
            }
        });
    }
}
