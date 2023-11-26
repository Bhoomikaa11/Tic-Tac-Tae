package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class winDialog extends Dialog {

    private final String message ;
    private final MainActivity mainActivity ;
    public winDialog(@NonNull Context context , String message , MainActivity mainActivity) {
        super(context);
        this.message = message ;
        this.mainActivity = mainActivity ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog);

        final TextView messageTxt = findViewById(R.id.messageTxt);
        final Button startagainBtn =  findViewById(R.id.startagainBtn);

        messageTxt.setText(message);

        startagainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivity.restart();
                dismiss();
            }
        });
    }
}
