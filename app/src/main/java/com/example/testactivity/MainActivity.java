package com.example.testactivity;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.res.ColorStateList;
import android.graphics.Color;
import androidx.fragment.app.DialogFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
        //implements ConfirmStartOverDialogue.ConfirmStartOveDialogListener{

    Integer colorNumTouch = 0;

    Integer currGuessNum = 0;

    Integer colorNum0 = 0;
    Integer colorNum1 = 0;
    Integer colorNum2 = 0;
    Integer colorNum3 = 0;
    Integer colorNum4 = 0;

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    final String YELLOW_HEX = "#FFA500";
    final String GRAY_HEX = "#D3D3D3";
    final String GREEN_HEX = "#2F8E3C";
    final String BLACK_HEX = "#000000";

    final String EMPTY = "Guess";

    /*
    EditText textInput0 = null;
    EditText textInput1 = null;
    EditText textInput2 = null;
    EditText textInput3 = null;
    EditText textInput4 = null;

    //Previous guess inits
    TextView prevGuess1 = null;
    TextView prevGuess2 = null;
    TextView prevGuess3 = null;
    TextView prevGuess4 = null;
    TextView prevGuess5 = null;
    TextView prevGuess6 = null;

    LinearLayout myRoot = null;

    Button enterGuess = null;
    Button startOverButton = null;
    Button helpButton = null;

     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Guess> guessObjects = new ArrayList<Guess>();

        ArrayList<String> wordList = loadStrings();
        Log.d("words: " , ""+wordList.size());

        final EditText textInput0 = findViewById(R.id.gridInput_00);
        final EditText textInput1 = findViewById(R.id.gridInput_01);
        final EditText textInput2 = findViewById(R.id.gridInput_02);
        final EditText textInput3 = findViewById(R.id.gridInput_03);
        final EditText textInput4 = findViewById(R.id.gridInput_04);

        //Previous guess inits
        TextView prevGuess1 = (TextView) findViewById(R.id.prevGuess1);
        TextView prevGuess2 = (TextView) findViewById(R.id.prevGuess2);
        TextView prevGuess3 = (TextView) findViewById(R.id.prevGuess3);
        TextView prevGuess4 = (TextView) findViewById(R.id.prevGuess4);
        TextView prevGuess5 = (TextView) findViewById(R.id.prevGuess5);
        TextView prevGuess6 = (TextView) findViewById(R.id.prevGuess6);

        LinearLayout myRoot = (LinearLayout) findViewById(R.id.nextGuessList);

        final Button enterGuess = findViewById(R.id.enterGuess);
        final Button startOverButton = findViewById(R.id.startOver);
        final Button helpButton = findViewById(R.id.helpButton);

        inputWrapping(textInput0, textInput1, textInput2, textInput3, textInput4);


        textInput0.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                //code that you want do when pressed
                colorNum0 += 1;
                if(colorNum0 % 3 == 0){ // if toggle = 0 -> change to orange
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum0 % 3 == 1){ // if toggle = 0 -> change to orange
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum0 % 3 == 2){ // if toggle = 0 -> change to orange
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });
        textInput1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                //code that you want do when pressed
                colorNum1 += 1;
                if(colorNum1 % 3 == 0){ // if toggle = 0 -> change to orange
                    textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum1 % 3 == 1){ // if toggle = 0 -> change to orange
                    textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum1 % 3 == 2){ // if toggle = 0 -> change to orange
                    textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });
        textInput2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                //code that you want do when pressed
                colorNum2 += 1;
                if(colorNum2 % 3 == 0){ // if toggle = 0 -> change to orange
                    textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum2 % 3 == 1){ // if toggle = 0 -> change to orange
                    textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum2 % 3 == 2){ // if toggle = 0 -> change to orange
                    textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });
        textInput3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                //code that you want do when pressed
                colorNum3 += 1;
                if(colorNum3 % 3 == 0){ // if toggle = 0 -> change to orange
                    textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum3 % 3 == 1){ // if toggle = 0 -> change to orange
                    textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum3 % 3 == 2){ // if toggle = 0 -> change to orange
                    textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });
        textInput4.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                //code that you want do when pressed
                colorNum4 += 1;
                if(colorNum4 % 3 == 0){ // if toggle = 0 -> change to orange
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum4 % 3 == 1){ // if toggle = 0 -> change to orange
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum4 % 3 == 2){ // if toggle = 0 -> change to orange
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helpButtonDialogue popup = new helpButtonDialogue();
                popup.show(getSupportFragmentManager(), null);
            }
        });

        //This is where you call start over to reset board
        startOverButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ConfirmStartOverDialogue popup = new ConfirmStartOverDialogue();
                //popup.show(getSupportFragmentManager(), null);

                //remove scroll view
                myRoot.removeAllViews();

                //remove colors and text
                textInput0.setText("");
                textInput1.setText("");
                textInput2.setText("");
                textInput3.setText("");
                textInput4.setText("");

                textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));

                //Clear list of guesses Here
                prevGuess1.setText("1. " + EMPTY);
                prevGuess2.setText("2. " + EMPTY);
                prevGuess3.setText("3. " + EMPTY);
                prevGuess4.setText("4. " + EMPTY);
                prevGuess5.setText("5. " + EMPTY);
                prevGuess6.setText("6. " + EMPTY);

                currGuessNum = 0;
            }
        });

        /*



        colorButton0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                colorNum0 += 1;

                if(colorNum0 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum0 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum0 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
            }
        });

        colorButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                colorNum1 += 1;

                if(colorNum1 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum1 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum1 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
            }
        });

        colorButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                colorNum2 += 1;

                if(colorNum2 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum2 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum2 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
            }
        });

        colorButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                colorNum3 += 1;

                if(colorNum3 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum3 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum3 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
            }
        });

        colorButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                colorNum4 += 1;

                if(colorNum4 % 3 == 0){ // if toggle = 0 -> change to orange
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if(colorNum4 % 3 == 1){ // if toggle = 0 -> change to orange
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if(colorNum4 % 3 == 2){ // if toggle = 0 -> change to orange
                    colorButton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
            }
        });

         */

        int i = 0;
        enterGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String colors = "";
                String enteredWord = "";

                //get the characters from the input grid
                final EditText char0 = (EditText) findViewById(R.id.gridInput_00);
                final EditText char1 = (EditText) findViewById(R.id.gridInput_01);
                final EditText char2 = (EditText) findViewById(R.id.gridInput_02);
                final EditText char3 = (EditText) findViewById(R.id.gridInput_03);
                final EditText char4 = (EditText) findViewById(R.id.gridInput_04);

                //concatenate letters into string
                enteredWord = char0.getText().toString() + char1.getText().toString() +
                        char2.getText().toString() + char3.getText().toString() + char4.getText().toString();

                enteredWord = enteredWord.toUpperCase();

                //check that word is 5 chars long, if not, display popup
                if (enteredWord.length() < 5) {

                    NotEnoughCharsDialogue popup = new NotEnoughCharsDialogue();
                    popup.show(getSupportFragmentManager(), null);

                }else{

                    if (currGuessNum < 6){

                        currGuessNum++;

                        colors = colorNum0.toString() + colorNum1.toString() + colorNum2.toString() +
                                colorNum3.toString() + colorNum4.toString();

                        Guess algo = new Guess(wordList);

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

                        String displayedInfo = "";
                        //get the words and percentage from word list and display them
                        /* for word in guess object
                            TextView newTextView = new TextView(getApplicationContext());
                            String displayedInfo = MAKE DISPLAY STRING HERE;
                            newTextView.setText(displayedInfo);
                            newTextView.setTextColor(ColorStateList.valueOf(Color.parseColor(BLACK_HEX)));
                            newTextView.setTextSize(15);
                            myRoot.addView(newTextView);

                         */

                    }else{

                        gameOverDialogue popup = new gameOverDialogue();
                        popup.show(getSupportFragmentManager(), null);
                    }

                    //clear characters and reset colors
                    char0.setText("");
                    char0.clearFocus();
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                    colorNum0 = 0;

                    char1.setText("");
                    char1.clearFocus();
                    textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                    colorNum1 = 0;

                    char2.setText("");
                    char2.clearFocus();
                    textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                    colorNum2 = 0;

                    char3.setText("");
                    char3.clearFocus();
                    textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                    colorNum3 = 0;

                    char4.setText("");
                    char4.clearFocus();
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                    colorNum4 = 0;

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });
    }

    public void inputWrapping(EditText textInput0, EditText textInput1,EditText textInput2,EditText textInput3,EditText textInput4){

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

    ArrayList<String> loadStrings(){
        try {

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(this.getResources().getAssets().open("valid-wordle-words.txt")));
            ArrayList<String> listOfLines = new ArrayList<>();

            String line = null;

            line = bufReader.readLine();


            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            bufReader.close();
            return listOfLines;
        } catch (IOException e) {

            return null;

        }
    }
}

