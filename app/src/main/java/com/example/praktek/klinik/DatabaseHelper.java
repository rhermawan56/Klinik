package com.example.praktek.klinik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String db_name = "account";
    private static int db_version = 1;

    public DatabaseHelper(Context context) {
        super(context,  db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(id int primary key, nama text, email text unique, password text, notlp text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateAccount(ModalLogin exe){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", exe.get_Id());
            contentValues.put("nama", exe.get_Nama());
            contentValues.put("email", exe.get_Email());
            contentValues.put("password", exe.get_Password());
            contentValues.put("notlp", exe.get_Password());
            db.insert("login",null,contentValues);
            db.close();
        }catch (Exception e){

        }
    }

    public Boolean cekemail(String email){
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from login where email = ?",new String[]{email});
            if (cursor.getCount()>0){
                return false;
            }else {
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }

    public Boolean login(String email, String password){
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from login where email =?  and password = ?", new String[]{email, password});
            if (cursor.moveToNext()){
                ModalLogin exe = new ModalLogin();
                exe.set_Id(cursor.getString(0));
                exe.set_Nama(cursor.getString(1));
                exe.set_Email(cursor.getString(2));
                exe.set_Password(cursor.getString(3));
                exe.set_Notlp(cursor.getString(4));
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
