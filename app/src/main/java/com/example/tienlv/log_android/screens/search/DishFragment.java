package com.example.tienlv.log_android.screens.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tienlv.log_android.R;


public class DishFragment extends Fragment{
    private static DishAdapter dishAdapter;
    private static ListView listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dish_tab, container,false);



        listView = (ListView) rootView.findViewById(R.id.lv_dish_tab);
        dishAdapter = new DishAdapter(getActivity(), SearchPresenter.dishes);
        listView.setAdapter(dishAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        //set action on click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SearchPresenter.detailDish(position);
            }
        });
        return rootView;
    }

    public static void reloadListView() {
        dishAdapter.notifyDataSetChanged();
        Log.d("DishFragment", "dish count: "+SearchPresenter.dishes.size());
        listView.setAdapter(dishAdapter);
    }

}
