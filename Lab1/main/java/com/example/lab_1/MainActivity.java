//Yuki Waka
//Jan.21.2021
//Lab1
package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayName(View v){
        //get first name and last name
        EditText fNameEt = findViewById(R.id.fNameEt);
        EditText lNameEt = findViewById(R.id.lNameEt);
        String  fNameStr = fNameEt.getText().toString();
        String  lNameStr = lNameEt.getText().toString();

        //display
        TextView dText = findViewById(R.id.displayText);

        //if first name and last name are empty
        if(fNameStr.isEmpty() && lNameStr.isEmpty()){

            dText.setText("Hi There");
        }else{
            dText.setText("Hi "+fNameStr+" "+lNameStr);
        }
    }
}