package com.example.praktek.klinik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailAkunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_akun);
    }

    public void BackToAkun(View v) {
        Intent backtoakun = new Intent(DetailAkunActivity.this, InfoAkunActivity.class);
        startActivity(backtoakun);
        DetailAkunActivity.this.finish();
    }

    public void onBackPressed() {
        DetailAkunActivity.this.finish();
        super.onBackPressed();
    }
}
