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
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements ConfirmStartOverDialogue.ConfirmStartOveDialogListener {

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

    String mode = "textInput";

    final String EMPTY = "Guess";


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
    ArrayList<Guess> guessObjects;

    @Override
    public void onConfirmStartOverDialogueYes(DialogFragment dialog) {

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


    }

    @Override
    public void onConfirmStartOverDialogueNo(DialogFragment dialog) {
        //do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currGuessNum = 0;
        guessObjects = new ArrayList<Guess>();

        ArrayList<String> wordList = loadStrings();
        guessObjects.add(new Guess(wordList));
        guessObjects.get(0).setGuess("cares");
        Log.d("wordObj", "" + guessObjects.get(0).wordToScore("penis"));
        Log.d("GuessNum: ----", "" + currGuessNum);

        textInput0 = findViewById(R.id.gridInput_00);
        textInput1 = findViewById(R.id.gridInput_01);
        textInput2 = findViewById(R.id.gridInput_02);
        textInput3 = findViewById(R.id.gridInput_03);
        textInput4 = findViewById(R.id.gridInput_04);

        //Previous guess inits
        prevGuess1 = (TextView) findViewById(R.id.prevGuess1);
        prevGuess2 = (TextView) findViewById(R.id.prevGuess2);
        prevGuess3 = (TextView) findViewById(R.id.prevGuess3);
        prevGuess4 = (TextView) findViewById(R.id.prevGuess4);
        prevGuess5 = (TextView) findViewById(R.id.prevGuess5);
        prevGuess6 = (TextView) findViewById(R.id.prevGuess6);

        myRoot = (LinearLayout) findViewById(R.id.nextGuessList);

        enterGuess = findViewById(R.id.enterGuess);
        startOverButton = findViewById(R.id.startOver);
        helpButton = findViewById(R.id.helpButton);

        inputWrapping();
        longPresses();
        utilButtons();
        submitGuess();

    }


    public void submitGuess() {
        enterGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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

                }
                //This is how to insert a guess to the guess object, it will return false if the guess is not on the list of remaining words
                else if (guessObjects.get(currGuessNum).setGuess(enteredWord.toLowerCase()) == false) {

                    NotValidGuess popup = new NotValidGuess();
                    popup.show(getSupportFragmentManager(), null);
                } else {

                    //How to insert the colors
                    int colors[] = {colorNum0, colorNum1, colorNum2, colorNum3, colorNum4};
                    guessObjects.get(currGuessNum).setColors(colors);

                    if (currGuessNum < 6) {
                        guessObjects.add(new Guess(guessObjects.get(currGuessNum).prunedList()));
                        currGuessNum++;


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

                        //how to use my stuff
                        //
                        //
                        //arraylist for getting a sorted list of the best words to get, length is how long you want it to be, if smaller than length
                        //it will be as long as there are words left
                        ArrayList<String> bestWords = guessObjects.get(currGuessNum).getSortedWords(25);

                        //to get percent you must use the hash, here is a corresponding arrayList
                        ArrayList<Float> scores = new ArrayList<Float>();
                        for (int i = 0; i < bestWords.size(); i++) {
                            scores.add(guessObjects.get(currGuessNum).wordToScore(bestWords.get(i)));
                        }

                        //you can also get sorted char[] for each letter based on score, position is where it is on the string
                        char[] firstLetterScores = guessObjects.get(currGuessNum).getSortedLetters(0);

                        //it is also easy to get the score of each letter, returns a percent (int for position in string, char for letter)
                        float aLetterScore = guessObjects.get(currGuessNum).getLetterScore(0, 'a');

                        //so you can do something like
                        for (int i = 0; i < firstLetterScores.length; i++) {
                            Log.d("chance of: " + firstLetterScores[i], " ---> " + guessObjects.get(currGuessNum).getLetterScore(0, firstLetterScores[i]));
                        }
                        //which should print the odds from highest to least of the first letter in the string


                        //get the words and percentage from word list and display them
                        /* for word in guess object
                            TextView newTextView = new TextView(getApplicationContext());
                            String displayedInfo = MAKE DISPLAY STRING HERE;
                            newTextView.setText(displayedInfo);
                            newTextView.setTextColor(ColorStateList.valueOf(Color.parseColor(BLACK_HEX)));
                            newTextView.setTextSize(15);
                            myRoot.addView(newTextView);

                         */

                    } else {

                        GameOverDialogue popup = new GameOverDialogue();
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

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });
    }

    public void utilButtons() {
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelpButtonDialogue popup = new HelpButtonDialogue();
                popup.show(getSupportFragmentManager(), null);
            }
        });

        //This is where you call start over to reset board
        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConfirmStartOverDialogue popup = new ConfirmStartOverDialogue();
                popup.show(getSupportFragmentManager(), null);
            }
        });
    }

    public void longPresses() {
        textInput0.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                colorNum0 += 1;
                if (colorNum0 % 3 == 0) { // if toggle = 0 -> change to orange
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if (colorNum0 % 3 == 1) { // if toggle = 0 -> change to orange
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if (colorNum0 % 3 == 2) { // if toggle = 0 -> change to orange
                    textInput0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });
        textInput1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {

                colorNum1 += 1;
                if (colorNum1 % 3 == 0) { // if toggle = 0 -> change to orange
                    textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if (colorNum1 % 3 == 1) { // if toggle = 0 -> change to orange
                    textInput1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if (colorNum1 % 3 == 2) { // if toggle = 0 -> change to orange
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
                if (colorNum2 % 3 == 0) { // if toggle = 0 -> change to orange
                    textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if (colorNum2 % 3 == 1) { // if toggle = 0 -> change to orange
                    textInput2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if (colorNum2 % 3 == 2) { // if toggle = 0 -> change to orange
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
                if (colorNum3 % 3 == 0) { // if toggle = 0 -> change to orange
                    textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if (colorNum3 % 3 == 1) { // if toggle = 0 -> change to orange
                    textInput3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if (colorNum3 % 3 == 2) { // if toggle = 0 -> change to orange
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
                if (colorNum4 % 3 == 0) { // if toggle = 0 -> change to orange
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GRAY_HEX)));
                }
                if (colorNum4 % 3 == 1) { // if toggle = 0 -> change to orange
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(YELLOW_HEX)));
                }
                if (colorNum4 % 3 == 2) { // if toggle = 0 -> change to orange
                    textInput4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(GREEN_HEX)));
                }
                return false;
            }
        });
    }

    public void inputWrapping() {

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

                if (textInput0.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL) {
                    textInput0.setText("");

                }
                return false;
            }
        });
        textInput1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (textInput1.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL) {
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

                if (textInput2.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL) {
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

                if (textInput3.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL) {
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

                if (textInput4.getText().toString().length() == 0 && keyCode == event.KEYCODE_DEL) {
                    textInput4.setText("");
                    textInput4.clearFocus();
                    textInput3.requestFocus();
                    // textInput3.setText("");
                }
                return false;
            }
        });


    }

    ArrayList<String> loadStrings() {
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

