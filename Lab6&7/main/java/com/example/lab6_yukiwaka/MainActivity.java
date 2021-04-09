package com.example.lab6_yukiwaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyDatabase database;
    EditText cusNameEt;
    RatingBar cusRating;
    EditText cusCommentEt;
    int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = MyDatabase.getInstance(this);
        cusNameEt = findViewById(R.id.nameEt);
        cusRating = findViewById(R.id.ratingBarEt);
        cusCommentEt = findViewById(R.id.commentEt);

    }

    public void submitFeedback(View v) {
        List<Customer> customerList = database.customerDao().getAll();

        String name = cusNameEt.getText().toString();
        String rating = String.valueOf(cusRating.getRating());
        String comment = cusCommentEt.getText().toString();

        //validation
        if (name.isEmpty())
            Toast.makeText(this, "Please enter the name", Toast.LENGTH_SHORT).show();
        else if (comment.isEmpty())
            Toast.makeText(this, "Please write the comment", Toast.LENGTH_SHORT).show();

        else {
            //find id position
            for (Customer customer : customerList) {
                if (id == customer.id) {
                    id++;
                }
            }

            Customer customer = new Customer(id, name, rating, comment);

            //using non-UI-thread for db query
            new Thread(new Runnable() {
                @Override
                public void run() {
                    database.customerDao().submitFeedback(customer);
                }
            }).start();

            cusNameEt.setText("");
            cusRating.setRating(0.0f);
            cusCommentEt.setText("");

            Toast.makeText(this, "Submitted!", Toast.LENGTH_SHORT).show();
        }
    }


    public void viewAllFeedback(View v) {

        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);

    }
}