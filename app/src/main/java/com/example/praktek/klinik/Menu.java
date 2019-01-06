package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    TextView name;
    CardView beranda, rs, boking, akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = (TextView) findViewById(R.id.nama);
        name.setText(ModalLogin.get_Nama());
        beranda = (CardView) findViewById(R.id.menu_cardberanda);
        rs = (CardView) findViewById(R.id.menu_cardklinik);
        boking = (CardView) findViewById(R.id.menu_cardboking);
        akun = (CardView) findViewById(R.id.menu_cardakun);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu.this, "Maintenance", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Menu.this, DetailDokter.class);
                startActivity(intent);
            }
        });

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, RumahSakitActivity.class);
                startActivity(intent);
            }
        });

        boking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,BookingDokterActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, InfoAkunActivity.class);
                startActivity(intent);
            }
        });
    }
}
