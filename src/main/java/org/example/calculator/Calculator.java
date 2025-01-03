package org.example.calculator;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> calArr = new ArrayList<>();

        while(true) {
            System.out.println("계산기에서 나가시려면 언제든지 exit을 입력해주세요!");

            System.out.println("1. 계산기, 2. 삭제, 3. 조회, 나가기: exit");
            System.out.print("입력 : ");
            String choice = sc.next();      // 실행할 행동 선택

            if(choice.equals("1")) {        // 계산기 실행
                double value = 0;

                System.out.print("첫 번째 숫자를 입력해주세요 (음수 제외) : ");
                String val1 = sc.next();

                if(val1.equals("exit")) break;

                try {       // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                    double test = Double.parseDouble(val1);
                } catch (Exception e) {
                    System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");
                    continue;
                }

                double value1 = Double.parseDouble(val1);       // val1을 String -> double로 형변환
                if(value1 < 0) {    // 음수 입력 시 처음으로 돌아가게 하는 예외 처리문
                    System.out.println("양수만 입력해주세요. 처음으로 돌아갑니다.\n");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력해주세요 (음수 제외) : ");
                String val2 = sc.next();

                if(val2.equals("exit")) break;

                try {       // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                    double test = Double.parseDouble(val2);
                } catch (Exception e) {
                    System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");
                    continue;
                }

                double value2 = Double.parseDouble(val2);       // val2를 String -> double로 형변환
                if(value2 < 0) {        // 음수 입력 시 처음으로 돌아가게 하는 예외 처리문
                    System.out.println("양수만 입력해주세요. 처음으로 돌아갑니다.\n");
                    continue;
                }

                System.out.print("사칙연산 기호를 입력해주세요 (+, -, *, /) : ");
                String operator = sc.next();
                if(operator.equals("exit")) break;

                // 연산자 입력 오류 예외처리
                if(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
                    System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");
                    continue;
                }
                char op = operator.charAt(0);       // 사칙연산 기호

                switch(op) {
                    case '+':
                        value = value1 + value2;
                        break;
                    case '-':
                        value = value1 - value2;
                        break;
                    case '*':
                        value = value1 * value2;
                        break;
                    case '/':
                        value = value1 / value2;
                        break;
                }
                System.out.println("계산 결과 : " + value + "\n");
                calArr.add(value);              // 배열에 계산한 값 추가
            }


            else if(choice.equals("2")) {   // 계산 데이터 삭제
                if(calArr.isEmpty()) {          // 계산 데이터가 없을 때 처음으로 돌아가는 예외 처리문
                    System.out.println("삭제할 컬렉션이 없습니다..\n");
                }
                else {
                    System.out.println("첫 번째 값이 삭제되었습니다! 삭제된 값 : " + calArr.get(0) + "\n");
                    calArr.remove(0);
                }
            }


            else if(choice.equals("3")) {         // 계산 데이터 조회
                System.out.println("1. 모든 데이터 조회, 2. 해당 값보다 높은 데이터 조회");
                System.out.print("입력 : ");
                String choiNum = sc.next();         // 어떤 데이터를 조회할지 입력

                if(choiNum.equals("exit")) break;       // 계산기 나가기

                else if(choiNum.equals("1")) {      // 현재 배열 데이터 모두 조회
                    if(calArr.isEmpty()) {          // 배열이 비어있을 때 처음으로 돌아가는 예외 처리문
                        System.out.println("조회할 컬렉션이 없습니다. 처음으로 돌아갑니다.\n");
                    }
                    else {          // 배열에 값이 있을 때 출력
                        System.out.print("현재 배열 데이터 : [ ");
                        for(double i : calArr) {
                            if(i != calArr.get(calArr.size()-1)) System.out.print(i + ", ");
                            else System.out.print(i);
                        }
                        System.out.print(" ]\n");
                        System.out.println();
                    }
                }

                else if(choiNum.equals("2")) {      // 입력 값보다 높은 데이터 모두 조회
                    if(calArr.isEmpty()) {
                        System.out.println("조회할 컬렉션이 없습니다. 처음으로 돌아갑니다.\n");
                    }
                    else {
                        System.out.print("값 입력 : ");
                        String value = sc.next();       // 해당 값보다 높은 값을 조회하기 위한 입력 변수
                        ArrayList<Double> moreArr = new ArrayList<>();

                        if(value.equals("exit")) break;

                        try {           // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                            double test = Double.parseDouble(value);
                        } catch(Exception e) {
                            System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");
                        }
                        double moreVal = Double.parseDouble(value);

                        for(double i : calArr) {        // 입력 값보다 큰 값들을 새 배열에 추가
                            if(i > moreVal) {
                                moreArr.add(i);
                            }
                        }

                        // 추가된 배열을 출력
                        System.out.print(moreVal + " 보다 큰 값들 : [ ");
                        for(double i : moreArr) {
                            if(i != moreArr.get(moreArr.size()-1)) System.out.print(i + ", ");
                            else System.out.print(i);
                        }
                        System.out.print(" ]\n");
                        System.out.println();
                    }
                }
                // exit와 숫자가 아닌 다른 값을 입력했을 때 처음으로 돌아가게 하는 예외 처리문
                else System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");
            }

            else if(choice.equals("exit")) break;       // 계산기 나가기

            else System.out.println("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");       // 잘못 입력시 처음으로 돌아가는 예외처리
        }

        System.out.println("계산기 종료...");
    }
}