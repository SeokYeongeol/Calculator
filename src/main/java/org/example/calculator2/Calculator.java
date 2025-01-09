package org.example.calculator2;
import java.util.*;

public class Calculator {
    private List<Double> calculateArr = new ArrayList<>();

    public double calculate(String firstNum, String secondNum, String operator) {
        double answer = 0;

        double value1 = Double.parseDouble(firstNum);       // val1을 String -> double로 형변환
        double value2 = Double.parseDouble(secondNum);       // val2를 String -> double로 형변환

        switch (operator) {
            case "+" -> answer = value1 + value2;
            case "-" -> answer = value1 - value2;
            case "*" -> answer = value1 * value2;
            case "/" -> {
                if (value2 != 0) answer = value1 / value2;
                else System.out.println("나누기의 분모 값은 0이 될 수 없습니다." + "\n");
            }
        }
        return answer;
    }

    public List<Double> getCalculateArr() {     // private인 배열을 리턴해주는 메서드
        return this.calculateArr;
    }

    public void setCalculateArr(double input) {       // private인 배열에 값을 넣어주는 메서드
        this.calculateArr.add(input);
    }

    public void deleteCalculateArr() {       // private인 배열의 첫번째 인덱스 값을 삭제해주는 메서드
        this.calculateArr.remove(0);
    }
}