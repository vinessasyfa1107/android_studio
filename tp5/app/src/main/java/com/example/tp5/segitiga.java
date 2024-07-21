package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//these function for back button
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class segitiga extends AppCompatActivity {
    EditText alasSegitiga, tinggiSegitiga;
    TextView viewHasilSegitiga;
    Button btn_calculateSegitiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        alasSegitiga = findViewById(R.id.alasSegitiga);
        tinggiSegitiga = findViewById(R.id.tinggiSegitiga);
        viewHasilSegitiga = findViewById(R.id.viewHasilSegitiga);
        btn_calculateSegitiga = findViewById(R.id.btn_calculateSegitiga);

        btn_calculateSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringAlasSegitiga = alasSegitiga.getText().toString();
                String stringTinggiSegitiga = tinggiSegitiga.getText().toString();
                double alas = Double.parseDouble(stringAlasSegitiga);
                double tinggi = Double.parseDouble(stringTinggiSegitiga);
                double luas = (alas*tinggi)/2;

                String hasil = " Luas segitiga adalah " + luas;
                viewHasilSegitiga.setText(hasil);
            }
        });
    }
    public void backToActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
