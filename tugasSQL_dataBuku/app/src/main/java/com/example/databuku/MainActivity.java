package com.example.databuku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.databuku.Adapter.BookAdapter;
import com.example.databuku.Adapter.GetData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<GetData> model;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        model = new ArrayList<>();
        bookAdapter = new BookAdapter(getApplicationContext(), model);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_option, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.edit) {
                            Intent intent = new Intent(getApplicationContext(), SimpanData.class);
                            intent.putExtra("edit_data", model.get(position).getId());
                            startActivity(intent);
                        } else if (menuItem.getItemId() == R.id.hapus) {
                            String idToDelete = model.get(position).getId();
                            deleteData(idToDelete);
                        }
                        return false;
                    }
                });
            }
        });

        load_data();
    }

    void load_data() {
        String url = new Konfigurasi().baseUrl() + "tampil_data.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    model.clear(); // Clear the existing data
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray dataArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject data = dataArray.getJSONObject(i);
                        String id = data.getString("id");
                        String judul = data.getString("judul");
                        String penulis = data.getString("penulis");
                        String tahun = data.getString("tahun");

                        model.add(new GetData(id, judul, penulis, tahun));
                    }

                    bookAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error parsing JSON data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    void deleteData(String id) {
        String url = new Konfigurasi().baseUrl() + "delete.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");
                    if (status.equals("success")) {
                        Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                        load_data(); // Reload the data from the server
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "Error parsing JSON response: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error deleting data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    protected void onResume() {
        super.onResume();
        load_data();
    }
}
