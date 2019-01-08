package com.example.praktek.klinik;

public class ModalRs {
    public static String _id, _namars, _alamat, _telp;

    //constructor
    public ModalRs(){}
    public ModalRs(String _id, String _namars, String _alamat, String _telp){
        this._id = _id;
        this._namars = _namars;
        this._alamat = _alamat;
        this._telp = _telp;
    }

    //method setter
    public void set_id(String _id) {
        this._id = _id;
    }
    public void set_namars(String _namars) {
        this._namars = _namars;
    }
    public void set_alamat(String _alamat) {
        this._alamat = _alamat;
    }
    public void set_telp(String _telp) {
        this._telp = _telp;
    }

    //method getter
    public static String get_id(){
        return _id;
    }
    public static String get_namars(){
        return _namars;
    }
    public static String get_alamat(){
        return _alamat;
    }
    public static String get_telp(){
        return _telp;
    }
}
