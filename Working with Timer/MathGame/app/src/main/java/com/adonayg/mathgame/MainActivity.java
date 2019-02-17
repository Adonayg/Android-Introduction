package com.adonayg.mathgame;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button playAgainButton;
    Button playButton;
    Button optionButton0;
    Button optionButton1;
    Button optionButton2;
    Button optionButton3;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    TextView resultTextView;
    TextView scoreTextView;
    TextView sumTextView;
    TextView timerTextView;
    ProgressBar progressBar;
    ConstraintLayout gameLayout;

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        progressBar.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        timerTextView.setText("30s");
        scoreTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        optionButton0.setEnabled(true);
        optionButton1.setEnabled(true);
        optionButton2.setEnabled(true);
        optionButton3.setEnabled(true);
        generateQuestion();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {

                progressBar.setVisibility(View.INVISIBLE);
                timerTextView.setText("0s");
                optionButton0.setEnabled(false);
                optionButton1.setEnabled(false);
                optionButton2.setEnabled(false);
                optionButton3.setEnabled(false);
                sumTextView.setVisibility(View.INVISIBLE);
                if (score > 20 && numberOfQuestions < score + 3){
                    resultTextView.setText("Great! You Scored " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                } else if (score > 10 && numberOfQuestions < score + 3){
                    resultTextView.setText("Good! You Scored " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                } else {
                    resultTextView.setTextColor(Color.rgb(220,20,60));
                    resultTextView.setText("You Scored " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                }
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void generateQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(13);
        int b = rand.nextInt(13);
        sumTextView.setText(Integer.toString(a) + " x " + Integer.toString(b) + " = ?" );
        locationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();
        int incorrectAnswer;

        for (int i = 0; i<4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(a*b);
            } else {
                incorrectAnswer = rand.nextInt(145);
                while(incorrectAnswer == a*b) {
                    incorrectAnswer = rand.nextInt(145);
                }
                answers.add(incorrectAnswer);
            }
        }

        optionButton0.setText(Integer.toString(answers.get(0)));
        optionButton1.setText(Integer.toString(answers.get(1)));
        optionButton2.setText(Integer.toString(answers.get(2)));
        optionButton3.setText(Integer.toString(answers.get(3)));
    }


    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            resultTextView.setTextColor(Color.rgb(0,100,0));
            resultTextView.setText("Correct!");
        } else {
            resultTextView.setTextColor(Color.rgb(220,20,60));
            resultTextView.setText("Wrong!");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void start(View view){
        playButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.play_again_button));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sum_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        scoreTextView = findViewById(R.id.score_text_view);
        timerTextView = findViewById(R.id.timer_text_view);

        playButton = findViewById(R.id.play_button);
        optionButton0 = findViewById(R.id.option_button0);
        optionButton1 = findViewById(R.id.option_button1);
        optionButton2 = findViewById(R.id.option_button2);
        optionButton3 = findViewById(R.id.option_button3);
        progressBar = findViewById(R.id.progressBar);
        playAgainButton = findViewById(R.id.play_again_button);
        gameLayout = findViewById(R.id.game_layout);
    }
}
