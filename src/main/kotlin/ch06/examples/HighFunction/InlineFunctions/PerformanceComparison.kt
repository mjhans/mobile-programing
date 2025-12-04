package com.bible.ch06.examples.HighFunction.InlineFunctions

/**
 * Inline vs Non-inline 성능 비교
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Inline 함수의 성능 이점을 이해합니다.
 * 일반 higher-order function과 inline function의 차이를 비교합니다.
 */

// Non-inline 함수
fun <T> nonInlineFilter(list: List<T>, predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in list) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

// Inline 함수
inline fun <T> inlineFilter(list: List<T>, predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in list) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun main() {
    println("=".repeat(60))
    println("Inline vs Non-inline 성능 비교")
    println("=".repeat(60))

    val numbers = (1..10).toList()

    // Non-inline 사용
    println("\nNon-inline filter:")
    val evenNonInline = nonInlineFilter(numbers) { it % 2 == 0 }
    println("  짝수: $evenNonInline")
    println("  → 람다가 객체로 생성되어 오버헤드 발생")

    // Inline 사용
    println("\nInline filter:")
    val evenInline = inlineFilter(numbers) { it % 2 == 0 }
    println("  짝수: $evenInline")
    println("  → 람다 코드가 직접 삽입되어 오버헤드 없음")

    println("\n" + "=".repeat(60))
    println("핵심 차이:")
    println("=".repeat(60))
    println("Non-inline:")
    println("  - 람다가 Function 객체로 생성됨")
    println("  - 함수 호출 오버헤드 발생")
    println("  - 메모리 할당 필요")
    println()
    println("Inline:")
    println("  - 람다 코드가 호출 위치에 직접 삽입")
    println("  - 함수 호출 오버헤드 없음")
    println("  - 객체 생성 없음")
    println()
    println("언제 inline 사용?")
    println("  - 작은 함수, 특히 람다를 받는 함수")
    println("  - 성능이 중요한 경우")
    println("  - 표준 라이브러리의 컬렉션 연산들")
    println("=".repeat(60))
}
