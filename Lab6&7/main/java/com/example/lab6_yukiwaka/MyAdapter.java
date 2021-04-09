package com.example.lab6_yukiwaka;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Customer> CustomerLists;

    MyAdapter(List<Customer> CustomerLists) {
        this.CustomerLists = CustomerLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.feedback_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer list = CustomerLists.get(position);
        holder.name.setText(list.getName());
        holder.rating.setRating(Float.parseFloat(list.getRating()));
        holder.comment.setText(list.getComment());
        holder.feedId.setText(String.valueOf(list.getId()));

    }

    @Override
    public int getItemCount() {
        return CustomerLists.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RatingBar rating;
        TextView comment;
        TextView feedId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTv);
            rating = itemView.findViewById(R.id.ratingTv);
            comment = itemView.findViewById(R.id.commentTv);
            feedId = itemView.findViewById(R.id.feedbackId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder((v.getRootView().getContext()));
                    builder.setTitle("Updating Feedback")
                            .setMessage("Do you want to update '" + name.getText().toString() + "' 's feedback?")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent intent = new Intent(v.getRootView().getContext(), UpdateActivity.class);

                                    intent.putExtra("feedbackId", Integer.parseInt(feedId.getText().toString()));

                                    v.getRootView().getContext().startActivity(intent);

                                }
                            }).setNegativeButton("Canceled", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(v.getRootView().getContext(), "Cancel", Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();
                }

            });

        }
    }
}
