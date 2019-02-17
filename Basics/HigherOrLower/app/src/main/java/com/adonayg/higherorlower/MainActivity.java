package com.adonayg.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int n;

    public void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void generateRandomNumber(){
        Random rand = new Random();
        n = rand.nextInt(20) + 1;
    }

    public void guess(View view){
        EditText guessEditText = findViewById(R.id.guess_number);

        int guessInt = Integer.parseInt(guessEditText.getText().toString());
        
        if(guessInt > n){
            makeToast("Lower!");
        } else if(guessInt < n) {
            makeToast("Higher");
        } else {
            makeToast("Correct! Try again!");
            generateRandomNumber();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }

}
