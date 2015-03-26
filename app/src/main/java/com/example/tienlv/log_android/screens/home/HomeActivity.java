package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.model.Disk;
import com.example.tienlv.log_android.screens.disk.DiskActivity;
import com.example.tienlv.log_android.screens.search.SearchActivity;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    private ArrayList<Disk> arrayList = new ArrayList<Disk>();
    private DiskAdapter diskAdapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //test a disk
        Disk adisk = new Disk();
        adisk.setName("thịt chó hấp");
        adisk.setAddress("số 1 Đại Cồ Việt ");
        adisk.setPrice(200000);
        ArrayList<String> images = new ArrayList<String>();
        images.add("http://icons.iconarchive.com/icons/yellowicon/game-stars/256/Mario-icon.png");
        images.add("https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png");
        adisk.setImages(images);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);
        arrayList.add(adisk);

        //show list
        listView = (ListView) findViewById(R.id.home_lv);
        diskAdapter = new DiskAdapter(this, arrayList);
        listView.setAdapter(diskAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                detailDisk(position);
            }
        });

    }

    //action for search Button :)
    public void search(View v) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void detailDisk(int position){
        Intent intent = new Intent(getBaseContext(), DiskActivity.class);
        intent.putExtra("EXTRA_SESSION_ID", arrayList.get(position).getId());
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
}
