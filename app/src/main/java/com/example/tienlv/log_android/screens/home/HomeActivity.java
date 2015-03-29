package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.http.HttpTask;
import com.example.tienlv.log_android.screens.dish.DishActivity;
import com.example.tienlv.log_android.screens.search.SearchActivity;

public class HomeActivity extends Activity implements IHomeActivity{

    private static DishAdapter dishAdapter = null;
    private static ListView listView = null;
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homePresenter = new HomePresenter(this);

//        // test a disk
//         Dish adisk = new Dish();
//         adisk.setName("thịt chó hấp");
//         adisk.setAddress("số 1 Đại Cồ Việt ");
//         adisk.setPrice(200000);
//         ArrayList<String> images = new ArrayList<String>();
//         images.add("http://icons.iconarchive.com/icons/yellowicon/game-stars/256/Mario-icon.png");
//         images.add("https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png");
//         adisk.setImages(images);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);
//         arrayList.add(adisk);

        //get trend disks from server
        requestDisks();

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

    public void requestDisks() {
        HttpTask task = new AnalyzeDishData();
        task.execute("http://54.169.170.248:8080/Foodie/webresources/food/newest");

    }

    public void reloadListView() {
        dishAdapter.notifyDataSetChanged();
        listView.setAdapter(dishAdapter);
    }
}
