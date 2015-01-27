package com.example.tienlv.my_sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tienlv.my_sql.model.EventModel;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button btInsert, btDelete, btShowall, btDeleteAll, btChangeStep, btSearchActivity;
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

        btInsert.setOnClickListener(insertOnClick);
        btDelete.setOnClickListener(deleteOnClick);
        btShowall.setOnClickListener(showallOnClick);
        btDeleteAll.setOnClickListener(deleteAllOnClick);
        btChangeStep.setOnClickListener(changeStepOnClick);
        btSearchActivity.setOnClickListener(searchActivityOnClick);

        dataHelper = MySQLiteOpenHelper.getInstance(MainActivity.this);
    }

    private OnClickListener searchActivityOnClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
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
                LogAPI.step = i;
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
