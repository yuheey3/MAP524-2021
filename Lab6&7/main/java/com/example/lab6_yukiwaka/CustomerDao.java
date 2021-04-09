package com.example.lab6_yukiwaka;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert
    public void submitFeedback(Customer c);

    //delete
    @Query("DELETE FROM customers WHERE id=:id")
    public void deleteFeedback(int id);

    //update
    @Query("UPDATE customers SET customer_name = :name, customer_rating = :rating, customer_comment =:comment  WHERE id =:id")
    void updateFeedback(String name, String rating, String comment, int id);

    //get all
    @Query("select * from customers")
    public List<Customer> getAll();

    @Query("SELECT customer_name FROM customers WHERE id=:id")
    String getName(int id);

    @Query("SELECT customer_rating FROM customers WHERE id=:id")
    String getRating(int id);

    @Query("SELECT customer_comment FROM customers WHERE id=:id")
    String getComment(int id);
}