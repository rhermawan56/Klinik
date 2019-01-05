package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class InfoAkunActivity extends AppCompatActivity {

    CardView home;
    TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);
        home = (CardView) findViewById(R.id.menu_cardhome);
        nama = (TextView) findViewById(R.id.nama);
        nama.setText(ModalLogin.get_Nama());

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}