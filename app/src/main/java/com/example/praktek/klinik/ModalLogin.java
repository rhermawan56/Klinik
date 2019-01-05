package com.example.praktek.klinik;

public class ModalLogin {
    private static String _id;
    private static String _nama, _email, _password, _notlp;

    public ModalLogin(){}

    public ModalLogin(String _id, String _nama ,String _email, String _password, String _notlp){
        this._id = _id;
        this._nama = _nama;
        this._email = _email;
        this._password = _password;
        this._notlp = _notlp;
    }

    public void set_Id(String _id) {
        this._id = _id;
    }

    public void set_Nama(String _nama) {
        this._nama = _nama;
    }

    public void set_Email(String _email) {
        this._email = _email;
    }

    public void set_Password(String _password){
        this._password = _password;
    }

    public void set_Notlp(String _notlp){
        this._notlp = _notlp;
    }

    public static String get_Id(){
        return _id;
    }

    public static String get_Nama(){
        return _nama;
    }

    public static String get_Email(){
        return _email;
    }

    public static String get_Password(){
        return _password;
    }

    public static String get_Notlp(){
        return _notlp;
    }
}
