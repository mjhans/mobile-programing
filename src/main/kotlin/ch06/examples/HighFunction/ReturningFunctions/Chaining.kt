package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * 함수를 반환하는 함수를 반환 (체이닝)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 여러 단계의 함수 반환을 통한 커링(Currying) 패턴을 학습합니다.
 * 함수가 함수를 반환하고, 그 함수가 또 함수를 반환하는 구조를 이해합니다.
 */

fun createAdder(): (Int) -> (Int) -> Int {
    return { a ->
        { b -> a + b }
    }
}

fun main() {
    println("=".repeat(60))
    println("함수를 반환하는 함수를 반환 (체이닝)")
    println("=".repeat(60))

    val adder = createAdder()
    val add5 = adder(5)
    val add10 = adder(10)

    println("add5(3) = ${add5(3)}")    // 8
    println("add10(3) = ${add10(3)}")  // 13

    // 한 번에 호출
    println("createAdder()(20)(30) = ${createAdder()(20)(30)}")  // 50

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 여러 단계의 함수 반환 가능")
    println("- 커링(Currying) 패턴 구현")
    println("- (Int) -> (Int) -> Int 타입 구조")
    println("- 부분 적용(Partial application) 가능")
    println("=".repeat(60))
}
