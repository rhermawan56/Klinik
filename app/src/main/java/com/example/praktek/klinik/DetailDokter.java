package com.example.praktek.klinik;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
    private String nama, email;
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
        nama = ModalLogin.get_nama();
        email = ModalLogin.get_email();

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
                    DialogBedah();
                } else if (Spoliklinik.equals("Gigi")){
                    DialogGigi();
                } else if (Spoliklinik.equals("Anak")){
                    DialogAnak();
                } else if (Spoliklinik.equals("Umum")){
                    DialogUmum();
                } else {
                    DialogKandungan();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DetailDokter.this.finish();
    }

    private void DialogBedah(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah anda yakin akan mendaftar antrian?");
        alert
                .setMessage("Klik Ya untuk mendaftar antrian")
                .setIcon(R.drawable.app_logo)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        int idpoli = 1101;
                        Boolean cekHistory = db.cekHistory(email);
                        if (cekHistory == true){
                            db.readHistory(idpoli);
                            Integer antrian = ModalHistori.get_noantrian();
                            int noantrian = antrian +1;
                            db.createHistory(new ModalHistori(null,idpoli,noantrian,nama,email,Sdokter,Spoliklinik,Sdinas));
                            Toast.makeText(DetailDokter.this,"Boking berhasil", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        } else {
                            Toast.makeText(DetailDokter.this,"Boking sudah tersedia", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        }
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void DialogGigi(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah anda yakin akan mendaftar antrian?");
        alert
                .setMessage("Klik Ya untuk mendaftar antrian")
                .setIcon(R.drawable.app_logo)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        int idpoli = 1102;
                        Boolean cekHistory = db.cekHistory(email);
                        if (cekHistory == true){
                            db.readHistory(idpoli);
                            Integer antrian = ModalHistori.get_noantrian();
                            int noantrian = antrian +1;
                            db.createHistory(new ModalHistori(null,idpoli,noantrian,nama,email,Sdokter,Spoliklinik,Sdinas));
                            Toast.makeText(DetailDokter.this,"Boking berhasil", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        } else {
                            Toast.makeText(DetailDokter.this,"Boking sudah tersedia", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        }
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void DialogAnak(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah anda yakin akan mendaftar antrian?");
        alert
                .setMessage("Klik Ya untuk mendaftar antrian")
                .setIcon(R.drawable.app_logo)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        int idpoli = 1201;
                        Boolean cekHistory = db.cekHistory(email);
                        if (cekHistory == true){
                            db.readHistory(idpoli);
                            Integer antrian = ModalHistori.get_noantrian();
                            int noantrian = antrian +1;
                            db.createHistory(new ModalHistori(null,idpoli,noantrian,nama,email,Sdokter,Spoliklinik,Sdinas));
                            Toast.makeText(DetailDokter.this,"Boking berhasil", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        } else {
                            Toast.makeText(DetailDokter.this,"Boking sudah tersedia", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        }
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void DialogUmum(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah anda yakin akan mendaftar antrian?");
        alert
                .setMessage("Klik Ya untuk mendaftar antrian")
                .setIcon(R.drawable.app_logo)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        int idpoli = 1202;
                        Boolean cekHistory = db.cekHistory(email);
                        if (cekHistory == true){
                            db.readHistory(idpoli);
                            Integer antrian = ModalHistori.get_noantrian();
                            int noantrian = antrian +1;
                            db.createHistory(new ModalHistori(null,idpoli,noantrian,nama,email,Sdokter,Spoliklinik,Sdinas));
                            Toast.makeText(DetailDokter.this,"Boking berhasil", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        } else {
                            Toast.makeText(DetailDokter.this,"Boking sudah tersedia", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        }
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void DialogKandungan(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah anda yakin akan mendaftar antrian?");
        alert
                .setMessage("Klik Ya untuk mendaftar antrian")
                .setIcon(R.drawable.app_logo)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        int idpoli = 1301;
                        Boolean cekHistory = db.cekHistory(email);
                        if (cekHistory == true){
                            db.readHistory(idpoli);
                            Integer antrian = ModalHistori.get_noantrian();
                            int noantrian = antrian +1;
                            db.createHistory(new ModalHistori(null,idpoli,noantrian,nama,email,Sdokter,Spoliklinik,Sdinas));
                            Toast.makeText(DetailDokter.this,"Boking berhasil", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        } else {
                            Toast.makeText(DetailDokter.this,"Boking sudah tersedia", Toast.LENGTH_SHORT).show();
                            db.readAccountHistory(email);
                            Intent intent = new Intent(DetailDokter.this, HistoryBookingActivity.class);
                            startActivity(intent);
                            DetailDokter.this.finish();
                        }
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}