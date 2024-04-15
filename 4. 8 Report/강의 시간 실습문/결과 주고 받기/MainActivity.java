package com.example.activityex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResultLauncher;

public class MainActivity extends AppCompatActivity {
    private EditText email, pwd;
    private TextView login;
    private Button loginButton;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        pwd = findViewById(R.id.pwd);
        loginButton = findViewById(R.id.login);
        login = findViewById(R.id.success);

        // ActivityResultLauncher 초기화
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        // 결과 처리
                        Intent data = result.getData();
                        if (data != null) {
                            String status = data.getStringExtra("STATUS");
                            login.setText(status);
                        }
                    }
                });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailT = email.getText().toString();
                String pwdT = pwd.getText().toString();

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("ID", emailT);
                intent.putExtra("Password", pwdT);
                launcher.launch(intent);
            }
        });
    }
}