
# Java 콘솔 계산기 (STEP 1~3)

Java를 활용하여 제작한 콘솔 기반 사칙연산 계산기입니다.

기본 문법부터 객체지향 프로그래밍, Enum, 제네릭,
람다와 스트림까지 단계별로 적용했습니다.

## 개발 환경

- Java 17 이상
- IntelliJ IDEA
- Git / GitHub
- 콘솔 기반 프로그램

## 프로젝트 구조

src/com/example/calculator/
- Main.java : 사용자 입력, 검증, 출력 및 반복 처리
- Calculator.java : 사칙연산, 결과 저장 및 조회
- OperatorType.java : Enum을 활용한 연산자 관리

## STEP 1. 기본 계산기

- Scanner를 이용한 숫자 입력
- 덧셈, 뺄셈, 곱셈, 나눗셈 구현
- if / else if 조건문 활용
- while 반복문 활용
- 잘못된 숫자 및 연산자 입력 검증
- 0으로 나누는 상황 처리
- exit 입력 시 프로그램 종료

## STEP 2. 객체지향 계산기

- Main과 Calculator 클래스 분리
- calculate() 메서드를 통한 연산 수행
- ArrayList를 이용한 계산 결과 저장
- getResults()를 통한 결과 조회
- removeResult()를 통한 가장 오래된 결과 삭제
- private 필드와 불변 목록 반환을 통한 캡슐화

## STEP 3. 도전 기능

### 1. Enum 적용

- OperatorType 열거형 생성
- ADD, SUBTRACT, MULTIPLY, DIVIDE 정의
- fromSymbol()을 통해 문자열을 Enum으로 변환
- Enum을 이용한 사칙연산 분기 처리

### 2. 제네릭 적용

- <T extends Number>를 이용한 계산 메서드
- Integer, Double 등 숫자 타입 지원
- doubleValue()를 이용한 연산
- 실수 입력과 소수점 계산 지원

### 3. 람다와 스트림

- stream()으로 저장된 계산 결과 처리
- filter()와 람다 표현식으로 결과 필터링
- 입력한 기준값보다 큰 계산 결과 조회
- map()과 String.format()을 활용한 출력 형식 개선

## 실행 예시

첫 번째 숫자 : 10.5
두 번째 숫자 : 2.3
연산자 : +
계산 결과 : 12.80
저장된 계산 결과 : [12.80]

## 예외 처리

- 숫자가 아닌 문자 입력
- 음수 입력
- 잘못된 연산자 입력
- 0으로 나누는 경우

## 실행 방법

1. 프로젝트를 IntelliJ IDEA에서 엽니다.
2. Java 17 이상의 JDK를 설정합니다.
3. Main.java를 실행합니다.
4. 숫자 두 개와 연산자를 입력합니다.
5. 계산 결과 조회, 삭제 또는 종료 기능을 이용합니다.

## 학습 내용

- 변수와 자료형
- 조건문과 반복문
- break와 continue
- 클래스와 객체
- 메서드 및 반환값
- 컬렉션과 캡슐화
- Enum과 제네릭
- 람다 표현식과 Stream API

## 트러블슈팅

- 변수의 유효 범위(Scope) 문제
- 중괄호 위치에 따른 컴파일 오류
- continue와 break의 실행 흐름
- 정수 및 실수 입력 검증
- double 부동소수점 정밀도 문제
- 람다 표현식 문법 오류
