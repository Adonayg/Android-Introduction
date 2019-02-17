package com.adonayg.rocktimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar timerSeekBar;
    private TextView timerTextView;
    private Button controllerButton;
    private boolean counterIsActive = false;
    private CountDownTimer countDownTimer;

    public void updateTimer(int secondsLeft){
        int minutes = secondsLeft/ 60;
        int seconds = secondsLeft - minutes*60;

        String stringSeconds = Integer.toString(seconds);

        if (seconds < 10){
            stringSeconds = "0" + stringSeconds;
        }

        timerTextView.setText(Integer.toString(minutes) + " : " + stringSeconds);
    }


    public void controlTimer(View view){

        if(!counterIsActive) {
            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            controllerButton.setText("Reset");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0:00 ");
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.service);
                    mediaPlayer.start();
                }
            }.start();
        } else {
            timerTextView.setText("0:30");
            timerSeekBar.setProgress(30);
            countDownTimer.cancel();
            controllerButton.setText("Go!");
            timerSeekBar.setEnabled(true);
            counterIsActive = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timer_bar);
        timerTextView = findViewById(R.id.time_text);
        controllerButton = findViewById(R.id.controller_button);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
