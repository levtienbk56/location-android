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
import com.example.tienlv.log_android.log.model.Event;
import com.example.tienlv.log_android.log.model.Log;
import com.example.tienlv.log_android.screens.SearchActivityTest;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button btInsert, btDelete, btShowall, btDeleteAll, btChangeStep;
    EditText etName, etID, etStep;
    TextView tvResult;
    private MySQLiteOpenHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initStartupReceiver();
        dataHelper = MySQLiteOpenHelper.getInstance(MainActivity.this);


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

        btInsert.setOnClickListener(insertOnClick);
        btDelete.setOnClickListener(deleteOnClick);
        btShowall.setOnClickListener(showallOnClick);
        btDeleteAll.setOnClickListener(deleteAllOnClick);
        btChangeStep.setOnClickListener(changeStepOnClick);


    }
    private OnClickListener insertOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String string = etName.getText().toString();
            if (string.isEmpty()) return;
            Event event = new Event();
            event.setName(string);

            dataHelper.insertEvent(event);
        }
    };
    private OnClickListener deleteOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String id = etID.getText().toString();

            dataHelper.deleteLog(id);
        }
    };

    private OnClickListener showallOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            tvResult.setText("");

            ArrayList<Log> arrayList = dataHelper.getAllLog();
            int i;
            for (i = 0; i < arrayList.size(); i++) {
                Log log = arrayList.get(i);
                tvResult.append("-" + log.get_id() + " " + log.getEventName() + " " + log.getDate()  + " " + log.getValue() + "\n");
            }
        }
    };

    private OnClickListener deleteAllOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            dataHelper.deleteAllLog();
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
