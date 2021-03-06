package com.example.genjeh.mycataloguemovieuiux.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_favorite";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_FAVORITE = DbContract.CREATE_TABLE_FAVORITE;
    private static final String FAVORITE_TABLE_NAME = DbContract.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+FAVORITE_TABLE_NAME);
        onCreate(db);
    }
}
