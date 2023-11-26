package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.SpannableString ;
import android.text.style.UnderlineSpan ;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        TextView textView = findViewById(R.id.textviewtic) ;
        SpannableString content = new SpannableString( "Tic Tac Toe" ) ;
        content.setSpan( new UnderlineSpan() , 0 , content.length() , 0 ) ;
        textView.setText(content) ;

        final TextView textview = findViewById(R.id.textviewtic);
        final TextView playername = findViewById(R.id.playername);
        final EditText playername1 = findViewById(R.id.playername1);
        final EditText playername2 = findViewById(R.id.playername2);
        final Button startgamebtn = findViewById(R.id.startgamebutton);

        startgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getplayer1 = playername1.getText().toString();
                final String getplayer2 = playername2.getText().toString();

                if(getplayer1.isEmpty() || getplayer2.isEmpty())
                {
                    Toast.makeText(AddPlayers.this,"Please add players name!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(AddPlayers.this,MainActivity.class);
                    intent.putExtra("Player One",getplayer1);
                    intent.putExtra("Player Two",getplayer2);
                    startActivity(intent);

                }
            }
        });



    }
}