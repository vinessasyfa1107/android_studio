package com.example.layoutlist_crud;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    MyPlayer myPlayer;
    PlayerAdapter adapter;
    RecyclerView rv_player;
    TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_player = findViewById(R.id.rv_player);
        myPlayer = new MyPlayer(this);
        rv_player.setHasFixedSize(true);
        rv_player.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerAdapter(myPlayer);
        rv_player.setAdapter(adapter);
        getDataPlayer();
    }

    public void getDataPlayer() {
        myPlayer.getInstance().getPlayer().enqueue(new Callback<PlayerResponse<PlayerItem>>() {
            @Override
            public void onResponse(Call<PlayerResponse<PlayerItem>> call, Response<PlayerResponse<PlayerItem>> response) {
                PlayerResponse<PlayerItem> resp = response.body();
                if (resp.getResult() != null && resp.getResult().size() > 0) {
                    adapter = new PlayerAdapter(resp.getResult(), MainActivity.this);
                    rv_player.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PlayerResponse<PlayerItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}