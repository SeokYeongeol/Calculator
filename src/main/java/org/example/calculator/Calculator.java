package org.example.calculator;
import java.util.*;

public class Calculator {
    private ArrayList<Double> calArr = new ArrayList<>();

    public double calculate(String firstNum, String secondNum, String operator) {
        double answer = 0;

        double value1 = Double.parseDouble(firstNum);       // val1을 String -> double로 형변환
        double value2 = Double.parseDouble(secondNum);       // val2를 String -> double로 형변환

        char op = operator.charAt(0);       // 사칙연산 기호

        switch(op) {
            case '+':
                answer = value1 + value2;
                break;
            case '-':
                answer = value1 - value2;
                break;
            case '*':
                answer = value1 * value2;
                break;
            case '/':
                answer = value1 / value2;
                break;
        }
        return answer;
    }

    public ArrayList<Double> getCalArr() {
        return this.calArr;
    }

    public void setCalArr(double input) {
        this.calArr.add(input);
    }

    public void delCalArr() {
        this.calArr.remove(0);
    }
}