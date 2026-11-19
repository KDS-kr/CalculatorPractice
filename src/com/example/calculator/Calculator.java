
package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 계산 결과 저장 목록
    private final List<Number> results = new ArrayList<>();

    // 제네릭을 사용한 사칙연산 메서드
    public <T extends Number> Number calculate(
            T num1, T num2, OperatorType operator) {

        // 다양한 숫자 타입을 double로 변환
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();

        Number result;

        // 덧셈
        if (operator == OperatorType.ADD) {
            result = n1 + n2;

            // 뺄셈
        } else if (operator == OperatorType.SUBTRACT) {
            result = n1 - n2;

            // 곱셈
        } else if (operator == OperatorType.MULTIPLY) {
            result = n1 * n2;

            // 나눗셈
        } else if (operator == OperatorType.DIVIDE) {

            if (n2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }

            result = n1 / n2;

        } else {
            throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
        }

        // 계산 결과 저장
        results.add(result);

        // 계산 결과 반환
        return result;
    }

    // 저장된 계산 결과 조회 (외부 수정 방지)
    public List<Number> getResults() {
        return List.copyOf(results);
    }

    // 가장 오래된 계산 결과 삭제
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);

        }}
    public List<Number> getResultsGreaterThan(double threshold) {

        return results.stream()
                .filter(result -> result.doubleValue() > threshold)
                .toList();
        }
    }

