package com.example.praktek.klinik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class InfoAkunActivity extends AppCompatActivity {

    CardView home, logout, beranda, rs, dokter;
    TextView nama, email, tlp;
    private View convertView;
    private LayoutInflater inflater;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);
//        home = (CardView) findViewById(R.id.info_cardhome);
        nama = (TextView) findViewById(R.id.info_nama);
        email = (TextView) findViewById(R.id.info_email);
        tlp = (TextView) findViewById(R.id.info_tlp);
        logout = (CardView) findViewById(R.id.info_btnlogout);
        beranda = (CardView) findViewById(R.id.dokter_cardberanda);
        rs = (CardView) findViewById(R.id.dokter_cardrs);
        dokter = (CardView) findViewById(R.id.dokter_cardrs);


        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoAkunActivity.this,"Logout Sukses",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InfoAkunActivity.this,Load.class);
                startActivity(intent);
                InfoAkunActivity.this.finish();
                nama.setText("");
                email.setText("");
                tlp.setText("");
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, Menu.class);
                startActivity(intent);
            }
        });

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, Menu.class);
                startActivity(intent);
            }
        });

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, RumahSakitActivity.class);
                startActivity(intent);
            }
        });

        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, BookingDokterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void GoToDetailAccount(View v) {
        Intent gotodetailaccount = new Intent(InfoAkunActivity.this, DetailAkunActivity.class);
        startActivity(gotodetailaccount);
    }

    public void GoToHistoryBooking(View v) {
        Intent gotohistorybooking = new Intent(InfoAkunActivity.this, HistoryBookingActivity.class);
        startActivity(gotohistorybooking);
    }
}