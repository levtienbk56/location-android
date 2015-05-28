package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.log.MainActivity;
import com.melnykov.fab.FloatingActionButton;

public class HomeActivity extends Activity implements IHomeActivity {

    private static DishAdapter dishAdapter;
    private static ListView listView;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter = new HomePresenter(this);

        //show list
        listView = (ListView) findViewById(R.id.lv_dish_home);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_home);
        fab.attachToListView(listView);

    }

    public void reloadListView() {
        dishAdapter = new DishAdapter(this, HomePresenter.dishes);
        listView.setAdapter(dishAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomePresenter.detailDish(position);
            }
        });
    }

    public void openSearch(View v){
        presenter.openSearch();
    }

    public void checkLog(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
