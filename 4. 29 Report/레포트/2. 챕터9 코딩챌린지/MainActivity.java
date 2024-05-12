package kr.co.company.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.instrument.SnowView;

public class MainActivity extends AppCompatActivity {

    SnowView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new SnowView(this);
        setContentView(view);
    }
}