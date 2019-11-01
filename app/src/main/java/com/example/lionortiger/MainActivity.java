package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageViewIsClicked (View view) {

        ImageView tappedImageView = (ImageView) view;

        tappedImageView.setTranslationX(-2000);
        tappedImageView.setImageResource(R.drawable.lion);
        tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(500);
    }

}
