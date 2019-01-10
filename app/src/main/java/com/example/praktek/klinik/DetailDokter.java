package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class DetailDokter extends AppCompatActivity {

    TextView dokter, dinas, poliklinik, jadwal, jam;
    CardView btnboking;
    private String Sdokter, Sdinas, Spoliklinik, Sjadwal, Sjam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        //deklarasi
        dokter = (TextView) findViewById(R.id.detail_namadokter);
        dinas = (TextView) findViewById(R.id.detail_namars);
        poliklinik = (TextView) findViewById(R.id.detail_namapoli);
        jadwal = (TextView) findViewById(R.id.detail_jadwal);
        jam = (TextView) findViewById(R.id.detail_jampraktek);
        btnboking = (CardView) findViewById(R.id.detail_booking);

        //getMethod
        dokter.setText(ModalDokter.get_namadokter());
        dinas.setText(ModalDokter.get_namars());
        poliklinik.setText(ModalDokter.get_polikolinik());
        jadwal.setText(ModalDokter.get_jadwalpraktek());
        jam.setText(ModalDokter.get_jampraktek());

        //getText on setModal
        Sdokter = dokter.getText().toString();
        Sdinas = dinas.getText().toString();
        Spoliklinik = poliklinik.getText().toString();
        Sjadwal = jadwal.getText().toString();
        Sjam = jam.getText().toString();

        //button action
        btnboking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void BackToDokter(View v) {
        Intent backtodokter = new Intent(DetailDokter.this, BookingDokterActivity.class);
        startActivity(backtodokter);
    }
}