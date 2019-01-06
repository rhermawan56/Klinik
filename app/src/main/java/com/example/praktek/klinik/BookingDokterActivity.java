package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BookingDokterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_dokter);
    }

    public void Beranda(View v) {
        Intent beranda = new Intent(BookingDokterActivity.this, Menu.class);
        startActivity(beranda);
    }

    public void RumahSakit(View v) {
        Intent rumahsakit = new Intent(BookingDokterActivity.this, RumahSakitActivity.class);
        startActivity(rumahsakit);
    }

    public void BookingDokter(View v) {
        Intent bookingdokter = new Intent(BookingDokterActivity.this, BookingDokterActivity.class);
        startActivity(bookingdokter);
    }

    public void InfoAkun(View v) {
        Intent infoakun = new Intent(BookingDokterActivity.this, InfoAkunActivity.class);
        startActivity(infoakun);
    }
}
