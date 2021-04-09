package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    final String FILE_NAME ="file.txt";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.dataEt);
    }


    public void addUserToFile(View view) {

        writeFileToInternalStorage();
        editText.setText("");

    }

    private void writeFileToInternalStorage() {
        String data = editText.getText().toString();

        if(data.isEmpty()){
            Toast.makeText(MainActivity.this,"Enter your name", Toast.LENGTH_LONG).show();

        }else{

        try {
            FileOutputStream fos = openFileOutput(FILE_NAME , Context.MODE_APPEND);
            fos.write(data.getBytes());
            fos.write("\n".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("file  error", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu , menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if( id == R.id.page2){

            Intent i = new Intent(this, SecondActivity.class);

            startActivity(i);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteFile(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Deleting Users_List_FILE")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure you want to delete this File?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteFile("file.txt");
                        Toast.makeText(MainActivity.this,"Deleted", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}