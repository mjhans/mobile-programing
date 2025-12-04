package com.bible.ch06.examples.HighFunction.HigherOrderBasics

/**
 * 함수 타입 파라미터 호출하기 (Calling Function Parameters)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입 파라미터를 일반 함수처럼 호출하는 방법을 학습합니다.
 * 함수 타입 파라미터는 일반 함수와 동일한 방식으로 호출됩니다.
 */

fun calculate(
    x: Int,
    y: Int,
    operation: (Int, Int) -> Int
): Int {
    // 함수 타입 파라미터를 일반 함수처럼 호출
    return operation(x, y)
}

fun main() {
    println("=".repeat(60))
    println("함수 타입 파라미터 호출하기")
    println("=".repeat(60))

    val sum = calculate(10, 5) { a, b -> a + b }
    val product = calculate(10, 5) { a, b -> a * b }
    val difference = calculate(10, 5) { a, b -> a - b }

    println("calculate(10, 5, +) = $sum")        // 15
    println("calculate(10, 5, *) = $product")    // 50
    println("calculate(10, 5, -) = $difference") // 5

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수 타입 파라미터를 호출하는 문법은 일반 함수와 동일")
    println("- 함수_이름(인자들) 형태로 호출")
    println("- 전달된 람다가 operation 파라미터로 실행됨")
    println("=".repeat(60))
}
