package com.example.testactivity;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.res.ColorStateList;
import android.graphics.Color;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    int colorNum0;
    int colorNum1;
    int colorNum2;
    int colorNum3;
    int colorNum4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final String YELLOW_HEX = "#FFA500";
        final String GRAY_HEX = "#D3D3D3";
        final String GREEN_HEX = "#2F8E3C";

        final Button colorButton0 = findViewById(R.id.gridColor_00);
        final Button colorButton1 = findViewById(R.id.gridColor_01);
        final Button colorButton2 = findViewById(R.id.gridColor_02);
        final Button colorButton3 = findViewById(R.id.gridColor_03);
        final Button colorButton4 = findViewById(R.id.gridColor_04);
        final EditText textInput0 = findViewById(R.id.gridInput_00);
        final EditText textInput1 = findViewById(R.id.gridInput_01);
        final EditText textInput2 = findViewById(R.id.gridInput_02);
        final EditText textInput3 = findViewById(R.id.gridInput_03);
        final EditText textInput4 = findViewById(R.id.gridInput_04);
        final Button enterGuess = findViewById(R.id.enterGuess);

        //final ScrollView nextGuesses = findViewById(R.id.nextGuesses);


        inputWrapping(textInput0, textInput1, textInput2, textInput3, textInput4);

        colorButton0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(colorNum0 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum0 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(colorNum0 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                colorNum0 += 1;
            }
        });






        colorButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(colorNum1 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum1 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(colorNum1 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                colorNum1 += 1;
            }
        });

        colorButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(colorNum2 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum2 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(colorNum2 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                colorNum2 += 1;
            }
        });

        colorButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(colorNum3 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum3 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(colorNum3 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                colorNum3 += 1;
            }
        });

        colorButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(colorNum4 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum4 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                if(colorNum4 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }

                colorNum4 += 1;
            }
        });

        int i = 0;
        enterGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final String EMPTY = "Guess";

                //get the characters from the input grid
                final EditText char0 = (EditText) findViewById(R.id.gridInput_00);
                final EditText char1 = (EditText) findViewById(R.id.gridInput_01);
                final EditText char2 = (EditText) findViewById(R.id.gridInput_02);
                final EditText char3 = (EditText) findViewById(R.id.gridInput_03);
                final EditText char4 = (EditText) findViewById(R.id.gridInput_04);

                //concatenate letters into string
                String enteredWord = char0.getText().toString() + char1.getText().toString() +
                        char2.getText().toString() + char3.getText().toString() + char4.getText().toString();

                //check that word is 5 chars long, if not, display popup
                if (enteredWord.length() < 5) {

                    NotEnoughCharsDialogue popup = new NotEnoughCharsDialogue();
                    popup.show(getSupportFragmentManager(), null);

                }else{

                    //get the colors from the buttons
                    String colors = "";


                    // this will not stay here. it's just a skeleton for updating previous guesses
                    // interfact to pass data to jamie's algo will go here
                    TextView prevGuess1 = (TextView) findViewById(R.id.prevGuess1);
                    TextView prevGuess2 = (TextView) findViewById(R.id.prevGuess2);
                    TextView prevGuess3 = (TextView) findViewById(R.id.prevGuess3);
                    TextView prevGuess4 = (TextView) findViewById(R.id.prevGuess4);
                    TextView prevGuess5 = (TextView) findViewById(R.id.prevGuess5);
                    TextView prevGuess6 = (TextView) findViewById(R.id.prevGuess6);

                    if (prevGuess1.getText().toString().contains(EMPTY)) {
                        prevGuess1.setText("1. " + enteredWord);
                    } else if (prevGuess2.getText().toString().contains(EMPTY)) {
                        prevGuess2.setText("2. " + enteredWord);
                    } else if (prevGuess3.getText().toString().contains(EMPTY)) {
                        prevGuess3.setText("3. " + enteredWord);
                    } else if (prevGuess4.getText().toString().contains(EMPTY)) {
                        prevGuess4.setText("4. " + enteredWord);
                    } else if (prevGuess5.getText().toString().contains(EMPTY)) {
                        prevGuess5.setText("5. " + enteredWord);
                    } else {
                        prevGuess6.setText("6. " + enteredWord);
                    }
                    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                    //clear characters and reset colors
                    char0.setText("");
                    char0.clearFocus();
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));

                    char1.setText("");
                    char1.clearFocus();
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));

                    char2.setText("");
                    char2.clearFocus();
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));

                    char3.setText("");
                    char3.clearFocus();
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));

                    char4.setText("");
                    char4.clearFocus();
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });
    }

    public void inputWrapping(EditText textInput0,EditText textInput1,EditText textInput2,EditText textInput3,EditText textInput4){

        textInput0.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    textInput1.requestFocus();
                }
            }
        });
        textInput1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    textInput2.requestFocus();
                }
            }
        });
        textInput2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    textInput3.requestFocus();
                }
            }
        });
        textInput3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().length() == 1) {
                    textInput4.requestFocus();
                }
            }
        });
        textInput4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().length() == 1) {

                }
            }
        });
        textInput0.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(textInput0.getText().toString() .length() == 0 && keyCode == event.KEYCODE_DEL)
                {
                    textInput0.setText("");

                }
                return false;
            }
        });
        textInput1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(textInput1.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL)
                {
                    textInput1.setText("");
                    textInput1.clearFocus();
                    textInput0.requestFocus();
                    //textInput0.setText("");
                }
                return false;
            }
        });

        textInput2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(textInput2.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL)
                {
                    textInput2.setText("");
                    textInput2.clearFocus();
                    textInput1.requestFocus();
                    //textInput1.setText("");
                }
                return false;
            }
        });
        textInput3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(textInput3.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL)
                {
                    textInput3.setText("");
                    textInput3.clearFocus();
                    textInput2.requestFocus();
                    //textInput2.setText("");
                }
                return false;
            }
        });
        textInput4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(textInput4.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL)
                {
                    textInput4.setText("");
                    textInput4.clearFocus();
                    textInput3.requestFocus();
                   // textInput3.setText("");
                }
                return false;
            }
        });

    }
}

