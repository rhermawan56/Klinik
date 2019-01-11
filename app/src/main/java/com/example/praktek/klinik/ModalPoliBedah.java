package com.example.praktek.klinik;

import android.content.Intent;

public class ModalPoliBedah {

    public static Integer _id;
    public static String _idbooking, _namars, _namadok, _polidok, _akun;

    //constructor
    public ModalPoliBedah(){}
    public ModalPoliBedah(Integer _id, String _idbooking, String _namars, String _namadok, String _polidok, String _akun){
        this._id = _id;
        this._idbooking = _idbooking;
        this._namars = _namars;
        this._namadok = _namadok;
        this._polidok = _polidok;
        this._akun = _akun;
    }

    //method setter
    public void set_id(Integer _id) {
        this._id = _id;
    }
    public void set_idbooking(String _idbooking) {
        this._idbooking = _idbooking;
    }
    public void set_namars(String _namars) {
        this._namars = _namars;
    }
    public void set_namadok(String _namadok) {
        this._namadok = _namadok;
    }
    public void set_polidok(String _polidok){
        this._polidok = _polidok;
    }
    public void set_akun(String _akun) {
        this._akun = _akun;
    }

    //method getter
    public static Integer get_id(){
        return _id;
    }
    public static String get_idbooking(){
        return _idbooking;
    }
    public static String get_namars(){
        return _namars;
    }
    public static String get_namadok(){
        return _namadok;
    }
    public static String get_polidok(){
        return _polidok;
    }
    public static String get_akun (){return _akun;}
}
