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
    }
}
