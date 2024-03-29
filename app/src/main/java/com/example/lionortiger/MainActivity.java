package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player {
        ONE, TWO, NONE;
    }
    GridLayout gridLayout;
    Button button;
    Player currentPlayer = Player.ONE;
    Player[] playerChoices =new Player[9];
    int [][] winnerRowColumns = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},
            {1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameOver = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        gridLayout = findViewById(R.id.gridLayout);


        for (int i=0; i<9; i++) {
            playerChoices[i] = Player.NONE;
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTheGame();
            }
        });
    }



    public void imageViewIsClicked (View view) {

        ImageView tappedImageView = (ImageView) view;
        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());


        if (playerChoices[tiTag] == Player.NONE && gameOver== false) {
            tappedImageView.setTranslationX(-2000);

            playerChoices[tiTag] = currentPlayer;
            if (currentPlayer == Player.ONE) {
                tappedImageView.setImageResource(R.drawable.lion);
                currentPlayer = Player.TWO;
            } else if (currentPlayer == Player.TWO) {
                tappedImageView.setImageResource(R.drawable.tiger);
                currentPlayer = Player.ONE;
            }


            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
            Toast.makeText(this, tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();
            for (int[] winnerColums : winnerRowColumns) {
                if (playerChoices[winnerColums[0]] == playerChoices[winnerColums[1]]
                        && playerChoices[winnerColums[1]] == playerChoices[winnerColums[2]]
                        && playerChoices[winnerColums[0]] != Player.NONE) {
                    //Toast.makeText(this, "We have a winner", Toast.LENGTH_SHORT).show();
                    String winner = " ";
                    if (currentPlayer == Player.ONE) {
                        winner = "Player One";
                    } else if (currentPlayer == Player.TWO) {
                        winner = "Player Two";
                    }
                    Toast.makeText(this, "The winner of the game is : "+winner + "",
                            Toast.LENGTH_SHORT).show();
                    gameOver=true;
                    button.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    void resetTheGame() {


        for (int index=0; index< gridLayout.getChildCount(); index++) {

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
        }
        currentPlayer = Player.ONE;
        gameOver = false;
        for (int i=0; i<9; i++) {
            playerChoices[i] = Player.NONE;
        }


    }

}
