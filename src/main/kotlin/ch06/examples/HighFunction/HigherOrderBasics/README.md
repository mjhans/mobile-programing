# 02. Higher-Order Functions 기초

Higher-order function의 기본 개념과 사용법을 학습합니다.

## 학습 목표
- Higher-order function의 정의 이해하기
- 함수를 인자로 받는 함수 작성하기
- 전달된 함수 호출하고 활용하기

## 예제 파일

### 개념 이해
1. **[Definition.kt](Definition.kt)** - Higher-Order Function의 정의
   - 함수를 인자로 받거나 함수를 반환하는 함수
   - 예: `list.filter { x > 0 }`

### 기본 사용법
2. **[BasicHOF.kt](BasicHOF.kt)** - 간단한 Higher-Order Function
   - `twoAndThree(operation: (Int, Int) -> Int)`
   - 같은 함수에 다른 연산 로직 전달

3. **[CallingFunctionParameter.kt](CallingFunctionParameter.kt)** - 함수 타입 파라미터 호출
   - 함수 타입 파라미터를 일반 함수처럼 호출
   - `operation(x, y)` 형태로 호출

### 실전 구현
4. **[FilterImplementation.kt](FilterImplementation.kt)** - Filter 함수 구현
   - String.filter 직접 구현하기
   - predicate로 각 문자 검사

5. **[VariousHOFs.kt](VariousHOFs.kt)** - 다양한 Higher-Order Functions
   - customFilter, customMap 구현
   - 재사용 가능한 알고리즘 작성

### 고급 사용법
6. **[FunctionReferences.kt](FunctionReferences.kt)** - 함수 참조
   - 람다 대신 함수 참조 전달: `::isEven`
   - 이미 정의된 함수 재사용

## 실행 방법
각 파일을 독립적으로 실행할 수 있습니다:
```bash
kotlinc BasicHOF.kt -include-runtime -d BasicHOF.jar && java -jar BasicHOF.jar
```

## 핵심 포인트
- Higher-order function: 함수를 인자로 받거나 반환하는 함수
- 함수 타입으로 파라미터를 선언하여 함수를 인자로 받음
- 전달된 함수는 일반 함수처럼 호출 가능
- 람다나 함수 참조(::)를 인자로 전달 가능
- 재사용 가능한 알고리즘을 작성하는 강력한 도구
