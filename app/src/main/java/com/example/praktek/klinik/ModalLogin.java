package com.example.praktek.klinik;

public class ModalLogin {
    public static String _email, _password, _nama, _notlp;

    //Constructor
    public ModalLogin(){}
    public ModalLogin(String _email, String _password, String _nama, String _notlp){
        this._email=_email;
        this._password=_password;
        this._nama=_nama;
        this._notlp=_notlp;
    }

    //Method Setter
    public void set_email(String _email){
        this._email = _email;
    }
    public void set_password(String _password){
        this._password = _password;
    }
    public void set_nama(String _nama){
        this._nama = _nama;
    }
    public void set_notlp(String _notlp){
        this._notlp = _notlp;
    }

    //method getter
    public static String get_email(){
        return _email;
    }
    public static String get_password(){
        return _password;
    }
    public static String get_nama(){
        return _nama;
    }
    public static String get_notlp(){
        return _notlp;
    }
}