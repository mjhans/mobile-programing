package com.bible.ch06.examples.HighFunction.FunctionTypes

/**
 * Unit 반환 타입 (Unit Return Type)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입에서 Unit 반환 타입을 다루는 방법을 학습합니다.
 * 일반 함수와 함수 타입에서 Unit의 차이를 이해합니다.
 */

fun main() {
    println("=".repeat(60))
    println("Unit 반환 타입 (Unit Return Type)")
    println("=".repeat(60))

    // 일반 함수에서는 Unit 생략 가능
    fun regularFunction() {  // Unit 반환 타입 생략
        println("Regular function")
    }

    // 함수 타입에서는 Unit 명시 필수
    val functionType: () -> Unit = {  // Unit을 명시해야 함
        println("Function type")
    }

    regularFunction()
    functionType()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 일반 함수: Unit 반환 타입 생략 가능")
    println("- 함수 타입: 반환 타입 항상 명시 필요 (Unit 포함)")
    println("- Unit: 값을 반환하지 않는 함수의 반환 타입")
    println("=".repeat(60))
}
