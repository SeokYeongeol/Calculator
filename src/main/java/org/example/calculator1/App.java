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

        while (true) {
            System.out.println("계산기를 시작합니다. 계산기를 나가시려면 언제든지 exit를 입력해주세요!");
            System.out.println("1. 계산기, 2. 삭제, 3. 조회, 나가기: exit");
            System.out.print("입력 : ");
            String choice = sc.next();      // 실행할 행동 선택

            if (choice.equals("1")) {       // 계산기 실행
                System.out.print("첫 번째 숫자를 입력해주세요 (음수 제외) : ");
                String firstNumber = sc.next();

                if (firstNumber.equals("exit")) break;       // 계산기를 나가는 조건문

                try {       // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                    if (!Pattern.matches(DOUBLE_NUMBER_REG, firstNumber)) throw new IOException("잘못된 값을 입력하셨습니다." + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                double firstValue = Double.parseDouble(firstNumber);        // 입력한 값을 계산을 위한 Double형으로 변경

                System.out.print("두 번째 숫자를 입력해주세요 (음수 제외) : ");
                String secondNumber = sc.next();

                if (secondNumber.equals("exit")) break;

                try {       // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                    if (!Pattern.matches(DOUBLE_NUMBER_REG, secondNumber)) throw new IOException("잘못된 값을 입력하셨습니다." + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                double secondValue = Double.parseDouble(secondNumber);          // 입력한 값을 계산을 위한 Double형으로 변경

                System.out.print("사칙연산 기호를 입력해주세요 (+, -, *, /) : ");
                double addValue = 0;
                String operator = sc.next();

                try {       // 연산자 입력 예외 처리문
                    if(!Pattern.matches(OPERATOR_REG, operator)) throw new IOException("잘못된 값을 입력하셨습니다." + "\n");
                    switch (operator) {
                        case "+" -> addValue = firstValue + secondValue;
                        case "-" -> addValue = firstValue - secondValue;
                        case "*" -> addValue = firstValue * secondValue;
                        case "/" -> {
                            if (secondValue != 0) addValue = firstValue / secondValue;
                            else {
                                System.out.println("나누기의 분모 값은 0이 될 수 없습니다." + "\n");
                                continue;
                            }
                        }
                    }
                    System.out.println("계산 결과 : " + addValue + "\n");
                    calculator.add(addValue);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice.equals("2")) {        // 컬렉션에서 첫 번째 값을 삭제
                if (calculator.isEmpty()) {     // 컬렉션이 비어있을 때의 예외처리
                    System.out.println("삭제할 컬렉션이 없습니다." + "\n");
                    continue;
                }
                System.out.println("첫 번째 값을 삭제했습니다. 삭제된 값 : [ " + calculator.get(0) + " ]" + "\n");
                calculator.remove(0);
            } else if (choice.equals("3")) {        // 컬렉션을 조회
                if (calculator.isEmpty()) {
                    System.out.println("조회할 컬렉션이 없습니다." + "\n");
                    continue;
                }
                System.out.println("1. 모든 데이터 조회, 2. 해당 값보다 높은 데이터 조회");
                System.out.print("입력 : ");
                String choiceList = sc.next();         // 어떤 데이터를 조회할지 입력

                if (choiceList.equals("exit")) break;       // 계산기 나가기

                else if (choiceList.equals("1")) {      // 모든 데이터 조회
                    System.out.print("모든 데이터 : " + calculator.stream().toList() + "\n");        // calculator 리스트를 조회하는 stream
                    System.out.println();
                } else if (choiceList.equals("2")) {        // 입력 값보다 높은 데이터만 조회
                    System.out.print("값 입력 : ");
                    String bigValue = sc.next();

                    try {   // 입력 값보다 높은 데이터를 조회하는 stream + 잘못된 값 입력을 방지하는 예외처리문
                        if (!Pattern.matches(DOUBLE_NUMBER_REG, bigValue)) throw new IOException("잘못된 값을 입력하셨습니다." +"\n");
                        System.out.print(bigValue + " 보다 큰 데이터 : " + calculator.stream().filter(cal -> cal > Double.parseDouble(bigValue))
                                .toList() + "\n");
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else System.out.println("잘못된 값을 입력하셨습니다." + "\n");
            } else if(choice.equals("exit")) break;
            else System.out.println("잘못된 값을 입력하셨습니다." + "\n");
        }
        System.out.println("계산기 종료...");
    }
}
