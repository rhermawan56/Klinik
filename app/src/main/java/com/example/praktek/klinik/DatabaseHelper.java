package com.example.praktek.klinik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteAssetHelper {

    private static String db_name = "klinik.db";
    private static int db_version = 1;

    public DatabaseHelper(Context context) {
        super(context,  db_name, null, db_version);
    }
}
