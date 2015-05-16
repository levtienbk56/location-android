package com.example.tienlv.log_android.screens.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tienlv.log_android.R;

public class LocationFragment extends Fragment{
    private static LocationAdapter locationAdapter = null;
    private static ListView listView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location_tab, container,false);

        listView = (ListView) rootView.findViewById(R.id.lv_location_tab);
        locationAdapter = new LocationAdapter(getActivity(), SearchPresenter.locations);
        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SearchPresenter.detailLocation(position);
            }
        });
        return rootView;
    }
}
