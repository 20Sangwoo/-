package com.example.dice;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.dice);
    }
    public void rollDice(View view) {
        Random random = new Random();
        int randomNum = random.nextInt(6);

        switch (randomNum) {
            case 0:
                imageView.setImageResource(R.drawable.dice1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.dice2);
                break;
            case 2:
                imageView.setImageResource(R.drawable.dice3);
                break;
            case 3:
                imageView.setImageResource(R.drawable.dice4);
                break;
            case 4:
                imageView.setImageResource(R.drawable.dice5);
                break;
            case 5:
                imageView.setImageResource(R.drawable.dice6);
                break;
            default:
                imageView.setImageResource(R.drawable.dice);
                break;
        }
    }
}