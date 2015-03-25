package com.example.tienlv.log_android.screens.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.model.Disk;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    ArrayList<Disk> arrayList = new ArrayList<Disk>();
    DiskAdapter diskAdapter = null;
    ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = (ListView) findViewById(R.id.home_lv);
        diskAdapter = new DiskAdapter(this, R.layout.adapter_disk_home, arrayList);
        listView.setAdapter(diskAdapter);
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
