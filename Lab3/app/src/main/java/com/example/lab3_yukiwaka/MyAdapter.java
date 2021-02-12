//Name: Yuki Waka
//Date. Feb.12.2021
package com.example.lab3_yukiwaka;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Dish> list;

    MyAdapter( List<Dish> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        ImageView image = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.dnameTv);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);

        //when click the image
        image.setOnClickListener(new View.OnClickListener() {
               @Override
             public void onClick(View v) {
               String name2 = name.getText().toString();
               String rating = String.valueOf(ratingBar.getRating());

                Log.d("myTag", name2);
                Log.d("myTag", String.valueOf(ratingBar.getRating()));

                Toast.makeText(view.getContext(), name2 + ": " + rating, Toast.LENGTH_LONG).show();
             }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.dnameTv);
        }
        }
    }
