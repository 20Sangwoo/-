package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etext1;
    EditText etext2;
    EditText etext3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bplu = (Button) findViewById(R.id.button1);
        Button bmin = (Button) findViewById(R.id.button2);
        Button bmul = (Button) findViewById(R.id.button3);
        Button bdiv = (Button) findViewById(R.id.button4);
        etext1 = (EditText) findViewById(R.id.edit1);
        etext2 = (EditText) findViewById(R.id.edit2);
        etext3 = (EditText) findViewById(R.id.edit3);
    }

    public void Sum(View e) {
        String s1 = etext1.getText().toString();
        String s2 = etext2.getText().toString();
        int result = Integer.parseInt(s1) + Integer.parseInt(s2);
        etext3.setText("" + result);
    }
    public void Min(View e) {
        String s1 = etext1.getText().toString();
        String s2 = etext2.getText().toString();
        int result = Integer.parseInt(s1) - Integer.parseInt(s2);
        etext3.setText("" + result);
    }
    public void Mul(View e) {
        String s1 = etext1.getText().toString();
        String s2 = etext2.getText().toString();
        int result = Integer.parseInt(s1) * Integer.parseInt(s2);
        etext3.setText("" + result);
    }
    public void Div(View e) {
        String s1 = etext1.getText().toString();
        String s2 = etext2.getText().toString();
        int result = Integer.parseInt(s1) / Integer.parseInt(s2);
        etext3.setText("" + result);
    }
}