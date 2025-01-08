package org.example.calculator;
import java.util.*;

public class ArithmeticCalculator<T extends Number> {
    private T firstNumber;
    private T secondNumber;
    private final ArrayList<T> ariArr = new ArrayList<>();

    private OperatorType operator;

    public T getFirstNumber() {
        return firstNumber;
    }

    public T getSecondNumber() {
        return secondNumber;
    }

    public ArrayList<T> getAriArr() {
        return ariArr;
    }

    public void setFirstNumber(T firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(T secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public double calculate() {
        return this.operator.apply(this.getFirstNumber().doubleValue(), this.getSecondNumber().doubleValue());
    }


    public enum OperatorType {
        addOperation("+") {
            @Override
            public double apply(double stNum, double ndNum) { return stNum + ndNum; }
        },
        subtractOperation("-") {
            @Override
            public double apply(double stNum, double ndNum) { return stNum - ndNum; }
        },
        multiplyOperation("*") {
            @Override
            public double apply(double stNum, double ndNum) { return stNum * ndNum; }
        },
        divideOperation("/") {
            @Override
            public double apply(double stNum, double ndNum) { return stNum / ndNum; }
        };

        private final String oper;

        OperatorType(String oper) { this.oper = oper; }

        public String getOperatorType() { return oper; }

        public abstract double apply(double stNum, double ndNum);
    }
}