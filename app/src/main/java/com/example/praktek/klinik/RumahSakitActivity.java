package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class RumahSakitActivity extends AppCompatActivity {

    BootstrapButton detailrs1, detailrs2, detailrs3;
    CardView beranda, dokter, akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_sakit);
        detailrs1 = (BootstrapButton) findViewById(R.id.detail1);
        detailrs2 = (BootstrapButton) findViewById(R.id.detail2);
        detailrs3 = (BootstrapButton) findViewById(R.id.detail3);
        beranda = (CardView) findViewById(R.id.rs_cardberanda);
        dokter = (CardView) findViewById(R.id.rs_carddokter);
        akun = (CardView) findViewById(R.id.rs_cardakun);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RumahSakitActivity.this, Menu.class);
                startActivity(intent);
            }
        });

        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RumahSakitActivity.this, BookingDokterActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RumahSakitActivity.this, InfoAkunActivity.class);
                startActivity(intent);
            }
        });

        detailrs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = "4";
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataRS(nama);
                if (getDataRS == true){
                    intentDetail();
                }
            }
        });

        detailrs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = "6";
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataRS(nama);
                if (getDataRS == true){
                    intentDetail();
                }
            }
        });

        detailrs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = "8";
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataRS(nama);
                if (getDataRS == true) {
                    intentDetail();
                }
            }
        });
    }

    private void intentDetail(){
        Intent intent = new Intent(RumahSakitActivity.this, detailRS.class);
        startActivity(intent);
    }
}