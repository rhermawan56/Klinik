package com.example.praktek.klinik;

public class ModalRs {
    public static String _id, _namars, _alamat, _telp, _dokter, _poli;

    //constructor
    public ModalRs(){}
    public ModalRs(String _id, String _namars, String _alamat, String _telp, String _dokter, String _poli){
        this._id = _id;
        this._namars = _namars;
        this._alamat = _alamat;
        this._telp = _telp;
        this._dokter = _dokter;
        this._poli = _poli;
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
    public void set_dokter(String _dokter){
        this._dokter = _dokter;
    }
    public void set_poli(String _poli) {
        this._poli = _poli;
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
    public static String get_dokter(){
        return _dokter;
    }
    public static String get_poli(){
        return _poli;
    }
}
