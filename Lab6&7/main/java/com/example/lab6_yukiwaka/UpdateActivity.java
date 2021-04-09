package com.example.lab6_yukiwaka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    int feedbackId;
    TextView name;
    TextView comment;
    RatingBar rating;
    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        database = MyDatabase.getInstance(this);

        name = findViewById(R.id.namePt);
        comment = findViewById(R.id.feedbackPt);
        rating = findViewById(R.id.ratingBar);

        Intent intent = getIntent();

        //get data
        feedbackId = intent.getIntExtra("feedbackId", 0);

        String nameData = database.customerDao().getName(feedbackId);
        String RatingData = database.customerDao().getRating(feedbackId);
        String commentData = database.customerDao().getComment(feedbackId);

        name.setText(nameData);
        comment.setText(commentData);
        rating.setRating(Float.parseFloat(RatingData));
    }

    public void delete(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder((v.getRootView().getContext()));
        builder.setTitle("Delete")
                .setMessage("Do you want to delete '" + name.getText().toString() + "' 's feedback?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        database.customerDao().deleteFeedback(feedbackId);
                        Toast.makeText(v.getRootView().getContext(), "deleted!", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(v.getRootView().getContext(), MainActivity.class);
                        startActivity(intent);

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(v.getRootView().getContext(), "Canceled", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    public void update(View v) {
        String originalName = database.customerDao().getName(feedbackId);
        AlertDialog.Builder builder = new AlertDialog.Builder((v.getRootView().getContext()));
        builder.setTitle("Update")
                .setMessage("Do you want to update '" + originalName + "' 's feedback?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String newName = name.getText().toString();
                        String newRating = String.valueOf(rating.getRating());
                        String newComment = comment.getText().toString();

                        database.customerDao().updateFeedback(newName, newRating, newComment, feedbackId);
                        Toast.makeText(v.getRootView().getContext(), "updated!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(v.getRootView().getContext(), MainActivity.class);
                        startActivity(intent);

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(v.getRootView().getContext(), "Canceled", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }
}