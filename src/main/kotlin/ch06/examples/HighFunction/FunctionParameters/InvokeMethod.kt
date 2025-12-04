package com.bible.ch06.examples.HighFunction.FunctionParameters

/**
 * invoke() 메서드 이해하기
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입이 가진 invoke() 메서드를 학습합니다.
 * Nullable 함수 타입에서 safe-call과 함께 사용하는 방법을 이해합니다.
 */

fun main() {
    println("=".repeat(60))
    println("invoke() 메서드")
    println("=".repeat(60))

    val lambda: (Int, Int) -> Int = { a, b -> a + b }

    // 일반 호출
    println("일반 호출: lambda(3, 5) = ${lambda(3, 5)}")  // 8

    // invoke() 메서드 직접 호출
    println("invoke 호출: lambda.invoke(3, 5) = ${lambda.invoke(3, 5)}")  // 8

    // Nullable 함수 타입
    val nullableLambda: ((Int, Int) -> Int)? = { a, b -> a * b }

    // Safe-call과 invoke 결합
    println("Nullable safe-call: ${nullableLambda?.invoke(4, 5)}")  // 20

    val nullLambda: ((Int, Int) -> Int)? = null
    println("Null 함수: ${nullLambda?.invoke(4, 5)}")  // null

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수 타입은 invoke() 메서드를 가진 인터페이스")
    println("- lambda(args) 는 lambda.invoke(args)의 간편 표기")
    println("- Nullable 함수 타입은 safe-call과 함께 invoke() 사용")
    println("- nullableFunc?.invoke(args) 패턴으로 안전하게 호출")
    println("=".repeat(60))
}
