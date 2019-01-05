package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InfoAkunActivity extends AppCompatActivity {

    CardView home, logout;
    TextView nama, email, tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);
        home = (CardView) findViewById(R.id.info_cardhome);
        nama = (TextView) findViewById(R.id.info_nama);
        nama.setText(ModalLogin.get_Nama());
        email = (TextView) findViewById(R.id.info_email);
        email.setText(ModalLogin.get_Email());
        tlp = (TextView) findViewById(R.id.info_tlp);
        tlp.setText(ModalLogin.get_Notlp());
        logout = (CardView) findViewById(R.id.info_btnlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoAkunActivity.this,"Logout Sukses",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InfoAkunActivity.this,Login.class);
                startActivity(intent);
                nama.setText("");
                email.setText("");
                tlp.setText("");
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}