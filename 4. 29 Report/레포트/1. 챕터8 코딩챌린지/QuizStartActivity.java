package com.example.fragment;

import android.os.Bundle;
import android.view.View;


import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class QuizStartActivity extends AppCompatActivity implements View.OnClickListener{
    Button next;
    Fragment fragment;
    int prob_count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_start);
        fragment = new Quiz1Fragment();
        transit(fragment);
        next = findViewById(R.id.next);
        next.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        prob_count++;
        if(prob_count==2){
            fragment = new Quiz2Fragment();
            transit(fragment);
        }
        else if(prob_count==3){
            fragment = new Quiz3Fragment();
            transit(fragment);
        }
        else if(prob_count==4){
            fragment = new Quiz4Fragment();
            transit(fragment);
        }
        else if(prob_count==5){
            fragment = new Quiz5Fragment();
            transit(fragment);
            next.setText("Submit");
        }
        else if(prob_count==6){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("점수 기능을 추가해보세요: ");
            builder.setMessage("5점");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Intent intent = new Intent(QuizStartActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    void transit(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.framelayoutid,fragment);
        transaction.commit();
    }
}