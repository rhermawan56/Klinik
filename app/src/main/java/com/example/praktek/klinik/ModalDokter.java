package com.example.praktek.klinik;

public class ModalDokter {

    public static int _id;
    public static String _namadokter, _namars, _polikolinik;

    //method setter
    public void set_id(int _id) {
        this._id = _id;
    }
    public void set_namadokter(String _namadokter) {
        this._namadokter = _namadokter;
    }
    public void set_namars(String _namars) {
        this._namars = _namars;
    }
    public void set_polikolinik(String _polikolinik) {
        this._polikolinik = _polikolinik;
    }

    //metod getter
    public static Integer get_id(){
        return _id;
    }
    public static String get_namadokter(){
        return _namadokter;
    }
    public static String get_namars() {
        return _namars;
    }
    public static String get_polikolinik(){
        return _polikolinik;
    }
}
