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

public class kubus extends AppCompatActivity {
    EditText sisiKubus;
    TextView viewHasilKubus;
    Button btn_calculateKubus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);

        sisiKubus = findViewById(R.id.sisiKubus);
        viewHasilKubus = findViewById(R.id.viewHasilKubus);
        btn_calculateKubus = findViewById(R.id.btn_calculateKubus);

        btn_calculateKubus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringSisiKubus = sisiKubus.getText().toString();
                double sisi = Double.parseDouble(stringSisiKubus);
                double volume = sisi*sisi*sisi;

                String hasil = " Volume kubus adalah " + volume;
                viewHasilKubus.setText(hasil);
            }
        });
    }
    public void backToActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
