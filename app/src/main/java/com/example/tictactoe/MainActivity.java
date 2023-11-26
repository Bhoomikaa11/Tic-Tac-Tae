package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  final List<int[]> combinationsList = new ArrayList<>();

    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};

    private int playTurn =1 ;
    private int totalSelectedBoxes = 1 ;
    private LinearLayout playeronelayout, playertwolayout ;
    private TextView playeronename , playertwoname ;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       playeronename = findViewById(R.id.playeronename);
          playertwoname = findViewById(R.id.playertwoname);

          playeronelayout = findViewById(R.id.playeronelayout);
        playertwolayout = findViewById(R.id.playertwolayout);

        img1 = findViewById(R.id.img1);
         img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
         img4 = findViewById(R.id.img4);
         img5 = findViewById(R.id.img5);
         img6 = findViewById(R.id.img6);
         img7 = findViewById(R.id.img7);
       img8 = findViewById(R.id.img8);
       img9 = findViewById(R.id.img9);

       combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{0,4,8});
        combinationsList.add(new int[]{2,4,6});

        final String getplayeronename = getIntent().getStringExtra("Player One");
        final String getplayertwoname = getIntent().getStringExtra("Player Two");

        playeronename.setText(getplayeronename);
        playertwoname.setText(getplayertwoname);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(0))
                {
                    performAction((ImageView)v , 0);
                }

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(1))
                {
                    performAction((ImageView)v , 1);
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(2))
                {
                    performAction((ImageView)v , 2);
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(3))
                {
                    performAction((ImageView)v , 3);
                }
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(4))
                {
                    performAction((ImageView)v , 4);
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(5))
                {
                    performAction((ImageView)v , 5);
                }
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(6))
                {
                    performAction((ImageView)v , 6);
                }
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(7))
                {
                    performAction((ImageView)v , 7);
                }
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(8))
                {
                        performAction((ImageView)v , 8);
                }
            }
        });
    }

    private void performAction(ImageView imageView , int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playTurn;
        if (playTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if (checkPlayerWin()) {
            winDialog windialog = new winDialog(MainActivity.this,playeronename.getText().toString()+" Has Won Match !!",MainActivity.this);
            windialog.setCancelable(false);
            windialog.show();
            } else if (totalSelectedBoxes==9) {
                winDialog windialog = new winDialog(MainActivity.this,"It is a draw !!",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            }
            else
            {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else
        {
            imageView.setImageResource(R.drawable.oimage);
            if(checkPlayerWin())
            {
                winDialog windialog = new winDialog(MainActivity.this,playertwoname.getText().toString()+" Has Won Match !!",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            } else if (selectedBoxPosition==9) {
                winDialog windialog = new winDialog(MainActivity.this,"It is a draw !!",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            }
            else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private  void changePlayerTurn(int currentPlayerTurn)
    {
        playTurn = currentPlayerTurn ;
        if(playTurn==1)
        {
            playeronelayout.setBackgroundResource(R.drawable.changep1);
            playertwolayout.setBackgroundResource(R.drawable.round_corner);
        }
        else
        {
            playertwolayout.setBackgroundResource(R.drawable.changep1);
            playeronelayout.setBackgroundResource(R.drawable.round_corner);
        }
    }
    private boolean checkPlayerWin()
    {
        boolean response = false ;
        for(int i=0; i<combinationsList.size();i++)
        {
            final int [] combination = combinationsList.get(i);

            if(boxPositions[combination[0]]== playTurn &&
                    boxPositions[combination[1]]== playTurn
                    && boxPositions[combination[2]]== playTurn )
            {
                response = true ;
            }
        }
        return response ;
    }
    private boolean isBoxSelectable(int boxPosition)
    {
        boolean response = false ;
        if(boxPositions[boxPosition]==0)
        {
            response = true ;
        }
        return  response ;
    }

    public void restart()
    {
    boxPositions = new int[] { 0,0,0,0,0,0,0,0,0};
    playTurn =1 ;
    totalSelectedBoxes =1 ;

        img1.setImageResource(R.drawable.purple_box);
        img2.setImageResource(R.drawable.purple_box);
        img3.setImageResource(R.drawable.purple_box);
        img4.setImageResource(R.drawable.purple_box);
        img5.setImageResource(R.drawable.purple_box);
        img6.setImageResource(R.drawable.purple_box);
        img7.setImageResource(R.drawable.purple_box);
        img8.setImageResource(R.drawable.purple_box);
        img9.setImageResource(R.drawable.purple_box);

    }
}