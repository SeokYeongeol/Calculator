package org.example.calculator3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String DOUBLE_NUMBER_REG = "^([0-9]*[.])?[0-9]+$";
    private static final String NUMBER_REG = "^[0-9]*$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            System.out.println("계산기에서 나가시려면 언제든지 exit을 입력해주세요!");

            System.out.println("1. 계산기, 2. 삭제, 3. 조회, 나가기: exit");
            System.out.print("입력 : ");
            String choice = sc.next();      // 실행할 행동 선택

            if (choice.equals("1")) {        // 계산기 실행
                System.out.print("첫 번째 숫자를 입력해주세요 (음수 제외) : ");
                String val1 = sc.next();

                if (val1.equals("exit")) break;

                try {       // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                    if (!Pattern.matches(DOUBLE_NUMBER_REG, val1)) {
                        throw new BadInputException();
                    }
                    calculator.setFirstNumber(Double.parseDouble(val1));       // ArithmeticCalculator 클래스의 firstNumber에 값을 넣음
                } catch (BadInputException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.print("두 번째 숫자를 입력해주세요 (음수 제외) : ");
                String val2 = sc.next();

                if (val2.equals("exit")) break;

                try {       // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                    if (!Pattern.matches(DOUBLE_NUMBER_REG, val2)) {
                        throw new BadInputException();
                    }
                    calculator.setSecondNumber(Double.parseDouble(val2));      // ArithmeticCalculator 클래스의 firstNumber에 값을 넣음
                } catch (BadInputException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.print("사칙연산 기호를 입력해주세요 (+, -, *, /) : ");
                String operator = sc.next();

                if (operator.equals("exit")) break;

                // 연산자 입력 오류 예외처리
                try {
                    if (!Pattern.matches(OPERATION_REG, operator)) {
                        throw new BadInputException();
                    }
                    calculator.basicOperation(operator);
                    double answer = calculator.calculate();
                    calculator.getCalculateArr().add(answer);     // 배열에 계산한 값 추가
                    System.out.println("계산 결과 : " + answer + "\n");

                } catch (BadInputException e) {
                    System.out.println(e.getMessage());
                }
            }

            else if (choice.equals("2")) {   // 계산 데이터 삭제
                if (calculator.getCalculateArr().isEmpty()) {          // 계산 데이터가 없을 때 처음으로 돌아가는 예외 처리문
                    System.out.println("삭제할 컬렉션이 없습니다..\n");
                    continue;
                }
                System.out.println("몇 번째 데이터를 삭제하시겠습니까? (0부터 시작)");
                System.out.print("현재 데이터 : " + calculator.getCalculateArr().stream().toList() + "\n");
                System.out.print("입력 : ");
                String delVal = sc.next();

                if (delVal.equals("exit")) break;

                try {
                    if (!Pattern.matches(NUMBER_REG, delVal)) {
                        throw new BadInputException();
                    }
                    int index = Integer.parseInt(delVal);

                    if (calculator.getCalculateArr().size()-1 < index) {
                        throw new BadInputException();
                    }
                    System.out.println("삭제 된 데이터 : " + calculator.getCalculateArr().get(index));
                    calculator.deleteCalculateArr(index);
                    System.out.println();
                } catch (BadInputException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice.equals("3")) {         // 계산 데이터 조회
                if (calculator.getCalculateArr().isEmpty()) {          // 배열이 비어있을 때 처음으로 돌아가는 예외 처리문
                    System.out.println("조회할 컬렉션이 없습니다. 처음으로 돌아갑니다.\n");
                    continue;
                }
                System.out.println("1. 모든 데이터 조회, 2. 해당 값보다 높은 데이터 조회");
                System.out.print("입력 : ");
                String choiNum = sc.next();         // 어떤 데이터를 조회할지 입력

                if (choiNum.equals("exit")) break;       // 계산기 나가기

                else if (choiNum.equals("1")) {      // 현재 배열 데이터 모두 조회
                    // 배열에 값이 있을 때 출력
                    System.out.print(calculator.getCalculateArr().stream().toList());
                    System.out.println("\n");

                } else if (choiNum.equals("2")) {      // 입력 값보다 높은 데이터 모두 조회
                    System.out.print("값 입력 : ");
                    String value = sc.next();       // 해당 값보다 높은 값을 조회하기 위한 입력 변수

                    if (value.equals("exit")) break;

                    try {
                        if (!Pattern.matches(DOUBLE_NUMBER_REG, value)) {
                            throw new BadInputException();
                        }
                        // 배열에서 입력 값보다 큰 값의 리스트들을 출력하는 Stream Lambda
                        System.out.print(calculator.getCalculateArr().stream().filter(arr -> arr > Double.parseDouble(value))
                                .toList());
                        System.out.println("\n");
                    } catch (BadInputException e) {
                        System.out.println(e.getMessage());
                    }
                } else System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n"); // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
            } else if (choice.equals("exit")) break;       // 계산기 나가기
            else System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");       // 잘못 입력시 처음으로 돌아가는 예외처리
        }
        System.out.println("계산기 종료...");
    }
}