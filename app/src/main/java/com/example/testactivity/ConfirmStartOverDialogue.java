package com.example.testactivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

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
}

