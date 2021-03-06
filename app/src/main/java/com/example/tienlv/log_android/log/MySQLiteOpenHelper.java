package com.example.tienlv.log_android.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.tienlv.log_android.log.model.Event;
import com.example.tienlv.log_android.log.model.Log;

import java.util.ArrayList;

/**
 * Created by tienlv on 1/26/15.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "MSPH";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "MyDataBase.db";
    private SQLiteDatabase database;
    private static MySQLiteOpenHelper mInstance;
    private static Context context;

    // SQL query create table tblevent
    private static final String CREATE_TABLE_EVENT =
            "CREATE TABLE " + MySQLiteConstract.TblEvent.TABLE_NAME + " ("
                    + MySQLiteConstract.TblEvent.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + MySQLiteConstract.TblEvent.COLUMN_NAME_EVENTNAME + " TEXT)";

    //  SQL query create table tbllog
    private static final String CREATE_TABLE_LOG =
            "CREATE TABLE " + MySQLiteConstract.TblLog.TABLE_NAME + " ("
                    + MySQLiteConstract.TblLog.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + MySQLiteConstract.TblLog.COLUMN_NAME_EVENTNAME + " TEXT, "
                    + MySQLiteConstract.TblLog.COLUMN_NAME_DATE + " TEXT, "
                    + MySQLiteConstract.TblLog.COLUMN_NAME_VALUE + " TEXT)";

    /**
     * Constructor
     */
    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        database = this.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_LOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS " + MySQLiteConstract.TblLog.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MySQLiteConstract.TblEvent.TABLE_NAME);
        onCreate(db);
    }

    public static MySQLiteOpenHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new MySQLiteOpenHelper(ctx.getApplicationContext());
        }else {
            context = ctx;
        }
        return mInstance;
    }

    //==================================Event query ===========================================//

    /**
     * insert 1 row into table event
     *
     * @param event object
     */
    public void insertEvent(Event event) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MySQLiteConstract.TblEvent.COLUMN_NAME_EVENTNAME, event.getName());

        long i = database.insert(MySQLiteConstract.TblEvent.TABLE_NAME, null, values);
        android.util.Log.d(TAG, "id inserted: " + i);
    }

    /**
     * get 1 event by id
     *
     * @param id id of event
     * @return event object
     */
    public Event getEventByID(int id) {
        database = this.getReadableDatabase();

        // SQL query
        String selectQuery = "SELECT * FROM "
                + MySQLiteConstract.TblEvent.TABLE_NAME
                + " WHERE "
                + MySQLiteConstract.TblEvent.COLUMN_NAME_ID
                + " = " + id;
        android.util.Log.d(TAG, "getEventByID: " + selectQuery);

        // querying
        Cursor c = database.rawQuery(selectQuery, null);

        if (c != null) {
            c.moveToFirst();
        } else return null;

        // match with event object
        Event event = new Event();
        event.set_id(c.getInt(c.getColumnIndex(MySQLiteConstract.TblEvent.COLUMN_NAME_ID)));
        event.setName(c.getString(c.getColumnIndex(MySQLiteConstract.TblEvent.COLUMN_NAME_EVENTNAME)));

        return event;
    }

    public ArrayList<Event> getEventAll() {
        database = this.getReadableDatabase();
        ArrayList<Event> arrayList = new ArrayList<Event>();

        //SQL query
        String query = "SELECT * FROM " + MySQLiteConstract.TblEvent.TABLE_NAME;
        android.util.Log.d(TAG, "getEventAll:" + query);

        Cursor c = database.rawQuery(query, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            Event event;
            do {
                event = new Event();
                event.set_id(c.getInt(c.getColumnIndex(MySQLiteConstract.TblEvent.COLUMN_NAME_ID)));
                event.setName(c.getString(c.getColumnIndex(MySQLiteConstract.TblEvent.COLUMN_NAME_EVENTNAME)));

                arrayList.add(event);
            } while (c.moveToNext());
            c.close();
        }

        return arrayList;
    }

    public void deleteEvent(String _id) {
        database = this.getWritableDatabase();
        if (_id.isEmpty()) {
            android.util.Log.d(TAG, "deleteEvent: fails");
        }
        int i = database.delete(MySQLiteConstract.TblEvent.TABLE_NAME, MySQLiteConstract.TblEvent.COLUMN_NAME_ID + " = " + _id, null);
        android.util.Log.d(TAG, "deleteEvent id = " + _id + " : " + i);
    }

    public void deleteAllEvent() {
        database = this.getWritableDatabase();
        database.delete(MySQLiteConstract.TblEvent.TABLE_NAME, null, null);
    }

    //============================= Log query ===================================================//

    /**
     * insert 1 row into table log
     *
     * @param log object
     */
    public void insertLog(Log log) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MySQLiteConstract.TblLog.COLUMN_NAME_EVENTNAME, log.getEventName());
        values.put(MySQLiteConstract.TblLog.COLUMN_NAME_DATE, log.getDate());
        values.put(MySQLiteConstract.TblLog.COLUMN_NAME_VALUE, log.getValue());

        long i = database.insert(MySQLiteConstract.TblLog.TABLE_NAME, null, values);
        android.util.Log.d(TAG, "insertLog : id inserted =" + i);
        Toast.makeText(context, "insert log: " +log.getEventName(), Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Log> getAllLog() {
        database = this.getReadableDatabase();
        ArrayList<Log> arrayList = new ArrayList<>();

        //SQL query
        String query = "SELECT * FROM " + MySQLiteConstract.TblLog.TABLE_NAME;
        android.util.Log.d(TAG, "getEventAll:" + query);

        Cursor c = database.rawQuery(query, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            Log log;
            do {
                log = new Log();
                log.set_id(c.getInt(c.getColumnIndex(MySQLiteConstract.TblLog.COLUMN_NAME_ID)));
                log.setEventName(c.getString(c.getColumnIndex(MySQLiteConstract.TblLog.COLUMN_NAME_EVENTNAME)));
                log.setDate(c.getString(c.getColumnIndex(MySQLiteConstract.TblLog.COLUMN_NAME_DATE)));
                log.setValue(c.getString(c.getColumnIndex(MySQLiteConstract.TblLog.COLUMN_NAME_VALUE)));

                arrayList.add(log);
            } while (c.moveToNext());
            c.close();
        }
        android.util.Log.d(TAG, "size " + arrayList.size());
        return arrayList;
    }

    public void deleteLog(String _id) {
        database = this.getWritableDatabase();
        if (_id.isEmpty()) {
            android.util.Log.d(TAG, "deleteLog: fails");
        }
        int i = database.delete(MySQLiteConstract.TblLog.TABLE_NAME, MySQLiteConstract.TblLog.COLUMN_NAME_ID + " = " + _id, null);
        android.util.Log.d(TAG, "deleteLog id = " + _id + " : " + i);
    }

    public void deleteAllLog() {
        database = this.getWritableDatabase();
        database.delete(MySQLiteConstract.TblLog.TABLE_NAME, null, null);
    }
}
