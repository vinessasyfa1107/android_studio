package com.example.recyclerviewcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CardView extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterCardView adapter;
    private TextView titleTextView;
    private Toolbar toolbar;
    ArrayList<ItemModel_CardView> items;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        //option menu
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = new ArrayList<>();
        items.add(new ItemModel_CardView("Ahmad Dahlan","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.ahmad_dahlan));
        items.add(new ItemModel_CardView("Ahmad Yani","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.ahmad_yani));
        items.add(new ItemModel_CardView("Bung Tomo","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.bung_tomo));
        items.add(new ItemModel_CardView("Gatot Subroto","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.gatot_subroto));
        items.add(new ItemModel_CardView("Ki Hadjar Dewantara","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.ki_hadjar_dewantara));
        items.add(new ItemModel_CardView("Mohammad Hatta","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.mohammad_hatta));
        items.add(new ItemModel_CardView("Soedirman","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.sudirman));
        items.add(new ItemModel_CardView("Soekarno","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.sukarno));
        items.add(new ItemModel_CardView("Soepomo","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.supomo));
        items.add(new ItemModel_CardView("Tan Mala","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam erat nibh, congue non arcu vel, varius sagittis ligula. Vestibulum in quam elit. Cras eget mattis nulla.", R.drawable.tan_malaka));


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterCardView(this, items);
        recyclerView.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Mode CardView");
        }
    }

    // untuk menampilkan toolbar option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemId = item.getItemId();
        if (itemId == R.id.option1){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.option2){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}