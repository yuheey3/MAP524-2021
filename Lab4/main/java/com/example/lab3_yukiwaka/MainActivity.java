//Name: Yuki Waka
//Date. Feb.12.2021
package com.example.lab3_yukiwaka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Dish> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        list = getData();
        MyAdapter adapter = new MyAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    public List<Dish> getData() {
        List<Dish> Dish = new ArrayList<>();

        Dish d1 = new Dish("Pizza", R.drawable.pizza);

        Dish.add(d1);

        Dish d2 = new Dish("Pasta", R.drawable.pasta);

        Dish.add(d2);

        Dish d3 = new Dish("Hamburger", R.drawable.hamburger);

        Dish.add(d3);

        Dish d4 = new Dish("Kimchi soup", R.drawable.kimchi);

        Dish.add(d4);

        Dish d5 = new Dish("LA galbi", R.drawable.galbi);

        Dish.add(d5);

        Dish d6 = new Dish("Curry", R.drawable.curry);

        Dish.add(d6);

        Dish d7 = new Dish("Sushi", R.drawable.sushi);

        Dish.add(d7);

        Dish d8 = new Dish("Pork cutlet", R.drawable.tonkatsu);

        Dish.add(d8);

        return Dish;

    }

}