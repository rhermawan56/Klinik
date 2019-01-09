package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HistoryBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_booking);
    }

    public void BackToAkun(View v) {
        Intent backtoakun = new Intent(HistoryBookingActivity.this, InfoAkunActivity.class);
        startActivity(backtoakun);
    }

}
