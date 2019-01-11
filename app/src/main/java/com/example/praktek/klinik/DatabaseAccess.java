package com.example.praktek.klinik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

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

    public Boolean getDataRS(String id){
        try {
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from rumahsakit where idrs = ?", new String[]{id});
            if (cursor.moveToNext()){
                ModalRs modalRs = new ModalRs();
                modalRs.set_id(cursor.getString(0));
                modalRs.set_namars(cursor.getString(1));
                modalRs.set_alamat(cursor.getString(2));
                modalRs.set_telp(cursor.getString(3));
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public Boolean getDataDokter(Integer id){
        try {
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from dokter where iddok = ?",
                    new String[]{String.valueOf(id)});
            if (cursor.moveToFirst()){
                do {
                    ModalDokter modalDokter = new ModalDokter();
                    modalDokter.set_id(cursor.getInt(0));
                    modalDokter.set_namadokter(cursor.getString(1));
                    modalDokter.set_namars(cursor.getString(2));
                    modalDokter.set_polikolinik(cursor.getString(3));
                    modalDokter.set_jadwalpraktek(cursor.getString(4));
                    modalDokter.set_jampraktek(cursor.getString(5));
                } while (cursor.moveToNext());
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public void createHistory(ModalHistori histori){
        try {
            db = openHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", ModalHistori.get_id());
            values.put("idpoli", ModalHistori.get_idpoli());
            values.put("noantrian", ModalHistori.get_noantrian());
            values.put("nama", ModalHistori.get_nama());
            values.put("email", ModalHistori.get_email());
            values.put("dokter", ModalHistori.get_dokter());
            values.put("poliklinik", ModalHistori.get_poliklinik());
            values.put("rs", ModalHistori.get_rs());
            db.insert("History", null, values);
        }catch (Exception e){}
    }

    public void readHistory(Integer idpoli){
        try {
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from History where idpoli = ?",
                    new String[]{String.valueOf(idpoli)});
            if (cursor.moveToFirst()){
                do {
                    ModalHistori histori = new ModalHistori();
                    histori.set_id(cursor.getInt(0));
                    histori.set_idpoli(cursor.getInt(1));
                    histori.set_noantrian(cursor.getInt(2));
                    histori.set_nama(cursor.getString(3));
                    histori.set_email(cursor.getString(4));
                    histori.set_dokter(cursor.getString(5));
                    histori.set_poliklinik(cursor.getString(6));
                    histori.set_rs(cursor.getString(7));
                } while (cursor.moveToNext());
            } else {}
        } catch (Exception e){}
    }

    public Boolean cekHistory(String email){
        try {
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from History where email = ?",
                    new String[]{email});
            if (cursor.getCount()>0){
                return false;
            } else {
                return true;
            }
        }catch (Exception e){return false;}
    }

    public Boolean readAccountHistory(String email){
        try {
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from History where email = ?",
                    new String[]{email});
            if (cursor.moveToFirst()){
                do {
                    ModalHistori histori = new ModalHistori();
                    histori.set_id(cursor.getInt(0));
                    histori.set_idpoli(cursor.getInt(1));
                    histori.set_noantrian(cursor.getInt(2));
                    histori.set_nama(cursor.getString(3));
                    histori.set_email(cursor.getString(4));
                    histori.set_dokter(cursor.getString(5));
                    histori.set_poliklinik(cursor.getString(6));
                    histori.set_rs(cursor.getString(7));
                } while (cursor.moveToNext());
                return true;
            } else {
                return false;
            }
        } catch (Exception e){return false;}
    }
}