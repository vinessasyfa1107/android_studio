package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPersegi;
    private Button btnSegitiga;
    private Button btnKubus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersegi=(Button)findViewById(R.id.btn_persegi);
        btnPersegi.setOnClickListener(this);

        btnSegitiga=(Button)findViewById(R.id.btn_segitiga);
        btnSegitiga.setOnClickListener(this);

        btnKubus=(Button)findViewById(R.id.btn_kubus);
        btnKubus.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btn_persegi){
            Intent moveIntent = new Intent(MainActivity.this, persegi.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_segitiga) {
            Intent moveIntent = new Intent(MainActivity.this, segitiga.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_kubus) {
            Intent moveIntent = new Intent(MainActivity.this, kubus.class);
            startActivity(moveIntent);
        }
    }
}