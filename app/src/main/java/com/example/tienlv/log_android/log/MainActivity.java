package com.example.tienlv.log_android.log;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tienlv.log_android.R;
import com.example.tienlv.log_android.http.HttpGetTask;
import com.example.tienlv.log_android.http.HttpTask;
import com.example.tienlv.log_android.log.model.EventModel;
import com.example.tienlv.log_android.screens.SearchActivityTest;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button btInsert, btDelete, btShowall, btDeleteAll, btChangeStep, btSearchActivity, btHttp;
    EditText etName, etID, etStep;
    TextView tvResult;
    private MySQLiteOpenHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStartupReceiver();

        etName = (EditText) findViewById(R.id.et_name);
        etID = (EditText) findViewById(R.id.et_id);
        etStep = (EditText) findViewById(R.id.et_step);

        tvResult = (TextView) findViewById(R.id.tv_result);
        tvResult.setMovementMethod(new ScrollingMovementMethod());

        btInsert = (Button) findViewById(R.id.bt_insert);
        btDelete = (Button) findViewById(R.id.bt_delete);
        btShowall = (Button) findViewById(R.id.bt_showall);
        btDeleteAll = (Button) findViewById(R.id.bt_delete_all);
        btChangeStep = (Button) findViewById(R.id.bt_change_step);
        btSearchActivity = (Button) findViewById(R.id.bt_search_activity);
        btHttp = (Button) findViewById(R.id.bt_http);

        btInsert.setOnClickListener(insertOnClick);
        btDelete.setOnClickListener(deleteOnClick);
        btShowall.setOnClickListener(showallOnClick);
        btDeleteAll.setOnClickListener(deleteAllOnClick);
        btChangeStep.setOnClickListener(changeStepOnClick);
        btSearchActivity.setOnClickListener(searchActivityOnClick);
        btHttp.setOnClickListener(httpOnClick);

        dataHelper = MySQLiteOpenHelper.getInstance(MainActivity.this);

    }

    private OnClickListener httpOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            //----------------test http request --------------------------
            HttpTask task = new HttpGetTask();
            task.execute("http://www.google.com/search?q=mkyong");


        }
    };

    private OnClickListener searchActivityOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SearchActivityTest.class);
            startActivity(intent);
        }
    };

    private OnClickListener insertOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String string = etName.getText().toString();
            if (string.isEmpty()) return;
            EventModel event = new EventModel();
            event.setName(string);

            dataHelper.insertEvent(event);
        }
    };
    private OnClickListener deleteOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String id = etID.getText().toString();

            dataHelper.deleteEvent(id);
        }
    };

    private OnClickListener showallOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            tvResult.setText("");

            ArrayList<EventModel> arrayList = dataHelper.getEventAll();
            int i;
            for (i = 0; i < arrayList.size(); i++) {
                tvResult.append("-" + arrayList.get(i).get_id() + " " + arrayList.get(i).getName() + "\n");
            }
        }
    };

    private OnClickListener deleteAllOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            dataHelper.deleteAllEvent();
        }
    };

    private OnClickListener changeStepOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                int i = Integer.parseInt(etStep.getText().toString());
                LogAPI.upStep = i;
                initStartupReceiver();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    private void initStartupReceiver() {

        // Start receiver with the name StartupReceiver_Manual_Start
        // Check AndroidManifest.xml file
        getBaseContext().getApplicationContext().sendBroadcast(
                new Intent("StartupReceiver_Manual_Start"));
    }

}
