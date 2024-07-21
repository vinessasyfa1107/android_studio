package com.example.splashscreen; //tergantung nama package
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //bla bla
                Intent home=new Intent(MainActivity.this, home.class);
                startActivity(home);
                finish();
            }
        }, waktu_loading);
    }
}