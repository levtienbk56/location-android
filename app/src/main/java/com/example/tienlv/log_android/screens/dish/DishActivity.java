package com.example.tienlv.log_android.screens.dish;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;
import com.example.tienlv.log_android.screens.home.HomePresenter;
import com.example.tienlv.log_android.screens.search.SearchActivity;

public class DishActivity extends Activity implements IDishActivity {
    private DishPresenter presenter;
    LogAPI logAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        //init
        presenter = new DishPresenter(this);
        logAPI = new LogAPI(this);

        Bundle extra = getIntent().getExtras();
        int no = extra.getInt("EXTRA_DISH_NO");
        presenter.replaceDish(HomePresenter.getDishList().get(no));
        Log.d("DishActivity", "id: " + no);

        //show all information of dish
        reloadView();

    }

    public void reloadView() {
        ImageView imageView = (ImageView) findViewById(R.id.tv_avatar_dish);

        //load avatar dish
        if (!presenter.getDish().getImages().isEmpty()){
            ImageLoader imageLoader = new ImageLoader(this);
            imageLoader.displayImage(presenter.getDish().getImages().get(0)
                    , imageView, 320);  //320-requireSize

        }

        //other information
        TextView name = (TextView) findViewById(R.id.tv_name_disk);
        TextView like = (TextView) findViewById(R.id.tv_like_count);
        TextView address = (TextView) findViewById(R.id.tv_address_dish);

        name.setText(presenter.getDish().getName());
        like.setText("like: "+ presenter.getDish().getLikeCount());
        address.setText("d/c: "+presenter.getDish().getAddress());

    }


    public void like(View v){
        //change image
        ImageButton ib = (ImageButton) findViewById(R.id.ib_like);
        ib.setImageResource(R.drawable.heart);

        //insert db
        logAPI.insertLog(LogAPI.EVENT_LIKE_DISH, presenter.getDish().getId());
    }

}
