package com.example.testactivity;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.res.ColorStateList;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    int toggle1;
    int toggle2;
    int toggle3;
    int toggle4;
    int toggle5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String ORANGE_HEX = "#FFA500";
        final String GRAY_HEX = "#D3D3D3";
        final String GREEN_HEX = "#00FF00";

        final EditText userInput_00 = findViewById(R.id.gridInput_00);
        final Button button1 = findViewById(R.id.gridColor_00);
        final Button button2 = findViewById(R.id.gridColor_01);
        final Button button3 = findViewById(R.id.gridColor_02);
        final Button button4 = findViewById(R.id.gridColor_03);
        final Button button5 = findViewById(R.id.gridColor_04);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toggle1 % 3 == 0){ // if toggle = 0 -> change to orange
                    button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(ORANGE_HEX)));
                }
                if(toggle1 % 3 == 1){ // if toggle = 0 -> change to orange
                    button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(toggle1 % 3 == 2){ // if toggle = 0 -> change to orange
                    button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                toggle1 += 1;
            }
        });


        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toggle2 % 3 == 0){ // if toggle = 0 -> change to orange
                    button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(ORANGE_HEX)));
                }
                if(toggle2 % 3 == 1){ // if toggle = 0 -> change to orange
                    button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(toggle2 % 3 == 2){ // if toggle = 0 -> change to orange
                    button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                toggle2 += 1;
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toggle3 % 3 == 0){ // if toggle = 0 -> change to orange
                    button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(ORANGE_HEX)));
                }
                if(toggle3 % 3 == 1){ // if toggle = 0 -> change to orange
                    button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(toggle3 % 3 == 2){ // if toggle = 0 -> change to orange
                    button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                toggle3 += 1;
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toggle4 % 3 == 0){ // if toggle = 0 -> change to orange
                    button4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(ORANGE_HEX)));
                }
                if(toggle4 % 3 == 1){ // if toggle = 0 -> change to orange
                    button4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(toggle4 % 3 == 2){ // if toggle = 0 -> change to orange
                    button4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                toggle4 += 1;
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toggle5 % 3 == 0){ // if toggle = 0 -> change to orange
                    button5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(ORANGE_HEX)));
                }
                if(toggle5 % 3 == 1){ // if toggle = 0 -> change to orange
                    button5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(toggle5 % 3 == 2){ // if toggle = 0 -> change to orange
                    button5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                toggle5 += 1;
            }
        });

        final ScrollView nextGuesses = findViewById(R.id.nextGuesses);
    }
}

