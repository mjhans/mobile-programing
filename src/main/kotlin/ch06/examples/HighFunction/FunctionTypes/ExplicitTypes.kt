package com.bible.ch06.examples.HighFunction.FunctionTypes

/**
 * 명시적 함수 타입 선언 (Explicit Function Types)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입을 명시적으로 선언하는 방법을 학습합니다.
 * 타입을 명시하면 코드 의도가 더 명확해지고, 람다 파라미터 타입을 생략할 수 있습니다.
 */

fun main() {
    println("=".repeat(60))
    println("명시적 함수 타입 선언 (Explicit Function Types)")
    println("=".repeat(60))

    // 명시적 타입 선언: 변수 타입을 명시하고 람다는 간결하게
    val sum: (Int, Int) -> Int = { x, y -> x + y }       // 두 Int를 받아 Int 반환
    val action: () -> Unit = { println(42) }              // 인자 없고 값 반환 안 함

    println("sum(10, 20) = ${sum(10, 20)}")  // 30
    action()  // 42

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수 타입 문법: (파라미터 타입들) -> 반환 타입")
    println("- 타입이 명시되면 람다에서 파라미터 타입 생략 가능")
    println("- 코드의 의도가 더 명확해짐")
    println("=".repeat(60))
}
