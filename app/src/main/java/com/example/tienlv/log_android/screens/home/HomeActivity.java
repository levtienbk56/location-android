package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.http.HttpTask;
import com.example.tienlv.log_android.log.LogAPI;
import com.example.tienlv.log_android.screens.dish.DishActivity;
import com.example.tienlv.log_android.screens.search.SearchActivity;

public class HomeActivity extends Activity implements IHomeActivity{

    private static DishAdapter dishAdapter = null;
    private static ListView listView = null;
    private HomePresenter homePresenter;
    LogAPI logAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //========most important initialize ============//
        homePresenter = new HomePresenter(this);
        logAPI = new LogAPI(this);
        //==============================================//

        //get trend dishs from server
        requestDishs();

        //show list
        listView = (ListView) findViewById(R.id.home_lv);
        dishAdapter = new DishAdapter(this, homePresenter.getDishList());
        listView.setAdapter(dishAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                detailDisk(position);
            }
        });

    }

    //action for search Button :)
    public void search(View v) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void detailDisk(int position) {
        Intent intent = new Intent(getBaseContext(), DishActivity.class);
        intent.putExtra("EXTRA_DISH_NO", position);
        startActivity(intent);
        Log.d("HomeActivity", "u click " + position);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void requestDishs() {
        HttpTask task = new AnalyzeDishData();
        task.execute("http://54.169.170.248:8080/Foodie/webresources/food/newest");

    }

    public void reloadListView() {
        dishAdapter.notifyDataSetChanged();
        listView.setAdapter(dishAdapter);
    }
}
