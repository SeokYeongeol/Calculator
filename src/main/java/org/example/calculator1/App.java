package org.example.calculator1;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class App {
    private static final String DOUBLE_NUMBER_REG = "^([0-9]*[.])?[0-9]+$";
    private static final String OPERATOR_REG = "[+\\-*/]";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> calculator = new ArrayList<>();

        while(true) {
            System.out.println("계산기를 시작합니다. 계산기를 나가시려면 언제든지 exit를 입력해주세요!");
            System.out.println("1. 계산기, 2. 삭제, 3. 조회, 나가기: exit");
            System.out.print("입력 : ");
            String choice = sc.next();      // 실행할 행동 선택

            switch(choice) {
                case "1":
                    System.out.print("첫 번째 숫자를 입력해주세요 (음수 제외) : ");
                    String firstNumber = sc.next();

                    if(firstNumber.equals("exit")) break;       // 계산기를 나가는 조건문

                    try {
                        if(!Pattern.matches(DOUBLE_NUMBER_REG, firstNumber)) throw new IOException("잘못된 값을 입력하셨습니다." + "\n");
                    } catch(IOException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    double firstValue = Double.parseDouble(firstNumber);

                    System.out.print("두 번째 숫자를 입력해주세요 (음수 제외) : ");
                    String secondNumber = sc.next();

                    if(secondNumber.equals("exit")) break;

                    try {
                        if(!Pattern.matches(DOUBLE_NUMBER_REG, secondNumber)) throw new IOException("잘못된 값을 입력하셨습니다." + "\n");
                    } catch(IOException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    double secondValue = Double.parseDouble(secondNumber);

                    System.out.print("사칙연산 기호를 입력해주세요 (+, -, *, /) : ");
                    String operator = sc.next();

                    double addValue = 0;

                    switch(operator) {
                        case "+":
                            addValue = firstValue + secondValue;

                        case "-":
                            addValue = firstValue - secondValue;

                        case "*":
                            addValue = firstValue * secondValue;
                    }
            }
        }
    }
}
