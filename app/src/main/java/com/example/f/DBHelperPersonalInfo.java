package com.example.f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.provider.BaseColumns._ID;
import static com.example.f.DbConstants.EMAIL;
import static com.example.f.DbConstants.NAME;
import static com.example.f.DbConstants.TABLE_NAME1;
import static com.example.f.DbConstants.PASSWORD;

/**
 * Created by 靖升 on 2015/12/8.
 */

public class DBHelperPersonalInfo extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "de.db";
    private final static int DATABASE_VERSION = 1;

    public DBHelperPersonalInfo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v("DBHelperPerson","constructure creat");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String INIT_TABLE = "CREATE TABLE " + TABLE_NAME1 + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " CHAR, " +
                EMAIL + " CHAR, " +
                PASSWORD + " CHAR);";
        db.execSQL(INIT_TABLE);
        Log.v("DBHelperPerson", "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME1;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

}
