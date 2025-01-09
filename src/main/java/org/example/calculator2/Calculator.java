package org.example.calculator2;
import java.util.*;

public class Calculator {
    private List<Double> calArr = new ArrayList<>();

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

    public List<Double> getCalArr() {     // private인 배열을 리턴해주는 메서드
        return this.calArr;
    }

    public void setCalArr(double input) {       // private인 배열에 값을 넣어주는 메서드
        this.calArr.add(input);
    }

    public void delCalArr() {       // private인 배열의 첫번째 인덱스 값을 삭제해주는 메서드
        this.calArr.remove(0);
    }
}