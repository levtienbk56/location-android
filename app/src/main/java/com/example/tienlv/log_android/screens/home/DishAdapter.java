package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.model.Dish;

import java.util.ArrayList;

public class DishAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater = null;
    private ArrayList<Dish> arrayList;
    public ImageLoader imageLoader;

    public DishAdapter(Activity context, ArrayList<Dish> arrayList) {
        this.activity = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageLoader = new ImageLoader(this.activity.getApplicationContext());
    }

    public int getCount() {
        return arrayList.size();
    }

    public Dish getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.adapter_dish_home, null);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_home);
        TextView tvDesc = (TextView) convertView.findViewById(R.id.tv_description_home);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_dish_home);

        Dish dish = getItem(position);
        tvName.setText(dish.getName());
        tvDesc.setText(dish.getDescription());

        imageLoader.displayImage(dish.getThumbnail(), imageView, 100);  //100-requireSize

        return convertView;
    }
}
