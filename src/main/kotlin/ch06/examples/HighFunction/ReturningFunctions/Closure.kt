package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * 클로저: 외부 변수 캡처
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 람다가 외부 변수를 캡처하는 클로저(Closure) 개념을 학습합니다.
 * 반환된 함수가 독립적인 상태를 유지하는 방법을 이해합니다.
 */

fun createCounter(initial: Int): () -> Int {
    var count = initial  // 람다가 이 변수를 캡처

    return {
        count++  // 외부 변수 수정
        count
    }
}

fun main() {
    println("=".repeat(60))
    println("클로저 - 외부 변수 캡처")
    println("=".repeat(60))

    val counter1 = createCounter(0)
    val counter2 = createCounter(100)

    println("counter1: ${counter1()}")  // 1
    println("counter1: ${counter1()}")  // 2
    println("counter1: ${counter1()}")  // 3

    println("counter2: ${counter2()}")  // 101
    println("counter2: ${counter2()}")  // 102

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 각 함수가 독립적인 count 변수를 가짐")
    println("- 람다가 외부 변수를 캡처 (클로저)")
    println("- 캡처된 변수는 함수가 살아있는 동안 유지")
    println("- 상태를 가진 함수 생성 가능")
    println("=".repeat(60))
}
