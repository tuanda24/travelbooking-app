package com.example.project136.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ConfirmDialog {

    public static void showConfirmDialog(
        Context context,
        String title,
        String message,
        String positiveButtonLabel,
        String negativeButtonLabel,
        final ConfirmationDialogListener listener
    ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(positiveButtonLabel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.onPositiveButtonClicked();
                }
            }
        });

        builder.setNegativeButton(negativeButtonLabel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.onNegativeButtonClicked();
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface ConfirmationDialogListener {
        void onPositiveButtonClicked();

        void onNegativeButtonClicked();
    }
}