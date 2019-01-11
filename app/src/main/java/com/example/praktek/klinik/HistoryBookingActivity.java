package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
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
        db = DatabaseAccess.getInstance(getApplicationContext());
        db.cekBokingBedah(ModalPoliBedah.get_akun());

        nomor.setText(ModalPoliBedah.get_idbooking());
        nama.setText(ModalLogin.get_nama());
        email.setText(ModalPoliBedah.get_akun());
        dokter.setText(ModalPoliBedah.get_namadok());
        poliklinik.setText(ModalPoliBedah.get_polidok());
        rs.setText(ModalPoliBedah.get_namars());
    }

    public void BackToAkun(View v) {
        Intent backtoakun = new Intent(HistoryBookingActivity.this, InfoAkunActivity.class);
        startActivity(backtoakun);
    }

}
