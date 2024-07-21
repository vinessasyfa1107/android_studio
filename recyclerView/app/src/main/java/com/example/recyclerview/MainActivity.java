package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new ItemModel("Grilled Lamb","So whether you're a lamb lover, hater, or somewhere in between, it's worth trying your hand at lamb on the grill", R.drawable.food1));
        items.add(new ItemModel("Pizza Tomatoes","Dish of Italian origin consisting of a flattened disk of bread dough topped with some combination of olive oil, oregano, tomato, olives, mozzarella or other cheese, and many other ingredients, baked quickly", R.drawable.food2));
        items.add(new ItemModel("Beefsteak Barbeque","A beefsteak, often called just steak, is a flat cut of beef with parallel faces, usually cut perpendicular to the muscle fibers", R.drawable.food3));
        items.add(new ItemModel("San Francisco Grilled Sourdough Salad","Raw greens (such as lettuce) often combined with other vegetables and toppings and served especially with dressing", R.drawable.food4));
        items.add(new ItemModel("Gobi Manchurian","A sweet, tangy & slightly spicy sauce made with chilli sauce, vinegar, ginger & garlic", R.drawable.food5));
        items.add(new ItemModel("Biryani Rice","Simply put, biryani is a spiced mix of meat and rice, traditionally cooked over an open fire in a leather pot", R.drawable.food6));
        items.add(new ItemModel("Duck Rendang","A duck with tropical aromatics of the coconut, chiles, and spice", R.drawable.food7));
        items.add(new ItemModel("Party Chick Roasted","The chicken prepared as food by roasting whether in a home kitchen, over a fire, or with a rotisserie", R.drawable.food8));
        items.add(new ItemModel("Salmon Salad","This salmon salad recipe makes a main dish salad with chopped vegetables, flaky fish, and tangy citrus dressing", R.drawable.food9));
        items.add(new ItemModel("Greek Salad","A traditional Greek salad consists of sliced cucumbers, tomatoes, green bell pepper, red onion, olives, and feta cheese", R.drawable.food10));


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}