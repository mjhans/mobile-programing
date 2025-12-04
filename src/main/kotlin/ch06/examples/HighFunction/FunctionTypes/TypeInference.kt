package com.bible.ch06.examples.HighFunction.FunctionTypes

/**
 * 함수 타입 추론 (Function Type Inference)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 컴파일러가 함수 타입을 자동으로 추론하는 방법을 학습합니다.
 * 타입 추론을 사용하면 코드가 더 간결해지지만, 때로는 명시적 타입이 더 명확할 수 있습니다.
 */

fun main() {
    println("=".repeat(60))
    println("함수 타입 추론 (Function Type Inference)")
    println("=".repeat(60))

    // 타입 추론 사용: 컴파일러가 함수 타입을 자동으로 추론
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }

    // 실행
    println("sum(3, 5) = ${sum(3, 5)}")  // 8
    action()  // 42

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 컴파일러가 sum의 타입을 (Int, Int) -> Int로 추론")
    println("- action의 타입을 () -> Unit로 추론")
    println("- 람다 내부의 파라미터 타입으로부터 전체 함수 타입 결정")
    println("=".repeat(60))
}
