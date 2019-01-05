package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class InfoAkunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);
    }

    public void Beranda(View v) {
        Intent beranda = new Intent(InfoAkunActivity.this, Menu.class);
        startActivity(beranda);
    }

    public void RumahSakit(View v) {
        Intent rumahsakit = new Intent(InfoAkunActivity.this, RumahSakitActivity.class);
        startActivity(rumahsakit);
    }

    public void BookingDokter(View v) {
        Intent bookingdokter = new Intent(InfoAkunActivity.this, BookingDokterActivity.class);
        startActivity(bookingdokter);
    }

    public void InfoAkun(View v) {
        Intent infoakun = new Intent(InfoAkunActivity.this, InfoAkunActivity.class);
        startActivity(infoakun);
    }
}
