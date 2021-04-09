package com.example.lab6_yukiwaka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        database = MyDatabase.getInstance(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Customer> customerList = database.customerDao().getAll();

        MyAdapter adapter = new MyAdapter(customerList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
