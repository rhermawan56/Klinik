package com.example.praktek.klinik;

public class ModalDetailAkun {
    public static String _nama, _email, _notlp;

    //constructor
    public ModalDetailAkun(){}
    public ModalDetailAkun(String _nama, String _email, String _notlp){
        this._nama = _nama;
        this._email = _email;
        this._notlp = _notlp;
    }

    //method setter
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public void set_email(String _email) {
        this._email = _email;
    }
    public void set_notlp(String _notlp) {
        this._notlp = _notlp;
    }

    //method getter
    public static String get_nama(){
        return _nama;
    }
    public static String get_email(){
        return _email;
    }
    public static String get_notlp(){
        return _notlp;
    }
}
