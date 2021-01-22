package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt;
    private EditText passwordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.editTextTextPersonName);
        passwordEt =findViewById(R.id.editTextTextPassword);
    }

    public void displayInfo(View view) {
        String name = nameEt.getText().toString();
        String pw = passwordEt.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
        Toast.makeText(this, pw, Toast.LENGTH_LONG).show();
        Log.d("TAG",name);
        Log.d("TAG",pw);
    }
}