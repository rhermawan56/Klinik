package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class BookingDokterActivity extends AppCompatActivity {

    CardView card1, card2, card3, card4, card5;
    CardView beranda, rs, akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_dokter);
        card1 = (CardView) findViewById(R.id.dokter_card1);
        card2 = (CardView) findViewById(R.id.dokter_card2);
        card3 = (CardView) findViewById(R.id.dokter_card3);
        card4 = (CardView) findViewById(R.id.dokter_card4);
        card5 = (CardView) findViewById(R.id.dokter_card5);
        beranda = (CardView) findViewById(R.id.dokter_cardakun);
        rs = (CardView) findViewById(R.id.dokter_cardrs);
        akun = (CardView) findViewById(R.id.dokter_cardakun);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingDokterActivity.this, Menu.class);
                startActivity(intent);
            }
        });

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingDokterActivity.this, RumahSakitActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingDokterActivity.this, InfoAkunActivity.class);
                startActivity(intent);
            }
        });
    }
}
