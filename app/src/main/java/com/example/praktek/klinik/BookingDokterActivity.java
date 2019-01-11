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
        beranda = (CardView) findViewById(R.id.dokter_cardberanda);
        rs = (CardView) findViewById(R.id.dokter_cardrs);
        akun = (CardView) findViewById(R.id.dokter_cardakun);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = 1101;
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataDokter(id);
                if (getDataRS == true){
                    db.readBedah();
                    IntentDetail();
                } else {}
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = 1102;
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataDokter(id);
                if (getDataRS == true){
                    IntentDetail();
                } else {}
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = 1201;
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataDokter(id);
                if (getDataRS == true){
                    IntentDetail();
                } else {}
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = 1202;
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataDokter(id);
                if (getDataRS == true){
                    IntentDetail();
                } else {}
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = 1301;
                DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                boolean getDataRS = db.getDataDokter(id);
                if (getDataRS == true){
                    IntentDetail();
                } else {}
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

    private void IntentDetail(){
        Intent intent = new Intent(BookingDokterActivity.this, DetailDokter.class);
        startActivity(intent);
    }
}