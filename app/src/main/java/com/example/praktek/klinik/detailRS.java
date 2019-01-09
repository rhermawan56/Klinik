package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class detailRS extends AppCompatActivity {

    CardView beranda, rs, dokter, akun, carddok2, cardpol2;
    TextView namars, alamatrs, tlprs, dokter1, dokter2, poli1, poli2, sdokter2, spoli2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rs);
        beranda = (CardView) findViewById(R.id.rs_cardberanda);
        rs = (CardView) findViewById(R.id.rs_cardrs);
        dokter = (CardView) findViewById(R.id.rs_carddokter);
        akun = (CardView) findViewById(R.id.rs_cardakun);
        namars = (TextView) findViewById(R.id.rsdetail_dbnama);
        alamatrs = (TextView) findViewById(R.id.rsdetail_dbalamat);
        tlprs = (TextView) findViewById(R.id.rsdetail_dbnotlprs);
        namars.setText(ModalRs.get_namars());
        alamatrs.setText(ModalRs.get_alamat());
        tlprs.setText(ModalRs.get_telp());
        dokter1 = (TextView) findViewById(R.id.rsdetail_dbdokter1);
        dokter2 = (TextView) findViewById(R.id.rsdetail_dbdokter2);
        sdokter2 = (TextView) findViewById(R.id.rsdetail_dokter2);
        poli1 = (TextView) findViewById(R.id.rsdetail_dbpol11);
        poli2 = (TextView) findViewById(R.id.rsdetail_dbpoli2);
        spoli2 = (TextView) findViewById(R.id.rsdetail_poli2);
        carddok2 = (CardView) findViewById(R.id.dokter_carddokter2);
        cardpol2 = (CardView) findViewById(R.id.cardpoli2);

        String nama = namars.getText().toString();

        if (nama.equals("Rumah Sakit Hasan Sadikin")){
            dokter1.setText("dr.Mille Milasari, Sp. B");
            poli1.setText("Bedah");
            dokter2.setText("dr. Kevin Irwan, Sp. KG");
            poli2.setText("Gigi");
        } else if (nama.equals("Rumah Sakit Umum Avisena")){
            dokter1.setText("dr. Nina Natalia, Sp. A");
            poli1.setText("Anak");
            dokter2.setText("dr. Rachelia Salanti");
            poli2.setText("Umum");
        } else {
            dokter1.setText("dr. Puji Ichtiarti, Sp. OG");
            poli1.setText("Kandungan");
            sdokter2.setVisibility(sdokter2.GONE);
            carddok2.setVisibility(carddok2.GONE);
            spoli2.setVisibility(spoli2.GONE);
            cardpol2.setVisibility(cardpol2.GONE);
        }

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, Menu.class);
                startActivity(intent);
            }
        });

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, RumahSakitActivity.class);
                startActivity(intent);
            }
        });
        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, BookingDokterActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailRS.this, InfoAkunActivity.class);
                startActivity(intent);
            }
        });
    }

    public void kosong(){
        ModalRs kos = new ModalRs();
        kos.set_id("");
        kos.set_namars("");
        kos.set_alamat("");
        kos.set_telp("");
        kos.set_dokter("");
        kos.set_poli("");
    }

    public void BackToHospital(View v) {
        Intent backtohoapital = new Intent(detailRS.this, RumahSakitActivity.class);
        startActivity(backtohoapital );
    }
}
