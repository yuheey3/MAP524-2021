package com.example.lab6_yukiwaka;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "customers")
public class Customer {
    @PrimaryKey
    int id;
    @ColumnInfo(name = "customer_name")
    String name;
    @ColumnInfo(name = "customer_rating")
    String rating;
    @ColumnInfo(name = "customer_comment")
    String comment;

    public Customer(int id, String name, String rating, String comment) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

}
