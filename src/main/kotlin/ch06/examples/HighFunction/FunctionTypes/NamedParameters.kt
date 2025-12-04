package com.bible.ch06.examples.HighFunction.FunctionTypes

/**
 * 함수 타입의 파라미터 이름 (Named Parameters in Function Types)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입에 파라미터 이름을 부여하는 방법을 학습합니다.
 * 파라미터 이름은 코드 가독성과 IDE 힌트에 도움을 줍니다.
 */

fun main() {
    println("=".repeat(60))
    println("함수 타입의 파라미터 이름 (Named Parameters)")
    println("=".repeat(60))

    // 파라미터에 이름을 부여할 수 있음 (문서화 목적)
    val calculator: (operandA: Int, operandB: Int) -> Int = { a, b -> a + b }

    // 실제 람다에서는 다른 이름 사용 가능
    val multiplier: (first: Int, second: Int) -> Int = { x, y -> x * y }

    println("calculator(10, 5) = ${calculator(10, 5)}")    // 15
    println("multiplier(10, 5) = ${multiplier(10, 5)}")    // 50

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 파라미터 이름은 타입 체킹에 영향을 주지 않음")
    println("- 코드 가독성과 IDE의 힌트를 위해 사용")
    println("- 함수 타입의 파라미터 이름과 람다의 파라미터 이름은 독립적")
    println("- 문서화 및 코드 이해도 향상에 도움")
    println("=".repeat(60))
}
