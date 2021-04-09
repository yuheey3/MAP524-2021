package com.example.lab3_yukiwaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    String selectedDish;
    String selectedRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView dNameText = findViewById(R.id.displayNameTv);
        TextView dRatingText = findViewById(R.id.displayRatingTv);
        dNameText.setText("");
        dRatingText.setText("");

        Intent intent = getIntent();

        //get data
        selectedDish = intent.getStringExtra("dish");
        selectedRating= intent.getStringExtra("rating");
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");


        TextView dishNameText = findViewById(R.id.displayNameTv);
        dishNameText.setText(selectedDish);
        TextView ratingText = findViewById(R.id.displayRatingTv);
        ratingText.setText("Rating: "+ selectedRating);
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        image.setImageBitmap(bitmap);
    }
}