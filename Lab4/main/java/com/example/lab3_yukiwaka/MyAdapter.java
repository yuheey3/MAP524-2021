//Name: Yuki Waka
//Date. Feb.12.2021
package com.example.lab3_yukiwaka;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

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

              //  Toast.makeText(view.getContext(), name2 + ": " + rating, Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder((v.getRootView().getContext()));

                builder.setTitle("Alert")
                        .setMessage("Display info of selected dish ")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,int i ) {
                              //  Toast.makeText(v.getRootView().getContext(), "OK", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(v.getRootView().getContext(), DetailActivity.class);

                                intent.putExtra("dish", name2);
                                intent.putExtra("rating", rating);

                                BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
                                Bitmap bitmap = drawable.getBitmap();
                                intent.putExtra("BitmapImage", bitmap);

                                v.getRootView().getContext().startActivity(intent);


                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(v.getRootView().getContext(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();
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
