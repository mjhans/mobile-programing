package com.bible.ch06.examples.HighFunction.HigherOrderBasics

/**
 * Higher-Order Function의 정의 (Definition of Higher-Order Functions)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Higher-order function의 개념을 학습합니다.
 * 다른 함수를 인자로 받거나 함수를 반환하는 함수를 이해합니다.
 */

fun main() {
    println("=".repeat(60))
    println("Higher-Order Function의 정의")
    println("=".repeat(60))

    println("\nHigher-order function은:")
    println("- 다른 함수를 인자로 받거나")
    println("- 함수를 반환하는 함수입니다")
    println()
    println("예: list.filter { x > 0 }")
    println("→ filter는 predicate 함수를 인자로 받는 higher-order function")

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- Higher-order function: 함수를 값처럼 다룸")
    println("- 함수를 파라미터로 받거나 반환값으로 사용")
    println("- Kotlin 표준 라이브러리의 많은 함수들이 HOF")
    println("- 코드 재사용성과 추상화 수준 향상")
    println("=".repeat(60))
}
