package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> selectedFood = new ArrayList<>();
    String selectedDrink;
    String totalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        //get ref to the intent
        Intent intent = getIntent();

        //get data
        selectedDrink = intent.getStringExtra("drink");
        selectedFood= intent.getStringArrayListExtra("food");
        totalPrice = intent.getStringExtra("total");

        TextView dText = findViewById(R.id.total);
        dText.setText(totalPrice);

        int count = 0;
        count = selectedFood.size();

        listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i=0; i<count;i++){
            arrayList.add(selectedFood.get(i));
        }
        arrayList.add(selectedDrink);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

    }

    public void editOrder(View view){
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
    public void submit(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        }
    }

