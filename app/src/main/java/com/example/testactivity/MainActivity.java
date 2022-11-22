package com.example.testactivity;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
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
        final String GREEN_HEX = "#2F8E3C";

        final Button button1 = findViewById(R.id.gridColor_00);
        final Button button2 = findViewById(R.id.gridColor_01);
        final Button button3 = findViewById(R.id.gridColor_02);
        final Button button4 = findViewById(R.id.gridColor_03);
        final Button button5 = findViewById(R.id.gridColor_04);
        final Button enterGuess = findViewById(R.id.enterGuess);

        final ScrollView nextGuesses = findViewById(R.id.nextGuesses);


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

        int i = 0;
        enterGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final String EMPTY = "Guess";

                EditText char0 =(EditText)findViewById(R.id.gridInput_00);
                EditText char1 =(EditText)findViewById(R.id.gridInput_01);
                EditText char2 =(EditText)findViewById(R.id.gridInput_02);
                EditText char3 =(EditText)findViewById(R.id.gridInput_03);
                EditText char4 =(EditText)findViewById(R.id.gridInput_04);

                String enteredWord = char0.getText().toString() + char1.getText().toString() + char2.getText().toString() +
                        char3.getText().toString() + char4.getText().toString();

                TextView prevGuess1 = (TextView)findViewById(R.id.prevGuess1);
                TextView prevGuess2 = (TextView)findViewById(R.id.prevGuess2);
                TextView prevGuess3 = (TextView)findViewById(R.id.prevGuess3);
                TextView prevGuess4 = (TextView)findViewById(R.id.prevGuess4);
                TextView prevGuess5 = (TextView)findViewById(R.id.prevGuess5);
                TextView prevGuess6 = (TextView)findViewById(R.id.prevGuess6);

                if (prevGuess1.getText().toString().contains(EMPTY)){
                    prevGuess1.setText("1. " + enteredWord);
                }else if (prevGuess2.getText().toString().contains(EMPTY)){
                    prevGuess2.setText("2. " + enteredWord);
                }else if (prevGuess3.getText().toString().contains(EMPTY)){
                    prevGuess3.setText("3. " + enteredWord);
                }else if (prevGuess4.getText().toString().contains(EMPTY)){
                    prevGuess4.setText("4. " + enteredWord);
                }else if (prevGuess5.getText().toString().contains(EMPTY)){
                    prevGuess5.setText("5. " + enteredWord);
                }else{
                    prevGuess6.setText("6. " + enteredWord);
                }

                char0.setText("");
                char0.clearFocus();
                char1.setText("");
                char1.clearFocus();
                char2.setText("");
                char2.clearFocus();
                char3.setText("");
                char3.clearFocus();
                char4.setText("");
                char4.clearFocus();

            }
        });
    }

    protected void onResume(Bundle savedInstanceState){

        final EditText gridInputLetter0 = findViewById(R.id.gridInput_00);
        final EditText gridInputLetter1 = findViewById(R.id.gridInput_01);
        final EditText gridInputLetter2 = findViewById(R.id.gridInput_02);
        final EditText gridInputLetter3 = findViewById(R.id.gridInput_03);
        final EditText gridInputLetter4 = findViewById(R.id.gridInput_04);

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        gridInputLetter0.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
                if (keycode == 66){
                    gridInputLetter0.clearFocus();
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                return false;
            }
        });
    }
}

