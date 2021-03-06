package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email, pass;
    CardView login, create;
    private String Semail, Spass;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.login_email);
        pass = (EditText) findViewById(R.id.login_pass);
        login = (CardView) findViewById(R.id.login_cardlogin);
        create = (CardView) findViewById(R.id.login_cardcreate);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Create.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Semail = email.getText().toString();
                Spass = pass.getText().toString();
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean Log = db.login(Semail, Spass);
                if (Log == true) {
                    Toast.makeText(Login.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Menu.class);
                    startActivity(intent);
                    email.setText("");
                    pass.setText("");
                } else {
                    Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            ActivityCompat.finishAffinity(Login.this);
            System.exit(0);
            return;
        } else {
            backToast = Toast.makeText(Login.this, "Ketuk dua kali untuk keluar", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}