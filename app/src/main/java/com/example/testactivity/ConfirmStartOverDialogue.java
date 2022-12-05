package com.example.testactivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

//DOCUMENTATION
//https://developer.android.com/develop/ui/views/components/dialogs#PassingEvents

public class ConfirmStartOverDialogue extends DialogFragment {

    public interface ConfirmStartOveDialogListener {
        public void onConfirmStartOverDialogueYes(DialogFragment dialog);

        public void onConfirmStartOverDialogueNo(DialogFragment dialog);
    }

    ConfirmStartOveDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ConfirmStartOveDialogListener) context;

    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure you would like to start over?\n\n" +
                        "This action cannot be undone.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        listener.onConfirmStartOverDialogueYes(ConfirmStartOverDialogue.this);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        listener.onConfirmStartOverDialogueNo(ConfirmStartOverDialogue.this);
                    }
                });
        return builder.create();

    }
}

