# 01. 함수 타입 (Function Types)

함수를 값으로 다루는 방법을 학습합니다.

## 학습 목표
- 함수 타입 문법 이해하기
- 타입 추론 vs 명시적 타입 선언
- Nullable 함수 타입과 반환 타입의 차이

## 예제 파일

### 기본 개념
1. **[TypeInference.kt](TypeInference.kt)** - 함수 타입 추론
   - 컴파일러가 자동으로 함수 타입 추론
   - `val sum = { x: Int, y: Int -> x + y }`

2. **[ExplicitTypes.kt](ExplicitTypes.kt)** - 명시적 함수 타입 선언
   - `val sum: (Int, Int) -> Int = { x, y -> x + y }`
   - 타입이 명시되면 람다에서 파라미터 타입 생략 가능

3. **[FunctionTypeSyntax.kt](FunctionTypeSyntax.kt)** - 함수 타입 문법
   - 파라미터 개수에 따른 함수 타입 표현
   - `() -> String`, `(Int) -> String`, `(Int, Int) -> Int`

### 특수 케이스
4. **[UnitReturnType.kt](UnitReturnType.kt)** - Unit 반환 타입
   - 일반 함수 vs 함수 타입에서 Unit 처리 차이
   - 함수 타입에서는 Unit을 명시해야 함

5. **[NullableTypes.kt](NullableTypes.kt)** - Nullable 타입
   - `(Int, Int) -> Int?` : 반환값이 null 가능
   - `((Int, Int) -> Int)?` : 함수 자체가 null 가능
   - 괄호 위치가 의미를 결정!

### 고급 주제
6. **[ComplexTypes.kt](ComplexTypes.kt)** - 복잡한 함수 타입
   - 함수를 반환하는 함수: `(Int) -> (Int) -> Int`
   - 함수를 파라미터로 받는 함수

7. **[NamedParameters.kt](NamedParameters.kt)** - 파라미터 이름
   - `(operandA: Int, operandB: Int) -> Int`
   - 문서화와 IDE 힌트를 위한 이름 지정

## 실행 방법
각 파일을 독립적으로 실행할 수 있습니다:
```bash
kotlinc TypeInference.kt -include-runtime -d TypeInference.jar && java -jar TypeInference.jar
```

또는 IntelliJ IDEA에서 각 파일의 main() 함수를 직접 실행하세요.

## 핵심 포인트
- 함수 타입 문법: `(파라미터 타입들) -> 반환 타입`
- 타입 추론을 사용하거나 명시적으로 선언 가능
- Nullable의 두 가지 형태: 반환값 nullable vs 함수 nullable
- 함수 타입도 중첩하여 복잡한 구조 구성 가능
