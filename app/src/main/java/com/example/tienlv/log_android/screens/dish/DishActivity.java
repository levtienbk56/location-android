package com.example.tienlv.log_android.screens.dish;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.model.Location;
import com.example.tienlv.log_android.screens.location.LocationPresenter;

public class DishActivity extends Activity implements IDishActivity {
    private DishPresenter presenter;
    LogAPI logAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        //init
        presenter = new DishPresenter(this);
        //logAPI = new LogAPI(this);

        //get dishId from previous activity
        Bundle extra = getIntent().getExtras();
        String dishId = extra.getString("EXTRA_DISH_ID");
        presenter.loadDishData(dishId);
        Log.d("DishActivity", "Dish ID: " + dishId);

        //show all information of dish
        reloadView();

    }

    /**
     * load new data, reload screen
     */
    public void reloadView() {
        Dish dish = presenter.getDish();
        Location location = presenter.getLocation();

        //how to view image
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        ImageView imageView = (ImageView) findViewById(R.id.image_avatar_detail_dish);

        //load image avatar dish
        if (!dish.getImages().isEmpty()){
            ImageLoader imageLoader = new ImageLoader(this);
            imageLoader.displayImage(presenter.getDish().getImages().get(0)
                    , imageView, width); 
        }

        //other information
        TextView tvName = (TextView) findViewById(R.id.tv_name_detail_dish);
        TextView tvLikeCount = (TextView) findViewById(R.id.tv_like_count_detail_dish);
        TextView tvCommentCount = (TextView) findViewById(R.id.tv_comment_count_detail_dish);
        TextView tvPrice = (TextView) findViewById(R.id.tv_price_detail_dish);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description_detail_dish);
        TextView tvNameLocation = (TextView) findViewById(R.id.tv_name_location_detail_dish);
        TextView tvAddress = (TextView) findViewById(R.id.tv_address_detail_dish);

        tvName.setText(dish.getName());
        tvLikeCount.setText(""+dish.getLikeCount());
        tvCommentCount.setText(""+dish.getLikeCount());
        tvPrice.setText(dish.getPrice()+"k");
        tvDescription.setText(dish.getDescription());

        //view location hyperlink
        viewLocationLink(location);

        //TODO: show album image in grid view
        //...

        //TODO: show list comment of users
        //...
    }

    /**
     * make location as hyperlink, U can click to view detail restaurant/location
     * @param location
     */
    public void viewLocationLink(Location location){
        String id = location.getId();
        TextView tvName = (TextView) findViewById(R.id.tv_name_location_detail_dish);
        TextView tvAddress = (TextView) findViewById(R.id.tv_address_detail_dish);

        tvName.setText(location.getName());
        tvAddress.setText(location.getAddress());

        //set Onclick
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_location_detail_dish);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DishPresenter.openLocationDetail();
            }
        });

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
