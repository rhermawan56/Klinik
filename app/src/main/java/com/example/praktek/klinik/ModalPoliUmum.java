package com.example.praktek.klinik;

public class ModalPoliUmum {
    public static Integer _id, _idbooking;
    public static String _namars, _namadok, _polidok, _namaakun;

    //constructor
    public ModalPoliUmum(){}
    public ModalPoliUmum(Integer _id, Integer _idbooking, String _namars, String _namadok, String _polidok, String _namaakun){
        this._id = _id;
        this._idbooking = _idbooking;
        this._namars = _namars;
        this._namadok = _namadok;
        this._polidok = _polidok;
        this._namaakun = _namaakun;
    }

    //method setter
    public void set_id(Integer _id) {
        this._id = _id;
    }
    public void set_idbooking(Integer _idbooking) {
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
    public void set_namaakun(String _namaakun){
        this._namaakun = _namaakun;
    }

    //method getter
    public static String get_id(){
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
    public static String get_namaakun(){
        return _namaakun;
    }
}
