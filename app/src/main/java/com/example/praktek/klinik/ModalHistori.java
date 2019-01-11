package com.example.praktek.klinik;

public class ModalHistori {
    private static Integer _id, _idpoli, _noantrian;
    private static String _nama, _email, _dokter, _poliklinik, _rs;

    public ModalHistori(){}
    public ModalHistori(Integer _id, Integer _idpoli, Integer _noantrian, String _nama, String _email,
                        String _dokter, String _poliklinik, String _rs){
        this._id = _id;
        this._idpoli = _idpoli;
        this._noantrian = _noantrian;
        this._nama = _nama;
        this._email = _email;
        this._dokter = _dokter;
        this._poliklinik = _poliklinik;
        this._rs = _rs;
    }

    //setter

    public void set_id(Integer _id) {
        this._id = _id;
    }
    public void set_idpoli(Integer _idpoli) {
        this._idpoli = _idpoli;
    }
    public void set_noantrian(Integer _noantrian) {
        this._noantrian = _noantrian;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_dokter(String _dokter) {
        this._dokter = _dokter;
    }

    public void set_poliklinik(String _poliklinik) {
        this._poliklinik = _poliklinik;
    }

    public void set_rs(String _rs) {
        this._rs = _rs;
    }

    //getter
    public static Integer get_id() {
        return _id;
    }

    public static Integer get_idpoli() {
        return _idpoli;
    }

    public static Integer get_noantrian() {
        return _noantrian;
    }

    public static String get_nama() {
        return _nama;
    }

    public static String get_email() {
        return _email;
    }

    public static String get_dokter() {
        return _dokter;
    }

    public static String get_poliklinik() {
        return _poliklinik;
    }

    public static String get_rs() {
        return _rs;
    }
}