package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class RumahSakitActivity extends AppCompatActivity {

    BootstrapButton detailrs1, detailrs2, detailrs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_sakit);
        detailrs1 = (BootstrapButton) findViewById(R.id.detail1);
        detailrs2 = (BootstrapButton) findViewById(R.id.detail2);
        detailrs3 = (BootstrapButton) findViewById(R.id.detail3);
    }

    public void Beranda(View v) {
        Intent beranda = new Intent(RumahSakitActivity.this, Menu.class);
        startActivity(beranda);
    }

    public void RumahSakit(View v) {
        Intent rumahsakit = new Intent(RumahSakitActivity.this, RumahSakitActivity.class);
        startActivity(rumahsakit);
    }

    public void Dokter(View v) {
        Intent bookingdokter = new Intent(RumahSakitActivity.this, BookingDokterActivity.class);
        startActivity(bookingdokter);
    }

    public void InfoAkun(View v) {
        Intent infoakun = new Intent(RumahSakitActivity.this, InfoAkunActivity.class);
        startActivity(infoakun);
    }
}
