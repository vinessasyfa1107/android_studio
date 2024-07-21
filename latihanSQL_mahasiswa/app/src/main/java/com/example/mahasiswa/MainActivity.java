package com.example.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://103.47.133.78/";
    private EditText editTextNIM;
    private EditText editTextNama;
    private EditText editTextTlp;
    private EditText editTextProdi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNIM = findViewById(R.id.etNim);
        editTextNama = findViewById(R.id.etNama);
        editTextTlp = findViewById(R.id.etTlp);
        editTextProdi = findViewById(R.id.etProdi);
        btnDaftar = findViewById(R.id.buttonDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim = editTextNIM.getText().toString();
                String nama = editTextNama.getText().toString();
                String tlp = editTextTlp.getText().toString();
                String prodi = editTextProdi.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RegisterAPI api = retrofit.create(RegisterAPI.class);
                Call<Value> call = api.daftar(nim, nama, tlp, prodi);
                call.enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        String value = response.body().getValue();
                        String message = response.body().getMessage();

                        if (value.equals("1")) {
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
