
package com.example.calculator;

public enum OperatorType {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
    public static OperatorType fromSymbol(String symbol) {

        for (OperatorType type : OperatorType.values()) {

            if (type.getSymbol().equals(symbol)) {
                return type;
            }
        }

        throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
    }
}
