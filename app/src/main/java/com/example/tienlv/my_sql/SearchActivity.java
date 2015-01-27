package com.example.tienlv.my_sql;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tienlv.my_sql.model.EventModel;
import com.example.tienlv.my_sql.model.LogModel;

import java.util.ArrayList;


public class SearchActivity extends Activity {
    Button btSearch, btSearchNear, btShowLog;
    EditText et_search;
    TextView tvLog;
    LogAPI logAPI = new LogAPI(SearchActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btSearch = (Button) findViewById(R.id.bt_search);
        btSearchNear = (Button) findViewById(R.id.bt_search_near);
        et_search = (EditText) findViewById(R.id.et_search);
        btShowLog = (Button) findViewById(R.id.bt_showall_log);
        tvLog = (TextView) findViewById(R.id.tv_log);

        btSearch.setOnClickListener(searchOnClick);
        btSearchNear.setOnClickListener(searchNearOnClick);
        btShowLog.setOnClickListener(showLogOnClick);

    }

    private View.OnClickListener showLogOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            tvLog.setText("");
            ArrayList<LogModel> arrayList = logAPI.getAllLog();
            int i;
            for (i = 0; i < arrayList.size(); i++) {
                tvLog.append("-" + arrayList.get(i).get_id() + " "
                        + arrayList.get(i).getEventName() + " "
                        +arrayList.get(i).getDate() + " "
                        + arrayList.get(i).getValue()+"\n");
            }
        }
    };

    private View.OnClickListener searchOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = et_search.getText().toString();
            et_search.setText("");

            logAPI.insertLog(LogAPI.EVENT_SEARCH_KEY, s);
        }
    };

    private View.OnClickListener searchNearOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            logAPI.insertLog(LogAPI.EVENT_SEARCH_NEAR_BY, "");
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
