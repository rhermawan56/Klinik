package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailDokter extends AppCompatActivity {

    TextView dokter, dinas, poliklinik, jadwal, jam;
    CardView btnboking;
    ImageView back;
    private String Sdokter, Sdinas, Spoliklinik, Sjadwal, Sjam;
    DatabaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        //deklarasi
        dokter = (TextView) findViewById(R.id.detail_namadokter);
        dinas = (TextView) findViewById(R.id.detail_namars);
        poliklinik = (TextView) findViewById(R.id.detail_namapoli);
        jadwal = (TextView) findViewById(R.id.detail_jadwal);
        jam = (TextView) findViewById(R.id.detail_jampraktek);
        btnboking = (CardView) findViewById(R.id.detail_booking);
        back = (ImageView) findViewById(R.id.detaildokter_back);
        db = DatabaseAccess.getInstance(getApplicationContext());

        //getMethod
        dokter.setText(ModalDokter.get_namadokter());
        dinas.setText(ModalDokter.get_namars());
        poliklinik.setText(ModalDokter.get_polikolinik());
        jadwal.setText(ModalDokter.get_jadwalpraktek());
        jam.setText(ModalDokter.get_jampraktek());

        //getText on setModal
        Sdokter = dokter.getText().toString();
        Sdinas = dinas.getText().toString();
        Spoliklinik = poliklinik.getText().toString();
        Sjadwal = jadwal.getText().toString();
        Sjam = jam.getText().toString();

        //button action
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailDokter.this, BookingDokterActivity.class);
                DetailDokter.this.finish();
            }
        });

        btnboking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Spoliklinik.equals("Bedah")){
                    String boking = ModalPoliBedah.get_idbooking() + 1;
                    String email = ModalLogin.get_email();
                        db.createBedah(new ModalPoliBedah(null, boking, Sdinas, Sdokter, Spoliklinik, email));
                        Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                        startActivity(intent);
//                    } else {
  //                      Toast.makeText(DetailDokter.this, "Anda sudah boking",Toast.LENGTH_SHORT).show();
    //                    Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
      //                  startActivity(intent);
        //            }
                } else {}
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DetailDokter.this.finish();
    }
}