package com.example.recyclerviewcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.recyclerviewcard.GridHeroAdapter;
import com.example.recyclerviewcard.R;

public class MainActivity extends AppCompatActivity {

    //ini deklarasi
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    GridHeroAdapter gridHeroAdapter;

    private TextView titleTextView;
    private Toolbar toolbar;

    //ini untuk menjalankan fungsi array grid

    int []arr = {R.drawable.ahmad_dahlan,R.drawable.ahmad_yani,R.drawable.bung_tomo,R.drawable.gatot_subroto,R.drawable.ki_hadjar_dewantara,R.drawable.mohammad_hatta,R.drawable.sudirman,R.drawable.sukarno,R.drawable.supomo,R.drawable.tan_malaka};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.title_fragment);

        //option menu
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        gridHeroAdapter = new GridHeroAdapter(arr);

        recyclerView.setAdapter(gridHeroAdapter);
        recyclerView.setHasFixedSize(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Mode Grid");
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
            return true;
        } else if (itemId == R.id.option2){
            Intent intent = new Intent(this, CardView.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}