package com.example.praktek.klinik;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class InfoAkunActivity extends AppCompatActivity {

    CardView akun, riwayat, logout;
    CardView home, rs, dokter;
    private DatabaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_akun);
        akun = (CardView) findViewById(R.id.info_detailakun);
        riwayat = (CardView) findViewById(R.id.info_riwayat);
        logout = (CardView) findViewById(R.id.info_btnlogout);
        home = (CardView) findViewById(R.id.info_cardhome);
        rs = (CardView) findViewById(R.id.info_cardrs);
        dokter = (CardView) findViewById(R.id.info_carddokter);
        db = DatabaseAccess.getInstance(getApplicationContext());

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, DetailAkunActivity.class);
                startActivity(intent);
            }
        });

        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.readAccountHistory(ModalLogin.get_email());
                Intent intent = new Intent(InfoAkunActivity.this, HistoryBookingActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, Menu.class);
                startActivity(intent);
                InfoAkunActivity.this.finish();
            }
        });

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, RumahSakitActivity.class);
                startActivity(intent);
                InfoAkunActivity.this.finish();
            }
        });

        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoAkunActivity.this, BookingDokterActivity.class);
                startActivity(intent);
                InfoAkunActivity.this.finish();
            }
        });
    }
    private void showDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Apakah anda yakin akan logout?");
        alert
                .setMessage("Klik Ya untuk logout")
                .setIcon(R.drawable.app_logo)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ModalLogin modalLogin = new ModalLogin();
                        modalLogin.set_email("");
                        modalLogin.set_password("");
                        modalLogin.set_nama("");
                        modalLogin.set_notlp("");
                        Intent intent = new Intent(InfoAkunActivity.this, Login.class);
                        startActivity(intent);
                        InfoAkunActivity.this.finish();
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