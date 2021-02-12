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

        Dish d1 = new Dish("Pizza", R.mipmap.pizza);

        Dish.add(d1);

        Dish d2 = new Dish("Pasta", R.mipmap.pasta);

        Dish.add(d2);

        Dish d3 = new Dish("Hamburger", R.mipmap.hamburger);

        Dish.add(d3);

        Dish d4 = new Dish("Kimchi soup", R.mipmap.kimchi);

        Dish.add(d4);

        Dish d5 = new Dish("LA galbi", R.mipmap.galbi);

        Dish.add(d5);

        Dish d6 = new Dish("Curry", R.mipmap.curry);

        Dish.add(d6);

        Dish d7 = new Dish("Sushi", R.mipmap.sushi);

        Dish.add(d7);

        Dish d8 = new Dish("Pork cutlet", R.mipmap.tonkatsu);

        Dish.add(d8);

        return Dish;

    }

}