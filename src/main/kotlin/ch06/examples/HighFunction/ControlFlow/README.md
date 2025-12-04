# 08. 람다의 제어 흐름 (Control Flow in Lambdas)

람다에서 return을 사용하는 다양한 방법을 학습합니다.

## 학습 목표
- Non-local return 이해하기
- Labeled return으로 local return하기
- Anonymous function 활용하기

## 예제 파일

### 기본 개념
1. **[LoopReturn.kt](LoopReturn.kt)** - 일반 루프에서 return
   - for 루프의 return은 함수 전체를 빠져나감
   - 일반적인 동작

2. **[NonLocalReturn.kt](NonLocalReturn.kt)** - Non-local return
   - Inline 함수의 람다에서 return
   - 외부 함수에서 반환됨
   - forEach는 inline이므로 가능

### Local Return
3. **[LabeledReturn.kt](LabeledReturn.kt)** - Label을 사용한 return
   - `label@` 선언하고 `return@label` 사용
   - 람다에서만 반환 (continue와 유사)

4. **[FunctionLabelReturn.kt](FunctionLabelReturn.kt)** - 함수 이름 label
   - `return@forEach` 패턴
   - 명시적 label 선언 불필요
   - 권장되는 방식

### Alternative
5. **[AnonymousFunction.kt](AnonymousFunction.kt)** - Anonymous function
   - `fun (person) { ... }` 형태
   - return은 자동으로 local
   - 여러 return 지점이 있을 때 유용

## 실행 방법
```bash
kotlinc NonLocalReturn.kt -include-runtime -d NonLocalReturn.jar && java -jar NonLocalReturn.jar
```

## 핵심 포인트
- Inline 함수의 람다: non-local return 가능
- Non-local return: 외부 함수에서 반환
- Labeled return: 람다에서만 반환
- Anonymous function: fun 키워드 사용, local return
- return은 가장 가까운 fun 키워드 함수에서 반환

## Return 종류 비교

| 종류 | 문법 | 반환 위치 |
|------|------|----------|
| Non-local | `return` | 외부 함수 |
| Labeled | `return@label` | 람다만 |
| Function name | `return@forEach` | 람다만 |
| Anonymous | `fun() { return }` | Anonymous function |
