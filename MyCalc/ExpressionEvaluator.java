package com.example.mycalc;

import java.util.Stack;

public class ExpressionEvaluator {

    public static double evaluateExpression(String expression) {
        String[] tokens = infixToPostfix(expression).split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(token, a, b));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return "+-×÷%".contains(token);
    }

    private static double applyOperator(String operator, double a, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "−":
                return a - b;
            case "×":
                return a * b;
            case "÷":
                if (b == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return a / b;
            case "%":
                return a % b;
            default:
                throw new IllegalArgumentException("알 수 없는 연산자: " + operator);
        }
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "−":
                return 1;
            case "×":
            case "÷":
            case "%":
                return 2;
            default:
                return -1;
        }
    }

    private static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.split("(?<=[-+×÷%()])|(?=[-+×÷%()])");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (Character.isDigit(token.charAt(0))) {
                result.append(token).append(" ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }
}