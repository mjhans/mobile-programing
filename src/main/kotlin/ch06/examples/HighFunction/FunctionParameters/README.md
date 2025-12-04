# 03. 함수 타입 파라미터 (Function Parameters)

함수 타입 파라미터의 기본값과 nullable 처리 방법을 학습합니다.

## 학습 목표
- 함수 타입 파라미터에 기본값 제공하기
- Nullable 함수 타입 파라미터 사용하기
- invoke() 메서드와 safe-call 이해하기

## 예제 파일

### 기본 개념
1. **[BasicJoinToString.kt](BasicJoinToString.kt)** - 기본 joinToString
   - 하드코딩된 toString 사용의 한계
   - 유연성이 제한된 구현

2. **[DefaultLambda.kt](DefaultLambda.kt)** - 함수 타입 파라미터에 기본값
   - `transform: (T) -> String = { it.toString() }`
   - 기본값이 있어 생략 가능

### Nullable 처리
3. **[NullableLambda.kt](NullableLambda.kt)** - Nullable 함수 타입
   - `transform: ((T) -> String)? = null`
   - null을 명시적으로 전달 가능

4. **[InvokeMethod.kt](InvokeMethod.kt)** - invoke() 메서드
   - `lambda.invoke(args)` vs `lambda(args)`
   - `transform?.invoke(element)` 패턴

### 실전 패턴
5. **[VariousPatterns.kt](VariousPatterns.kt)** - 다양한 패턴
   - 기본값과 nullable 조합
   - 유연한 API 설계

6. **[RealWorldExample.kt](RealWorldExample.kt)** - 로깅 시스템
   - Nullable 함수 타입으로 선택적 커스터마이징
   - 실무 적용 예제

## 실행 방법
```bash
kotlinc DefaultLambda.kt -include-runtime -d DefaultLambda.jar && java -jar DefaultLambda.jar
```

## 핵심 포인트
- 함수 타입 파라미터에 람다를 기본값으로 지정 가능
- Nullable 함수 타입 `((T) -> R)?`으로 선택적 함수 전달
- invoke()와 safe-call 조합: `transform?.invoke(element)`
- 함수 타입은 invoke() 메서드를 가진 인터페이스
- 기본값과 nullable을 활용하여 유연한 API 설계
