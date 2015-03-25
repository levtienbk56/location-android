package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.model.Disk;

import java.util.ArrayList;

public class DiskAdapter extends ArrayAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<Disk> arrayList;
    private int itemLayout;

    public DiskAdapter(Activity context, int resource, ArrayList<Disk> arrayList) {
        super(context, resource, arrayList);
        this.activity = context;
        this.arrayList = arrayList;
        this.itemLayout = resource;
    }

    public int getCount() {
        return arrayList.size();
    }

    public Disk getItem(int position) {
        return arrayList.get(position);
    }

    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(itemLayout, null);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_home_disk);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.tv_price_home_disk);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tv_location_home_disk);

        Disk disk = getItem(position);
        tvName.setText(disk.getName());
        tvPrice.setText(disk.getPrice());

        return convertView;
    }
}
