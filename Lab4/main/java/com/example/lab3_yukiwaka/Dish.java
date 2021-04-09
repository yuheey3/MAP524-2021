//Name: Yuki Waka
//Date. Feb.12.2021
package com.example.lab3_yukiwaka;

import android.widget.RatingBar;

public class Dish {
    //fields
    private String name;
    private int image;

    public Dish( String name, int image){

        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

}