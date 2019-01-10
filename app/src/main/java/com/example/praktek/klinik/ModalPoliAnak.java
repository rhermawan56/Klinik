package com.example.praktek.klinik;

public class ModalPoliAnak {
    public static String _id, _idbooking, _namars, _namadok, _polidok;

    //constructor
    public ModalPoliAnak(){}
    public ModalPoliAnak(String _id, String _idbooking, String _namars, String _namadok, String _polidok){
        this._id = _id;
        this._idbooking = _idbooking;
        this._namars = _namars;
        this._namadok = _namadok;
        this._polidok = _polidok;
    }

    //method setter
    public void set_id(String _id) {
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
}
