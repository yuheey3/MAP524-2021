package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> dataName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }


    public void displayUser(View view) {

        File file = getFileStreamPath("file.txt");
        if (file.exists()) {

            listView = (ListView) findViewById(R.id.listView);
            ArrayList<String> arrayList = new ArrayList<>();

            try {
                FileInputStream fis = openFileInput("file.txt");

                Scanner sc = new Scanner(fis);
                String line = "";

                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    arrayList.add(line);
                }
                sc.close();

                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

                listView.setAdapter(arrayAdapter);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(SecondActivity.this,"file not found", Toast.LENGTH_LONG).show();
        }
    }
}