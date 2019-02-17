package com.adonayg.numberchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void checkNumber(View view){

        EditText userNumber = findViewById(R.id.user_number);
        boolean numeric = true;
        Number myNumber = new Number();

        try {
            int number = Integer.parseInt(userNumber.getText().toString());
        } catch (NumberFormatException e) {
            numeric = false;
        }

        if(numeric){
            myNumber.setNumber(Integer.parseInt(userNumber.getText().toString()));

            if (myNumber.isTriangular()){
                if(myNumber.isSquare()){
                    if(myNumber.isCube()){
                        makeToast(userNumber,"is a Triangular, Square and Cube Number!");
                    } else {
                        makeToast(userNumber, "is a Triangular and Square Number!");
                    }

                } else if(myNumber.isCube()){
                    makeToast(userNumber, "is a Triangular and Cube Number!");
                } else {
                    makeToast(userNumber, "is a Triangular Number!");
                }
            } else if(myNumber.isSquare()){
                if(myNumber.isCube()) {
                    makeToast(userNumber, "is a Square and Cube Number!");
                } else {
                    makeToast(userNumber, "is a Square Number!");
                }
            } else if(myNumber.isCube()){
                makeToast(userNumber, "is a Cube Number");
            } else {
                makeToast(userNumber, "is not a Triangular, Square or Cube Number");
            }
        } else {
            makeToast(userNumber, "is a letter please Enter a number");
    }
    }

    public void makeToast(EditText userNumber, String str){
        Toast.makeText(this, userNumber.getText().toString() + " " + str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
