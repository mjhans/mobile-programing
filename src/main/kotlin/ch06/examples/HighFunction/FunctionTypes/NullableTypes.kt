package com.bible.ch06.examples.HighFunction.FunctionTypes

/**
 * Nullable 타입의 두 가지 형태 (Nullable Types)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Nullable 반환 타입과 Nullable 함수 타입의 차이를 학습합니다.
 * 괄호의 위치가 nullable의 범위를 어떻게 결정하는지 이해합니다.
 */

fun main() {
    println("=".repeat(60))
    println("Nullable 타입의 두 가지 형태 (Nullable Types)")
    println("=".repeat(60))

    // 1. Nullable 반환 타입을 가진 함수
    var canReturnNull: (Int, Int) -> Int? = { x, y -> null }
    println("canReturnNull(1, 2) = ${canReturnNull(1, 2)}")  // null

    // 함수 자체는 null이 아니므로 호출 가능
    canReturnNull = { x, y -> x + y }
    println("canReturnNull(3, 4) = ${canReturnNull(3, 4)}")  // 7

    println()

    // 2. Nullable 함수 타입 변수
    var funOrNull: ((Int, Int) -> Int)? = null
    println("funOrNull이 null일 때:")
    // funOrNull(1, 2)  // ERROR: funOrNull은 null일 수 있음

    // Safe call로 호출
    println("funOrNull?.invoke(1, 2) = ${funOrNull?.invoke(1, 2)}")  // null

    // 함수 할당 후 호출
    funOrNull = { x, y -> x * y }
    println("\nfunOrNull이 함수일 때:")
    println("funOrNull?.invoke(5, 6) = ${funOrNull?.invoke(5, 6)}")  // 30

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- (Int, Int) -> Int? : 함수는 항상 존재, 반환값이 null 가능")
    println("- ((Int, Int) -> Int)? : 함수 자체가 null 가능")
    println("- 괄호 위치가 의미를 결정!")
    println("- Nullable 함수 타입은 invoke()와 safe-call 필요")
    println("=".repeat(60))
}
