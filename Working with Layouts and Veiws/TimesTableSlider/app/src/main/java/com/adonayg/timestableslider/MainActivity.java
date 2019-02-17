package com.adonayg.timestableslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView numberList;

    public void generateTimesTable(int timesTable) {
        List<String> timeTableContent = new ArrayList<String>();

        for (int i=1; i <= 10; i++) {
            timeTableContent.add(Integer.toString(i*timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeTableContent);
        numberList.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar multiplierBar = findViewById(R.id.multiplier_bar);
        numberList = findViewById(R.id.number_list);

        multiplierBar.setMax(20);
        multiplierBar.setProgress(1);

        multiplierBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min){
                    timesTable = min;
                    multiplierBar.setProgress(min);
                } else {
                    timesTable = progress;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(1);
    }
}
