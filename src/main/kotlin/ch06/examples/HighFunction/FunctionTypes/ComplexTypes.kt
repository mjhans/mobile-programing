package com.bible.ch06.examples.HighFunction.FunctionTypes
/**
 * 복잡한 함수 타입 (Complex Function Types)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수를 반환하는 함수 타입과 함수를 파라미터로 받는 함수 타입을 학습합니다.
 * 함수 타입의 중첩을 통해 더 복잡한 구조를 만들 수 있습니다.
 */

fun main() {
    println("=".repeat(60))
    println("복잡한 함수 타입 (Complex Function Types)")
    println("=".repeat(60))

    // 함수를 반환하는 함수 타입
    val higherOrder: (Int) -> (Int) -> Int = { x ->
        { y -> x + y }
    }

    val add5 = higherOrder(5)
    println("higherOrder(5)(10) = ${add5(10)}")  // 15

    // 함수를 파라미터로 받는 함수 타입
    val processor: ((Int) -> Int, Int) -> Int = { func, value ->
        func(value) * 2
    }

    val double = processor({ it * 3 }, 4)
    println("processor({{ it * 3 }}, 4) = $double")  // 24

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수 타입도 중첩하여 더 복잡한 형태 구성 가능")
    println("- (Int) -> (Int) -> Int : 함수를 반환하는 함수")
    println("- ((Int) -> Int, Int) -> Int : 함수를 파라미터로 받는 함수")
    println("- 고차 함수(Higher-order functions)의 기초")
    println("=".repeat(60))
}
