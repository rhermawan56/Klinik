package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    DatabaseHelper db;
    EditText nama, email, pass, pass2, tlp;
    Button create, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        db = new DatabaseHelper(this);
        nama = (EditText) findViewById(R.id.create_nama);
        email = (EditText) findViewById(R.id.create_email);
        pass = (EditText) findViewById(R.id.create_password);
        pass2 = (EditText) findViewById(R.id.create_password2);
        tlp = (EditText) findViewById(R.id.create_tlp);
        create = (Button) findViewById(R.id.createbtn_create);
        cancel = (Button) findViewById(R.id.createbtn_cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create.this, Login.class);
                nama.setText("");
                email.setText("");
                pass.setText("");
                pass2.setText("");
                tlp.setText("");
                create.requestFocus();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Snama = nama.getText().toString();
                String Semail = email.getText().toString();
                String Spass = pass.getText().toString();
                String Spass2 = pass2.getText().toString();
                String Stlp = tlp.getText().toString();

                if (Snama.equals("")) {
                    Toast.makeText(Create.this, "nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    nama.requestFocus();
                } else if (Semail.equals("")) {
                    Toast.makeText(Create.this, "email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                } else if (Spass.equals("")) {
                    Toast.makeText(Create.this, "password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                } else if (Spass2.equals("")) {
                    Toast.makeText(Create.this, "confirm password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                } else if (Stlp.equals("")) {
                    Toast.makeText(Create.this, "telepon tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    tlp.requestFocus();
                } else {
                    if (Spass.equals(Spass2)) {
                        boolean cekemail = db.cekemail(Semail);
                        if (cekemail == true) {
                            db.CreateAccount(new ModalLogin(null, Snama, Semail, Spass, Stlp));
                            Toast.makeText(Create.this, "Successfuly Register!", Toast.LENGTH_SHORT).show();
                            db.login(Semail,Spass2);
                            Intent intent = new Intent(Create.this, Menu.class);
                            startActivity(intent);
                            nama.setText("");
                            email.setText("");
                            pass.setText("");
                            pass2.setText("");
                            tlp.setText("");
                            nama.requestFocus();
                        } else {
                            Toast.makeText(Create.this, "email already exist", Toast.LENGTH_SHORT).show();
                            email.setText("");
                            email.requestFocus();
                        }
                    } else {
                        Toast.makeText(Create.this,"confirm password is wrong",Toast.LENGTH_SHORT).show();
                        pass.setText("");
                        pass2.setText("");
                        pass.requestFocus();
                    }
                }
            }
        });
    }
}
