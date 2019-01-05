package com.example.praktek.klinik;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Load extends AppCompatActivity {

    private static int splash = 4000;
    ImageView Gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        Gif = (ImageView)findViewById(R.id.load);
        Glide.with(Load.this)
                .load(R.drawable.google_logo)
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(Gif);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeintent = new Intent(Load.this, Login.class);
                startActivity(homeintent);
                finish();
            }
        },splash);
    }
}
