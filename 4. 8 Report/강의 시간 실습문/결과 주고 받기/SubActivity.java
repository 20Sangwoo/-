package com.example.activityex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    private TextView displayText, displayPwd, success;
    String id, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        displayText = findViewById(R.id.displayText);
        displayPwd = findViewById(R.id.displayPwd);
        success = findViewById(R.id.success);

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("ID");
            pwd = intent.getStringExtra("Password"); // "Password"로 수정
            displayText.setText("아이디: " + id);
            displayPwd.setText("비밀번호: " + pwd);
        }
    }
    public void check(View e) {
        Intent intent = new Intent();
        if (isUserValid(id, pwd)) {
            intent.putExtra("STATUS", "로그인 성공!!!");
        } else {
            intent.putExtra("STATUS", "로그인 실패!!!");
        }
        setResult(RESULT_OK, intent);
        finish();
    }
    private boolean isUserValid(String username, String password) {
        return username.equals("kim") && password.equals("1234"); // equals 사용
    }
}