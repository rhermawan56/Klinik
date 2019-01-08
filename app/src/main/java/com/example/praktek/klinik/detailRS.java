package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class detailRS extends AppCompatActivity {

    CardView beranda, rs, dokter, akun;
    TextView namars, alamatrs, tlprs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rs);
        beranda = (CardView) findViewById(R.id.rs_cardberanda);
        rs = (CardView) findViewById(R.id.rs_cardrs);
        dokter = (CardView) findViewById(R.id.rs_carddokter);
        akun = (CardView) findViewById(R.id.rs_cardakun);
        namars = (TextView) findViewById(R.id.rsdetail_dbnama);
        alamatrs = (TextView) findViewById(R.id.rsdetail_dbalamat);
        tlprs = (TextView) findViewById(R.id.rsdetail_dbnotlprs);
        namars.setText(ModalRs.get_namars());
        alamatrs.setText(ModalRs.get_alamat());
        tlprs.setText(ModalRs.get_telp());

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, Menu.class);
                startActivity(intent);
            }
        });

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, RumahSakitActivity.class);
                startActivity(intent);
            }
        });
        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, BookingDokterActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, InfoAkunActivity.class);
                startActivity(intent);
            }
        });
    }
}
