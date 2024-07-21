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

public class persegi extends AppCompatActivity {
    EditText sisiPersegi;
    TextView viewHasilPersegi;
    Button btn_calculatepersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        sisiPersegi = findViewById(R.id.sisiPersegi);
        viewHasilPersegi = findViewById(R.id.viewHasilPersegi);
        btn_calculatepersegi = findViewById(R.id.btn_calculatepersegi);

        btn_calculatepersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringSisiPersegi = sisiPersegi.getText().toString();
                double sisi = Double.parseDouble(stringSisiPersegi);
                double luas = sisi*sisi;

                String hasil = "Luas persegi dengan sisi " + sisi + " adalah " + luas;
                viewHasilPersegi.setText(hasil);
            }
        });
    }
    public void backToActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
