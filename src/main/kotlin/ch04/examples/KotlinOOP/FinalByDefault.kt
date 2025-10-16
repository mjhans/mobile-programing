package com.bible.ch04.examples.KotlinOOP

/*
 * 기본 final과 명시적 open
 *
 * Kotlin: final by default (안전성 우선)
 * - 클래스와 메서드가 기본적으로 final
 * - "상속을 위한 설계와 문서화, 그렇지 않으면 상속을 금지하라" (Effective Java)
 *
 * Java: open by default (유연성 우선)
 * - 모든 메서드가 기본적으로 오버라이드 가능
 * - 명시적으로 final을 써야 상속 방지
 *
 * Fragile Base Class Problem (취약한 기반 클래스 문제)
 */

// ============================================
// 문제가 있는 설계 (Fragile Base Class Problem)
// ============================================

open class Counter {
    private var cnt = 0

    open fun increment() {
        cnt++
        println("  increment() 호출: count = $cnt")
    }

    open fun add(value: Int) {
        println("  add($value) 호출")
        for (i in 0 until value) {
            increment()  // increment()를 value번 호출
        }
    }

    fun getCount() = cnt
}

// 하위 클래스가 increment()를 오버라이드
class ProblematicCounter : Counter() {
    override fun increment() {
        println("    ProblematicCounter.increment() 오버라이드")
        super.increment()
        super.increment()  // 의도치 않은 중복 호출!
    }
}

// ============================================
// Kotlin의 안전한 접근법
// ============================================

// 기본 final로 안전성 확보
class SafeCounter {
    private var cnt = 0

    fun increment() {        // final - 오버라이드 불가
        cnt++
    }

    fun add(value: Int) {    // final - 오버라이드 불가
        repeat(value) { increment() }
    }

    fun getCount() = cnt
}

// ============================================
// 확장이 필요한 경우에만 open으로 설계
// ============================================

open class ExtensibleCounter {
    protected var cnt = 0

    open fun increment() {
        cnt++
        onIncrement()  // 확장 포인트 제공 (Template Method 패턴)
    }

    protected open fun onIncrement() {
        // 하위 클래스에서 오버라이드 가능한 훅
        // 기본 구현은 비어있음
    }

    final fun add(value: Int) {  // 핵심 로직은 final로 보호
        repeat(value) { increment() }
    }

    fun getCount() = cnt
}

class LoggingCounter : ExtensibleCounter() {
    override fun onIncrement() {
        println("    [LOG] count increased to $cnt")
    }
}

class AlertingCounter(private val threshold: Int) : ExtensibleCounter() {
    override fun onIncrement() {
        if (cnt >= threshold) {
            println("    ⚠️ [ALERT] Threshold reached: $cnt >= $threshold")
        }
    }
}

fun main() {
    println("=" .repeat(70))
    println("Kotlin: Final by Default (안전성 우선)")
    println("=" .repeat(70))

    // ============================================
    // Fragile Base Class Problem 시연
    // ============================================
    println("\n[Fragile Base Class Problem]")
    println("-".repeat(70))

    println("일반 Counter:")
    val counter = Counter()
    counter.add(3)  // increment()를 3번 호출 → 예상: count = 3
    println("✅ 최종 count: ${counter.getCount()}")

    println("\nProblematicCounter (increment 오버라이드):")
    val problematic = ProblematicCounter()
    problematic.add(3)  // increment()를 3번 호출하지만, 각 호출마다 2번 증가
    // 예상: 3, 실제: 6
    println("❌ 최종 count: ${problematic.getCount()} (예상: 3, 실제: 6)")
    println("   → increment()가 오버라이드되어 의도치 않은 동작 발생!")

    // ============================================
    // SafeCounter: 안전한 설계
    // ============================================
    println("\n" + "=".repeat(70))
    println("[SafeCounter - Final by Default]")
    println("-".repeat(70))

    val safeCounter = SafeCounter()
    safeCounter.add(3)
    println("✅ 최종 count: ${safeCounter.getCount()}")
    println("   → final 메서드이므로 오버라이드 불가 → 안전!")

    // ============================================
    // ExtensibleCounter: 설계된 확장성
    // ============================================
    println("\n" + "=".repeat(70))
    println("[ExtensibleCounter - 설계된 확장 포인트]")
    println("-".repeat(70))

    println("LoggingCounter:")
    val loggingCounter = LoggingCounter()
    loggingCounter.add(3)
    println("최종 count: ${loggingCounter.getCount()}")

    println("\nAlertingCounter (임계값: 5):")
    val alertingCounter = AlertingCounter(threshold = 5)
    alertingCounter.add(7)
    println("최종 count: ${alertingCounter.getCount()}")

}

/*
설계의 차이:
- add()는 final → 핵심 로직 보호
- increment()는 open → 하위 클래스가 오버라이드 가능
- onIncrement()는 open → 확장 포인트 제공 (훅)

→ 의도된 확장만 허용하여 안전성 확보

======================================================================
Java의 open by default 문제점
======================================================================
[Java]
public class Counter {
    private int count = 0;

    public void increment() {  // 기본적으로 오버라이드 가능
        count++;
    }

    public void add(int value) {  // 기본적으로 오버라이드 가능
        for (int i = 0; i < value; i++) {
            increment();
        }
    }
}

문제점:
❌ 모든 메서드가 오버라이드 가능
❌ 하위 클래스가 의도치 않게 동작 변경 가능
❌ Fragile Base Class Problem 발생 가능

[Kotlin]
class SafeCounter {
    private var count = 0

    fun increment() {  // 기본적으로 final
        count++
    }

    fun add(value: Int) {  // 기본적으로 final
        repeat(value) { increment() }
    }
}

장점:
✅ 기본적으로 final → 안전
✅ 확장이 필요한 경우에만 open 명시
✅ 실수로 인한 버그 방지

======================================================================
Kotlin Final by Default의 철학
======================================================================
✅ 안전성 우선:
   - 기본적으로 final → 의도치 않은 오버라이드 방지
   - Fragile Base Class Problem 예방

✅ 명시적 의도:
   - open 키워드로 확장 가능성을 명확히 표현
   - 설계자의 의도가 코드에 드러남

✅ 설계된 확장:
   - 핵심 로직은 final로 보호
   - 확장 포인트만 open으로 제공
   - Template Method 패턴 활용

✅ Effective Java 원칙:
   - "상속을 위한 설계와 문서화, 그렇지 않으면 상속을 금지하라"
   - Kotlin은 이 원칙을 언어 차원에서 강제

❌ Java의 문제:
   - 모든 메서드가 기본적으로 오버라이드 가능
   - 명시적으로 final을 써야 방지
   - 실수하기 쉽고 버그 발생 가능

핵심: 확장 가능성은 특권이 아니라 책임이다!
 */