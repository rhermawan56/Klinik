package com.example.praktek.klinik;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    TextView name;
    CardView rs, dokter, akun;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        name = (TextView) findViewById(R.id.nama);
        name.setText(ModalLogin.get_nama());
        rs = (CardView) findViewById(R.id.menu_cardrs);
        dokter = (CardView) findViewById(R.id.menu_carddokter);
        akun = (CardView) findViewById(R.id.menu_cardakun);

        rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, RumahSakitActivity.class);
                startActivity(intent);
            }
        });

        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, BookingDokterActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, InfoAkunActivity.class);
                startActivity(intent);
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
                        Menu.this.finish();
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

    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            showDialog();
            return;
        } else {
            backToast = Toast.makeText(Menu.this, "ketuk dua kali untuk keluar", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
