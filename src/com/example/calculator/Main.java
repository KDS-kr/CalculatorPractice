
package com.example.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Java 계산기 ===");

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 계산기 전체 반복
        while (true) {

            // 첫 번째 숫자 입력
            double num1;

            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요 : ");

                if (sc.hasNextDouble()) {
                    num1 = sc.nextDouble();

                    if (num1 >= 0) {
                        break;
                    } else {
                        System.out.println("0 이상의 정수를 입력하세요.");
                    }

                } else {
                    System.out.println("정수를 입력하세요.");
                    sc.next();
                }
            }

            // 두 번째 숫자 입력
            double num2;

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요 : ");

                if (sc.hasNextDouble()) {
                    num2 = sc.nextDouble();

                    if (num2 >= 0) {
                        break;
                    } else {
                        System.out.println("0 이상의 정수를 입력하세요.");
                    }

                } else {
                    System.out.println("정수를 입력하세요.");
                    sc.next();
                }
            }

            // 연산자 입력 및 계산
            while (true) {

                System.out.print("연산자를 입력하세요 (+, -, *, /) : ");
                String operator = sc.next();

                // 올바른 연산자인지 검사
                if (!operator.equals("+") &&
                        !operator.equals("-") &&
                        !operator.equals("*") &&
                        !operator.equals("/")) {

                    System.out.println("올바른 연산자를 입력하세요.");
                    continue;
                }

                // 0으로 나누는 경우
                if (operator.equals("/") && num2 == 0) {

                    System.out.println("0으로 나눌 수 없습니다.");

                    while (true) {
                        System.out.print("두 번째 숫자를 다시 입력하세요 : ");

                        if (sc.hasNextInt()) {
                            int newNum2 = sc.nextInt();

                            if (newNum2 >= 0) {
                                num2 = newNum2;
                                break;
                            } else {
                                System.out.println("0 이상의 정수를 입력하세요.");
                            }

                        } else {
                            System.out.println("정수를 입력하세요.");
                            sc.next();
                        }
                    }

                    // 연산자를 다시 선택
                    continue;
                }

                // Calculator 객체에 계산 요청
                OperatorType operatorType = OperatorType.fromSymbol(operator);

                Number result = calculator.calculate(num1, num2, operatorType);

                System.out.printf("계산 결과 : %.2f%n", result.doubleValue());
                break;
            }

            // 저장된 계산 결과 출력
            System.out.println("저장된 계산 결과 : " +
                    calculator.getResults().stream()
                            .map(num -> String.format("%.2f", num.doubleValue()))
                            .toList());

            // 기준값보다 큰 결과 조회
            System.out.print("특정 값보다 큰 결과를 조회하시겠습니까? (yes) : ");
            String searchChoice = sc.next();

            if (searchChoice.equalsIgnoreCase("yes")) {

                while (true) {
                    System.out.print("기준값을 입력하세요 : ");

                    if (sc.hasNextDouble()) {
                        double threshold = sc.nextDouble();

                        System.out.println("기준값보다 큰 결과 : "
                                + calculator.getResultsGreaterThan(threshold));

                        break;
                    } else {
                        System.out.println("올바른 숫자를 입력하세요.");
                        sc.next();
                    }
                }
            }
            // 종료 및 결과 삭제 선택
            System.out.print("종료(exit), 가장 오래된 결과 삭제(remove), 계속(아무거나) : ");
            String choice = sc.next();

            if (choice.equals("exit")) {
                break;

            } else if (choice.equals("remove")) {

                calculator.removeResult();

                System.out.println("삭제 후 결과 목록 : " + calculator.getResults());
            }
        }

        sc.close();
    }
}
