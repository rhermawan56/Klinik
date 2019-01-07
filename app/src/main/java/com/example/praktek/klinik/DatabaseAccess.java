package com.example.praktek.klinik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess databaseAccess;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(databaseAccess==null){
            databaseAccess = new DatabaseAccess(context);
        }
        return databaseAccess;
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public Boolean login(String email, String password){
        try {
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from user where email = ? and password = ?",
                    new String[]{email, password});
            if (cursor.moveToNext()){
                ModalLogin modal = new ModalLogin();
                modal.set_email(cursor.getString(0));
                modal.set_password(cursor.getString(1));
                modal.set_nama(cursor.getString(2));
                modal.set_notlp(cursor.getString(3));
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    public Boolean cekEmail(String email){
        try {
            SQLiteDatabase db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from user where email = ?",
                    new String[]{email});
            if (cursor.getCount()>0){
                return false;
            } else {
                return true;
            }
        } catch (Exception e){
            return true;
        }
    }
    public void CreateAccoount(ModalLogin modal){
        try {
            SQLiteDatabase db = openHelper.getWritableDatabase();
            ContentValues content = new ContentValues();
            content.put("email", modal.get_email());
            content.put("password", modal.get_password());
            content.put("nama", modal.get_nama());
            content.put("notlp", modal.get_notlp());
            db.insert("user", null, content);
        }catch (Exception e){ }
    }
}
