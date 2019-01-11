package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HistoryBookingActivity extends AppCompatActivity {

    TextView nomor, nama, email, dokter, poliklinik, rs;
    private DatabaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_booking);
        nomor = (TextView) findViewById(R.id.history_nomor);
        nama = (TextView) findViewById(R.id.history_nama);
        email = (TextView) findViewById(R.id.history_email);
        dokter = (TextView) findViewById(R.id.history_dokter);
        poliklinik = (TextView) findViewById(R.id.history_poliklinik);
        rs = (TextView) findViewById(R.id.history_rs);
        DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());


        nomor.setText(String.valueOf(Integer.valueOf(ModalHistori.get_noantrian())));
        nama.setText(ModalHistori.get_nama());
        email.setText(ModalHistori.get_email());
        dokter.setText(ModalHistori.get_dokter());
        poliklinik.setText(ModalHistori.get_poliklinik());
        rs.setText(ModalHistori.get_rs());

    }

    public void BackToAkun(View v) {
        Intent backtoakun = new Intent(HistoryBookingActivity.this, InfoAkunActivity.class);
        startActivity(backtoakun);
    }

}