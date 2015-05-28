package com.example.tienlv.log_android.screens.dish;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.model.Dish;

public class DishActivity extends Activity implements IDishActivity {
    LogAPI logAPI;
    private DishOLAdapter dishOLAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        //init
        DishPresenter presenter = new DishPresenter(this);
        //logAPI = new LogAPI(this);
    }

    /**
     * load new data, reload screen
     */
    public void reloadView() {
        Dish dish = DishPresenter.dish;

        //how to view image
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        ImageView imageView = (ImageView) findViewById(R.id.image_avatar_detail_dish);

        //load image avatar dish
        if (!dish.getThumbnail().equals("")){
            ImageLoader imageLoader = new ImageLoader(this);
            imageLoader.displayImage(dish.getThumbnail() , imageView, width/2);
        }

        //other information of dish
        TextView tvName = (TextView) findViewById(R.id.tv_name_detail_dish);
        TextView tvDescription = (TextView) findViewById(R.id.tv_description_detail_dish);
        tvName.setText(dish.getName());
        tvDescription.setText(dish.getDescription());

        //reload listView
        listView = (ListView) findViewById(R.id.lv_dish_ol_detail_dish);
        dishOLAdapter = new DishOLAdapter(this, DishPresenter.dishOLs);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DishPresenter.detailDishOL(position);
            }
        });
        listView.setAdapter(dishOLAdapter);

        //TODO: show album image in grid view
        //...
        //createGridImage();
    }

    /**
     * show list image of dish into grid view
     */
    private void createGridImage(){
        GridView gridview = (GridView) findViewById(R.id.gv_image_detail_dish);
        gridview.setAdapter(new GridViewAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                showGridView();
            }
        });
    }
    private void showGridView(){
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }

}
