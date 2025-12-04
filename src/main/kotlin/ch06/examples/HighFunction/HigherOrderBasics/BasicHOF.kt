package com.bible.ch06.examples.HighFunction.HigherOrderBasics

/**
 * 간단한 Higher-Order Function (Basic Higher-Order Function)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 가장 기본적인 higher-order function을 작성하고 사용하는 방법을 학습합니다.
 * 같은 함수에 다른 연산 로직을 전달하여 다양한 동작을 수행할 수 있습니다.
 */

/**
 * Listing 10.1: 간단한 higher-order function 정의
 */
fun twoAndThree(operation: (Int, Int) -> Int) {  // 함수 타입 파라미터 선언
    val result = operation(2, 3)                 // 함수 타입 파라미터 호출
    println("The result is $result")
}

fun main() {
    println("=".repeat(60))
    println("간단한 Higher-Order Function")
    println("=".repeat(60))

    println("\n덧셈 연산:")
    twoAndThree { a, b -> a + b }  // The result is 5

    println("\n곱셈 연산:")
    twoAndThree { a, b -> a * b }  // The result is 6

    println("\n최댓값 연산:")
    twoAndThree { a, b -> if (a > b) a else b }  // The result is 3

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 같은 함수에 다른 연산(람다)을 전달하여 다른 동작 수행")
    println("- operation 파라미터에 함수 타입 (Int, Int) -> Int 사용")
    println("- 람다로 구체적인 연산 로직 전달")
    println("- 코드 재사용과 유연성 향상")
    println("=".repeat(60))
}
