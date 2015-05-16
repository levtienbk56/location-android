package com.example.tienlv.log_android.screens.search;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.Utils.ImageLoader;
import com.example.tienlv.log_android.model.Location;

import java.util.ArrayList;

public class LocationAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater = null;
    private ArrayList<Location> arrayList;
    public ImageLoader imageLoader;

    public LocationAdapter(Activity context, ArrayList<Location> arrayList) {
        this.activity = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageLoader = new ImageLoader(this.activity.getApplicationContext());
    }

    public int getCount() {
        return arrayList.size();
    }

    public Location getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.adapter_location_search, null);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_search_location);
        TextView tvAddress = (TextView) convertView.findViewById(R.id.tv_address_search_location);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_search_location);

        Location location = getItem(position);
        tvName.setText(location.getName());
        tvAddress.setText(location.getAddress());

        imageLoader.displayImage(getItem(position).getThumbnail(), imageView, 100);  //100-requireSize

        return convertView;
    }
}
