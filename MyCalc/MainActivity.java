package com.example.mycalc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycalc.ExpressionEvaluator;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private StringBuilder currentExpression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        // 숫자 및 연산자 버튼 클릭 이벤트 처리
        setOnClickListener(R.id.btn0, "0");
        setOnClickListener(R.id.btn1, "1");
        setOnClickListener(R.id.btn2, "2");
        setOnClickListener(R.id.btn3, "3");
        setOnClickListener(R.id.btn4, "4");
        setOnClickListener(R.id.btn5, "5");
        setOnClickListener(R.id.btn6, "6");
        setOnClickListener(R.id.btn7, "7");
        setOnClickListener(R.id.btn8, "8");
        setOnClickListener(R.id.btn9, "9");
        setOnClickListener(R.id.btnDot, ".");
        setOnClickListener(R.id.btnOpenParenthesis, "(");
        setOnClickListener(R.id.btnCloseParenthesis, ")");
        setOnClickListener(R.id.btnPercent, "%");
        setOnClickListener(R.id.btnAdd, "+");
        setOnClickListener(R.id.btnSubtract, "−");
        setOnClickListener(R.id.btnMultiply, "×");
        setOnClickListener(R.id.btnDivide, "÷");

        // AC 버튼 클릭 이벤트 처리
        findViewById(R.id.btnClear).setOnClickListener(v -> clearExpression());

        // = 버튼 클릭 이벤트 처리
        findViewById(R.id.btnEqual).setOnClickListener(v -> evaluateExpression());

        // 종료 버튼 클릭 이벤트 처리
        findViewById(R.id.btnExit).setOnClickListener(v -> exitApp());
    }

    // 숫자 및 연산자 버튼에 대한 클릭 이벤트를 설정하는 메서드
    private void setOnClickListener(int buttonId, String text) {
        findViewById(buttonId).setOnClickListener(v -> appendToExpression(text));
    }

    // 표현식에 문자열을 추가하는 메서드
    private void appendToExpression(String str) {
        currentExpression.append(str);
        tvResult.setText(currentExpression.toString());
    }

    // 표현식을 지우는 메서드
    private void clearExpression() {
        currentExpression.setLength(0);
        tvResult.setText("0");
    }

    // 표현식을 평가하고 결과를 텍스트 뷰에 표시하는 메서드
    private void evaluateExpression() {
        String expression = currentExpression.toString();
        try {
            double result = ExpressionEvaluator.evaluateExpression(expression);
            tvResult.setText(String.valueOf(result));
        } catch (ArithmeticException e) {
            tvResult.setText("0으로 나눌 수 없습니다");
        } catch (IllegalArgumentException e) {
            tvResult.setText("알 수 없는 수식입니다");
        }
    }

    // 앱을 종료하는 메서드
    private void exitApp() {
        finish();
        System.exit(0);
    }
}