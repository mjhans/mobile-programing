# 06. Inline Functions

Inline 함수의 동작 원리와 성능 최적화를 학습합니다.

## 학습 목표
- Inline 함수의 동작 원리 이해하기
- 람다 오버헤드 제거 방법 학습하기
- Inline 사용 시기 판단하기

## 예제 파일

1. **[InlineExample.kt](InlineExample.kt)** - Inline 함수 기본
   - `inline fun <T> synchronized(lock: Lock, action: () -> T)`
   - 호출 위치에 코드 직접 삽입
   - 표준 라이브러리의 filter, map 등

2. **[PerformanceComparison.kt](PerformanceComparison.kt)** - 성능 비교
   - Non-inline vs Inline 차이
   - 람다 객체 생성 오버헤드
   - 메모리와 성능 영향

## 실행 방법
```bash
kotlinc InlineExample.kt -include-runtime -d InlineExample.jar && java -jar InlineExample.jar
```

## 핵심 포인트
- inline 함수는 호출 위치에 코드가 직접 삽입됨
- 람다의 오버헤드(객체 생성) 제거
- 표준 라이브러리의 filter, map 등은 inline
- 큰 함수는 inline 비추천 (코드 크기 증가)
- 성능이 중요한 작은 함수에 사용

## 언제 Inline 사용?
- ✅ 작은 함수, 특히 람다를 받는 함수
- ✅ 성능이 중요한 경우
- ✅ 표준 라이브러리의 컬렉션 연산들
- ❌ 큰 함수 (코드 크기 증가)
- ❌ 재귀 함수
