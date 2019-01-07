package com.example.praktek.klinik;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    EditText nama, email, pass, conpass, tlp;
    private String Snama, Semail, Spass, Sconpass, Stlp;
    CardView create, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        nama = (EditText) findViewById(R.id.create_nama);
        email = (EditText) findViewById(R.id.create_email);
        pass = (EditText) findViewById(R.id.create_pass);
        conpass = (EditText) findViewById(R.id.create_conpass);
        tlp = (EditText) findViewById(R.id.create_tlp);
        create = (CardView) findViewById(R.id.create_cardcreate);
        cancel = (CardView) findViewById(R.id.create_cardcancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama.setText("");
                email.setText("");
                email.setText("");
                pass.setText("");
                conpass.setText("");
                tlp.setText("");
                nama.requestFocus();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snama = nama.getText().toString();
                Semail = email.getText().toString();
                Spass = pass.getText().toString();
                Sconpass = conpass.getText().toString();
                Stlp = tlp.getText().toString();
                if (Snama.equals("")){
                    Toast.makeText(Create.this, "nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    nama.requestFocus();
                } else if (Semail.equals("")){
                    Toast.makeText(Create.this, "email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                } else if (Spass.equals("")){
                    Toast.makeText(Create.this, "sandi tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                } else if (Sconpass.equals("")){
                    Toast.makeText(Create.this, "konfirmasi sandi tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    conpass.requestFocus();
                } else if (Stlp.equals("")){
                    Toast.makeText(Create.this, "telepon tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    tlp.requestFocus();
                } else if (!(Spass.equals(Sconpass))){
                    Toast.makeText(Create.this, "sandi dan konfirmasi sandi\nharus sama", Toast.LENGTH_SHORT).show();
                    conpass.setText("");
                    conpass.requestFocus();
                } else {
                    DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                    boolean cekEmail = db.cekEmail(Semail);
                    if (cekEmail == true){
                        db.CreateAccoount(new ModalLogin(Semail, Spass, Snama, Stlp));
                        Toast.makeText(Create.this, "akun berhasil didaftarkan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Create.this, Menu.class);
                        startActivity(intent);
                        nama.setText("");
                        email.setText("");
                        pass.setText("");
                        conpass.setText("");
                        tlp.setText("");
                        nama.requestFocus();
                    } else {
                        Toast.makeText(Create.this, "email sudah terdaftar", Toast.LENGTH_SHORT).show();
                        email.setText("");
                        email.requestFocus();
                    }
                }
            }
        });
    }
}
