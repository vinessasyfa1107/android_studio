package com.example.databuku;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SimpanData extends AppCompatActivity {

    Toolbar toolbar;
    Button simpanData;
    TextInputEditText judul, penulis, tahun;
    TextView label;
    boolean isEdit = false;
    String id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpan_data);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        judul = findViewById(R.id.InpJudul);
        penulis = findViewById(R.id.InpPenulis);
        tahun = findViewById(R.id.InpTahun);
        label = findViewById(R.id.label);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Cek apakah ada data edit
        Intent intent = getIntent();
        if (intent.hasExtra("edit_data")) {
            isEdit = true;
            id = intent.getStringExtra("edit_data");
            label.setText("Edit Data");
            getSupportActionBar().setTitle("Edit Data");
            // Panggil fungsi getData() untuk mengambil data dari server
            getData();
        } else {
            getSupportActionBar().setTitle("Tambah Data");
        }

        simpanData = findViewById(R.id.simpanData);
        simpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = true;

                if (judul.getText().toString().isEmpty()) {
                    judul.setError("Tidak boleh kosong");
                    isValid = false;
                }
                if (penulis.getText().toString().isEmpty()) {
                    penulis.setError("Tidak boleh kosong");
                    isValid = false;
                }
                if (tahun.getText().toString().isEmpty()) {
                    tahun.setError("Tidak boleh kosong");
                    isValid = false;
                }

                if (isValid) {
                    String url;
                    if (isEdit) {
                        url = new Konfigurasi().baseUrl() + "update.php";
                    } else {
                        url = new Konfigurasi().baseUrl() + "create.php";
                    }

                    StringRequest stringRequest = new StringRequest(
                            Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String status = jsonObject.getString("status");
                                if (status.equals("data_tersimpan")) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SimpanData.this);
                                    builder.setTitle("Sukses");
                                    builder.setMessage("Data sukses tersimpan");
                                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            finish();
                                        }
                                    });

                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else {
                                    Toast.makeText(SimpanData.this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(SimpanData.this, "Terjadi kesalahan: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(SimpanData.this, "Terjadi kesalahan: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> form = new HashMap<>();
                            form.put("judul", judul.getText().toString());
                            form.put("penulis", penulis.getText().toString());
                            form.put("tahun", tahun.getText().toString());
                            if (isEdit) {
                                form.put("id", id);
                            }
                            return form;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }
            }
        });
    }

    // Fungsi untuk mengambil data dari server
    void getData() {
        String url = new Konfigurasi().baseUrl() + "read.php";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject data = jsonObject.getJSONObject("data");
                    judul.setText(data.getString("judul"));
                    penulis.setText(data.getString("penulis"));
                    tahun.setText(data.getString("tahun"));
                } catch (JSONException e) {
                    Toast.makeText(SimpanData.this, "Terjadi kesalahan: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SimpanData.this, "Terjadi kesalahan: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("id", id);
                return form;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
