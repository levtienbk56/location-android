package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tienlv.log_android.R;
import com.melnykov.fab.FloatingActionButton;

public class HomeActivity extends Activity implements IHomeActivity {

    private static DishAdapter dishAdapter = null;
    private static ListView listView = null;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter = new HomePresenter(this);
        //==============================================//
        //get trend dishs from server
        //presenter.requestDishs();

        //show list
        listView = (ListView) findViewById(R.id.lv_search_home);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_home);
        fab.attachToListView(listView);
        dishAdapter = new DishAdapter(this, presenter.getDishList());
        listView.setAdapter(dishAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //detailDisk(position);
            }
        });
        reloadListView();
    }



    public void reloadListView() {
        dishAdapter.notifyDataSetChanged();
        listView.setAdapter(dishAdapter);
    }

    private void initStartupReceiver() {

        // Start receiver with the name StartupReceiver_Manual_Start
        // Check AndroidManifest.xml file
        getBaseContext().getApplicationContext().sendBroadcast(
                new Intent("StartupReceiver_Manual_Start"));
    }
}
