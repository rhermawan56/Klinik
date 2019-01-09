package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailDokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);
    }

    public void BackToDokter(View v) {
        Intent backtodokter = new Intent(DetailDokter.this, BookingDokterActivity.class);
        startActivity(backtodokter);
    }
}
