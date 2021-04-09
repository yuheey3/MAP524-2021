package com.example.assignment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    int RequestCode = 12;
    String selectedDrink = "";
    ArrayList<String> selectedFood = new ArrayList<>();
    double allTotal = 0;
    double foodTotal = 0;
    double drinkTotal = 0;
    boolean fishT = false;
    boolean chickenT = false;
    boolean roastedVeggiesT = false;
    boolean grilledSteakT = false;
    boolean teaT = false;
    boolean coffeeT = false;
    boolean orangeJuiceT = false;
    boolean appleJuiceT = false;
    boolean drinkIsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        TextView dText = findViewById(R.id.displayText);
        dText.setText("");

    }

    public void checkBoxSelected(View view){

        CheckBox checkBox = (CheckBox)view;
        int id = checkBox.getId();
        switch(id){
            case R.id.fish :
                if(checkBox.isChecked()){

                    fishT = true;
                }else{

                    fishT = false;
                }
                break;
            case R.id.chicken :
                if(checkBox.isChecked()){

                    chickenT = true;
                }else{

                    chickenT = false;
                }
                break;
            case R.id.roastedVeggies :
                if(checkBox.isChecked()){

                    roastedVeggiesT = true;
                }else{

                    roastedVeggiesT = false;
                }
                break;
            case R.id.grilledSteak :
                if(checkBox.isChecked()){

                    grilledSteakT = true;
                }else{

                    grilledSteakT = false;
                }
                break;
        }

    }

    void displaySelection() {

        if (fishT) {
            selectedFood.add("Fish");
            foodTotal += 12;

        }
        if (chickenT) {
            selectedFood.add("Chicken");
            foodTotal += 11;

        }
        if (roastedVeggiesT) {
            selectedFood.add("Roasted Veggies");
            foodTotal += 10;

        }
        if (grilledSteakT) {
            selectedFood.add("Grilled Steak");
            foodTotal += 15;

        }

    }

    public void drinkTypeChecked(View view){
        RadioButton radioButton = (RadioButton)view;
        int id = view.getId();
        switch(id){

            case R.id.tea :
                if(radioButton.isChecked()){
                    teaT = true;
                    drinkIsChecked = true;
                }
                break;
            case R.id.coffee :
                if(radioButton.isChecked()){
                    coffeeT = true;
                    drinkIsChecked = true;
                }
                break;
            case R.id.orangeJuice :
                if(radioButton.isChecked()){
                    orangeJuiceT = true;
                    drinkIsChecked = true;
                }
                break;
            case R.id.appleJuice :
                if(radioButton.isChecked()){
                    appleJuiceT = true;
                    drinkIsChecked = true;
                }
                break;

        }

    }
    void displaySelection2() {

        if (teaT) {
            selectedDrink = "Tea";
            drinkTotal += 1.7;

        }
        if (coffeeT) {
            selectedDrink = "Coffee";
            drinkTotal += 1.8;

        }
        if (orangeJuiceT) {
            selectedDrink = "Orange Juice";
            drinkTotal += 2;

        }
        if (appleJuiceT) {
            selectedDrink = "Apple Juice";
            drinkTotal += 3;

        }
    }

    public void checkOutOrder(View view){
        selectedFood.clear();
        allTotal = 0;
        if(drinkIsChecked){
            drinkTotal = 0;
        }

        displaySelection();
        displaySelection2();

        allTotal = foodTotal + drinkTotal;

        if(selectedFood.isEmpty() && selectedDrink.isEmpty())
            Toast.makeText(this, "Please select your food and drink", Toast.LENGTH_LONG).show();
        else if(selectedFood.isEmpty())
            Toast.makeText(this, "Please select your food", Toast.LENGTH_LONG).show();
        else if(selectedDrink.isEmpty())
            Toast.makeText(this, "Please select a drink", Toast.LENGTH_LONG).show();
        else {
            Intent intent = new Intent(this, SummaryActivity.class);

            intent.putExtra("drink", selectedDrink);
            intent.putStringArrayListExtra("food", selectedFood);
            intent.putExtra("total", String.valueOf(allTotal));

            int RequestCode = 12;
            startActivityForResult(intent, RequestCode);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(RequestCode == requestCode){
            if(resultCode == RESULT_OK){
                teaT = false;
                coffeeT = false;
                orangeJuiceT = false;
                appleJuiceT = false;
                foodTotal = 0;
                drinkIsChecked = false;

            }else{
                Toast.makeText(this, "no result", Toast.LENGTH_SHORT).show();
            }
        }

    }
}