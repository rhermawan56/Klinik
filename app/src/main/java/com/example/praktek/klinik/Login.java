package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email, pass;
    Button login, create;
    DatabaseHelper db;
    private String Semail, Spass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        create = (Button) findViewById(R.id.buttoncreate);
        login = (Button) findViewById(R.id.buttonin);
        db = new DatabaseHelper(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Create.class);
                startActivity(intent);
                email.setText("");
                pass.setText("");
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Semail = email.getText().toString();
                Spass = pass.getText().toString();
                boolean login = db.login(Semail, Spass);

                if (Semail.equals("")){
                    Toast.makeText(Login.this,"email can't be empty",Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                } else if (Spass.equals("")){
                    Toast.makeText(Login.this,"password can't be empty",Toast.LENGTH_SHORT).show();
                } else if (login == true){
                    Toast.makeText(Login.this,"Successfully login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Menu.class);
                    startActivity(intent);
                    email.setText("");
                    pass.setText("");
                } else {
                    Toast.makeText(Login.this,"can't be login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
