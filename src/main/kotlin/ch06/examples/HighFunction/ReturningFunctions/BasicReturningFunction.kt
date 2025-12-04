package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * 함수를 반환하는 기본 예제
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수를 반환하는 함수의 기본 개념을 학습합니다.
 * 함수 타입을 반환 타입으로 지정하고 람다를 반환하는 방법을 이해합니다.
 */

fun getMultiplier(factor: Int): (Int) -> Int {  // 함수를 반환하는 함수 선언
    return { number -> number * factor }  // 람다 반환
}

fun main() {
    println("=".repeat(60))
    println("함수를 반환하는 기본 예제")
    println("=".repeat(60))

    // 함수를 반환받아 변수에 저장
    val double = getMultiplier(2)
    val triple = getMultiplier(3)

    println("double(5) = ${double(5)}")  // 10
    println("triple(5) = ${triple(5)}")  // 15

    // 직접 호출
    println("getMultiplier(4)(5) = ${getMultiplier(4)(5)}")  // 20

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수를 반환하려면 함수 타입을 반환 타입으로 지정")
    println("- 반환된 함수를 변수에 저장하거나 바로 호출 가능")
    println("- 함수 팩토리 패턴의 기초")
    println("=".repeat(60))
}
