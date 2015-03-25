package com.example.tienlv.log_android;

import android.provider.BaseColumns;

/**
 * Created by tienlv on 1/26/15.
 */
public final class MySQLiteConstract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public MySQLiteConstract() {}

    /* Inner class that defines the table contents */
    public static abstract class TblLog implements BaseColumns {
        public static final String TABLE_NAME = "tbllog";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_EVENTNAME = "eventname";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_VALUE = "value";
    }

    public static abstract class TblEvent implements BaseColumns {
        public static final String TABLE_NAME = "tblevent";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_EVENTNAME = "eventname";
    }

    public static abstract class TblApp implements BaseColumns {
        public static final String TABLE_NAME = "tblapp";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_APPNAME = "appname";
        public static final String COLUMN_NAME_CATEGORY = "category";
    }

    public static abstract class TblDevice implements BaseColumns {
        public static final String TABLE_NAME = "tbldevice";
        public static final String COLUMN_NAME_ID = "_id";  //=imei
        public static final String COLUMN_NAME_DEVICENAME = "devicename";
        public static final String COLUMN_NAME_MANUFACTORY = "devicename";
        public static final String COLUMN_NAME_OS = "devicename";
    }

    public static abstract class TblAppInDevice implements BaseColumns {
        public static final String TABLE_NAME = "tblappindevice";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_APPID = "appid";
        public static final String COLUMN_NAME_DEVICE = "deviceid";
    }
}