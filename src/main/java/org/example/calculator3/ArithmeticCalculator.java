package org.example.calculator3;
import java.util.*;

public class ArithmeticCalculator<T extends Number> {
    private T firstNumber;
    private T secondNumber;
    private final List<T> ariArr = new ArrayList<>();

    private OperatorType operator;

    public T getFirstNumber() {
        return firstNumber;
    }

    public T getSecondNumber() {
        return secondNumber;
    }

    public List<T> getAriArr() {
        return ariArr;
    }

    public void setFirstNumber(T firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(T secondNumber) {
        this.secondNumber = secondNumber;
    }

    private void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public double calculate() {
        return this.operator.apply(this.getFirstNumber().doubleValue(), this.getSecondNumber().doubleValue());
    }

    public void basicOperation(String operation) {
        OperatorType op = switch(operation) {
            case "+" -> OperatorType.addOperation;
            case "-" -> OperatorType.subtractOperation;
            case "*" -> OperatorType.multiplyOperation;
            case "/" -> OperatorType.divideOperation;
            default -> throw new IllegalStateException();
        };

        setOperator(op);
    }

    public void deleteAriArr(int index) {
        this.ariArr.remove(index);
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