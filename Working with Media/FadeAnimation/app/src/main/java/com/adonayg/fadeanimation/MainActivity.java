package com.adonayg.fadeanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){
        ImageView rock = findViewById(R.id.rock_image);
        ImageView theRock = findViewById(R.id.the_rock_image);
        rock.animate().alpha(0f).setDuration(2000);
        theRock.animate().alpha(1f).setDuration(2000);
        theRock.bringToFront();
    }

    public void reverse(View view){
        ImageView rock = findViewById(R.id.rock_image);
        ImageView theRock = findViewById(R.id.the_rock_image);
        theRock.animate().alpha(0f).setDuration(2000);
        rock.animate().alpha(1f).setDuration(2000);
        rock.bringToFront();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
