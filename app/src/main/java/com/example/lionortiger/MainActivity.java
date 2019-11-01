package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player {
        ONE, TWO;
    }

    Player currentPlayer = Player.ONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageViewIsClicked (View view) {

        ImageView tappedImageView = (ImageView) view;

        tappedImageView.setTranslationX(-2000);
        if (currentPlayer==Player.ONE) {
            tappedImageView.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        } else if ( currentPlayer == Player.TWO) {
            tappedImageView.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }


        tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(500);
        Toast.makeText(this,tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();
    }

}
