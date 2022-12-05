package com.example.testactivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class helpButtonDialogue extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Welcome to Wordle Coach!\n\n" +
                        "This app is designed to be used in tandem with and ongoing Wordle game open in a web browser.\n\n" +
                        "To begin, submit/enter a guess into the Wordle game on your browser. Wordle will then display " +
                        "the colors of each letter in the word. Enter the same word you just entered into the Wordle " +
                        "Coach app and select the colors for each letter as displayed on your browser. Then, hit enter.\n\n" +
                        "Wordle coach will then display a list of possible Wordle words, sorted by their probability " +
                        "of being the Wordle word. Select one of your choosing (higher probabilities have a higher " +
                        "chance of being the Wordle of the day), and enter it into your browser. Now follow the above " +
                        "instructions again until you've used all 6 guesses.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}

