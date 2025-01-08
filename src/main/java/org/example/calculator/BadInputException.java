package org.example.calculator;

public class BadInputException extends Exception {
    public BadInputException() {
        super("잘못된 값을 입력하셨습니다. 처음으로 돌아갑니다.\n");
    }
}
