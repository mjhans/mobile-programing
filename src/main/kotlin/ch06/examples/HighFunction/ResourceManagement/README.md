# 07. 리소스 관리 (Resource Management)

use, withLock 등 리소스 관리 패턴을 학습합니다.

## 학습 목표
- use 함수로 자동 리소스 해제하기
- withLock으로 안전한 동기화하기
- 여러 리소스 안전하게 관리하기

## 예제 파일

1. **[UseFunction.kt](UseFunction.kt)** - use 함수
   - `resource.use { res -> ... }`
   - AutoCloseable 리소스 자동 닫기
   - Java의 try-with-resources와 유사

2. **[WithLock.kt](WithLock.kt)** - withLock 패턴
   - `lock.withLock { ... }`
   - 락 자동 해제
   - 데드락 위험 감소

3. **[MultipleResources.kt](MultipleResources.kt)** - 여러 리소스
   - 중첩된 use 사용
   - 안쪽에서 바깥쪽 순서로 닫힘
   - 리소스 누수 방지

## 실행 방법
```bash
kotlinc UseFunction.kt -include-runtime -d UseFunction.jar && java -jar UseFunction.jar
```

## 핵심 포인트
- use: 리소스를 자동으로 닫음 (try-with-resources)
- withLock: 락을 자동으로 해제
- 예외 발생 시에도 리소스 정리 보장
- Java보다 간결한 리소스 관리

## 사용 패턴
```kotlin
// use 패턴
resource.use { res ->
    // 리소스 사용
} // 자동으로 close() 호출

// withLock 패턴
lock.withLock {
    // 보호된 코드
} // 자동으로 unlock()
```
