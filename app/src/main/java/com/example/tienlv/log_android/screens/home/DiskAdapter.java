package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.model.Disk;

import java.util.ArrayList;

public class DiskAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater = null;
    private ArrayList<Disk> arrayList;
    public ImageLoader imageLoader;

    public DiskAdapter(Activity context, ArrayList<Disk> arrayList) {
        this.activity = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageLoader = new ImageLoader(this.activity.getApplicationContext());
    }

    public int getCount() {
        return arrayList.size();
    }

    public Disk getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.adapter_disk_home, null);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_home_disk);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.tv_price_home_disk);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tv_location_home_disk);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_home_disk);

        Disk disk = getItem(position);
        tvName.setText(disk.getName());
        tvPrice.setText(disk.getPrice() + "$");
        tvLocation.setText(disk.getAddress());

        //check image links
        String url;
        if (getItem(position).getImages().isEmpty()) {
            url = "";
            Log.d("DiskAdapter", "disk dont have any image ");
        } else
            url = arrayList.get(position).getImages().get(0);
        imageLoader.DisplayImage(url, imageView);

        return convertView;
    }
}
