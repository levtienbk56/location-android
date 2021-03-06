package com.example.tienlv.log_android.screens.dish;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.model.DishOL;

import java.util.ArrayList;

public class DishOLAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater = null;
    private ArrayList<DishOL> arrayList;
    public ImageLoader imageLoader;

    public DishOLAdapter(Activity context, ArrayList<DishOL> arrayList) {
        this.activity = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageLoader = new ImageLoader(this.activity.getApplicationContext());
    }

    public int getCount() {
        return arrayList.size();
    }

    public DishOL getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.adapter_dish_ol_detail_dish, null);

        TextView tvPrice = (TextView) convertView.findViewById(R.id.tv_price_dish_ol_detail_dish);
        TextView tvAddress = (TextView) convertView.findViewById(R.id.tv_address_dish_ol_detail_dish);

        DishOL dishOl = getItem(position);
        tvPrice.setText(dishOl.getPrice()+"$");
        tvAddress.setText(dishOl.getLocation().getAddress());

        return convertView;
    }
}
