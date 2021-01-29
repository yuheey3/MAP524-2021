package com.example.lab2_yukiwaka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String optionSizeButton ="";
    String optionOrderTypeButton ="";
    String optionToppingButton = "";
    boolean pepperoniT = false;
    boolean greenPepperT = false;
    boolean onionsT = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dText = findViewById(R.id.displayText);
        TextView pText = findViewById(R.id.displayText2);
        dText.setText("");
        pText.setText("");
    }

    public void radioButtonChecked(View view) {
        RadioButton radioButton = (RadioButton)view;
        int id = view.getId();
        switch(id){

            case R.id.large :
                if(radioButton.isChecked()){
                    optionSizeButton = "Large";
                }
                break;
            case R.id.medium :
                if(radioButton.isChecked()){
                    optionSizeButton = "Medium";
                }
                break;
            case R.id.small :
                if(radioButton.isChecked()){
                    optionSizeButton = "Small";
                }
        }

    }
    public void checkBoxSelected(View view){

        CheckBox checkBox = (CheckBox)view;
        int id = checkBox.getId();
        switch(id){
            case R.id.pepperoni :
                if(checkBox.isChecked()){

                    pepperoniT = true;
                }else{

                    pepperoniT = false;
                }
                break;
            case R.id.greenPepper :
                if(checkBox.isChecked()){

                    greenPepperT = true;
                }else{

                    greenPepperT = false;
                }
                break;
            case R.id.onions :
                if(checkBox.isChecked()){

                    onionsT = true;
                }else{

                    onionsT = false;
                }
                break;
        }
        displaySelection();
    }

    void displaySelection() {
        int count = 0;
        String[] s = new String[3];

        if (pepperoniT) {
            s[count] = "pepperoni ";
            count++;
        }
        if (greenPepperT) {
            s[count] = "GreenPepper ";
            count++;
        }
        if (onionsT) {
            s[count] = "Onions";
            count++;
        }
        if (count == 1)
            optionToppingButton = s[0];
        else if (count == 2)
            optionToppingButton = s[0] + "and " + s[1];
        else if (count == 3)
            optionToppingButton = s[0] + ", " +  s[1] + "and " + s[2];
    }

    public void orderTypeChecked(View view) {
        RadioButton radioButton = (RadioButton)view;
        int id = view.getId();
        switch(id){

            case R.id.pickUp :
                if(radioButton.isChecked()){
                    optionOrderTypeButton = "PickUp";
                }
                break;
            case R.id.delivery :
                if(radioButton.isChecked()){
                    optionOrderTypeButton = "Delivery";
                }
                break;

        }
    }

    public void placeOrder(View view){
        //display
        TextView dText = findViewById(R.id.displayText);
        TextView pText = findViewById(R.id.displayText2);

            if(optionSizeButton.isEmpty()&& optionOrderTypeButton.isEmpty())
                dText.setText("Please select Size and Order type");
            else if(optionSizeButton.isEmpty())
                dText.setText("Please select Size type");
            else if(optionOrderTypeButton.isEmpty())
                dText.setText("Please select Order Type");
            else {
                dText.setText(optionSizeButton + " Pizza with " + optionToppingButton);
                pText.setText("Order Type " + optionOrderTypeButton);
            }
    }
}