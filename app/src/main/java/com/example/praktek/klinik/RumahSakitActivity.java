package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RumahSakitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_sakit);
    }

    public void Beranda(View v) {
        Intent beranda = new Intent(RumahSakitActivity.this, Menu.class);
        startActivity(beranda);
    }

    public void RumahSakit(View v) {
        Intent rumahsakit = new Intent(RumahSakitActivity.this, RumahSakitActivity.class);
        startActivity(rumahsakit);
    }

    public void BookingDokter(View v) {
        Intent bookingdokter = new Intent(RumahSakitActivity.this, BookingDokterActivity.class);
        startActivity(bookingdokter);
    }

    public void InfoAkun(View v) {
        Intent infoakun = new Intent(RumahSakitActivity.this, InfoAkunActivity.class);
        startActivity(infoakun);
    }

    public void BackToMenu(View v) {
        Intent backtomenu = new Intent(RumahSakitActivity.this, Menu.class);
        startActivity(backtomenu);
    }
}
