# 04. 함수를 반환하는 함수 (Returning Functions)

함수를 반환하는 함수를 작성하는 방법을 학습합니다.

## 학습 목표
- 함수 타입을 반환 타입으로 지정하기
- 클로저(Closure)와 변수 캡처 이해하기
- 함수 팩토리 패턴 활용하기

## 예제 파일

### 기본 개념
1. **[BasicReturningFunction.kt](BasicReturningFunction.kt)** - 기본 예제
   - `fun getMultiplier(factor: Int): (Int) -> Int`
   - 함수를 반환하는 기본 패턴

### 실전 예제
2. **[ShippingCalculator.kt](ShippingCalculator.kt)** - 배송비 계산기
   - 배송 방식에 따라 다른 계산 함수 반환
   - 조건에 따른 함수 선택

3. **[UIFiltering.kt](UIFiltering.kt)** - UI 필터링 시스템
   - 설정에 따라 동적으로 필터 조합
   - 여러 조건을 하나의 predicate로 결합

### 디자인 패턴
4. **[FunctionFactory.kt](FunctionFactory.kt)** - 함수 팩토리
   - 파라미터로 맞춤형 함수 생성
   - `createValidator(minLength, maxLength)`

5. **[Closure.kt](Closure.kt)** - 클로저
   - 외부 변수 캡처하기
   - 각 함수가 독립적인 상태 유지

### 고급 주제
6. **[LoggingSystem.kt](LoggingSystem.kt)** - 로깅 시스템
   - 설정을 캡처하는 로거 생성
   - 실무 적용 패턴

7. **[Chaining.kt](Chaining.kt)** - 함수 체이닝
   - `(Int) -> (Int) -> Int` 구조
   - 커링(Currying) 패턴

## 실행 방법
```bash
kotlinc Closure.kt -include-runtime -d Closure.jar && java -jar Closure.jar
```

## 핵심 포인트
- 함수 타입을 반환 타입으로 지정하여 함수 반환
- 람다, 멤버 참조, 함수 타입 변수를 return 가능
- 클로저: 람다가 외부 변수를 캡처
- 반환된 함수를 변수에 저장하거나 즉시 호출
- 함수 팩토리 패턴으로 맞춤형 함수 생성
