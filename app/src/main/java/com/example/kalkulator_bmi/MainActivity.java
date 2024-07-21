package com.example.kalkulator_bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    hitungBMI hitungBMI = new hitungBMI();
    EditText txtBeratBadan, txtTinggibadan;
    TextView txtStatusBadan;
    Button btnCekBMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBeratBadan = findViewById(R.id.txtBeratBadan);
        txtTinggibadan = findViewById(R.id.txtTinggiBadan);
        txtStatusBadan = findViewById(R.id.txtStatusBadan);
        btnCekBMI = findViewById(R.id.btnCekBMI);

        btnCekBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringBeratBadan = txtBeratBadan.getText().toString();
                String stringTinggiBadan = txtTinggibadan.getText().toString();

                double beratBadan = Double.parseDouble(stringBeratBadan);
                double tinggiBadan = Double.parseDouble(stringTinggiBadan);

                String statusBadan = hitungBMI.hitungBMI(beratBadan, tinggiBadan);
                txtStatusBadan.setText(statusBadan);
            }
        });
    }


}