package com.adonayg.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertToBirr(View view) {
        EditText poundAmount = findViewById(R.id.pound_amount);

        Double poundAmountDouble = Double.parseDouble(poundAmount.getText().toString());
        Double birrAmount = poundAmountDouble*37;

        Toast.makeText(this, String.format("%.2f",birrAmount) + " birr", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
