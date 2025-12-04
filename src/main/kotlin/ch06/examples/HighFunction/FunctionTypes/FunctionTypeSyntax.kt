package com.bible.ch06.examples.HighFunction.FunctionTypes
/**
 * 함수 타입 문법의 구성 요소 (Function Type Syntax)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입 문법의 다양한 형태를 학습합니다.
 * 파라미터 개수에 따라 함수 타입이 어떻게 표현되는지 이해합니다.
 */

fun main() {
    println("=".repeat(60))
    println("함수 타입 문법의 구성 요소 (Function Type Syntax)")
    println("=".repeat(60))

    // 다양한 함수 타입 예제
    val noParams: () -> String = { "No parameters" }
    val oneParam: (Int) -> String = { "Number: $it" }
    val twoParams: (String, Int) -> String = { str, num -> "$str: $num" }
    val threeParams: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

    println("() -> String: ${noParams()}")
    println("(Int) -> String: ${oneParam(42)}")
    println("(String, Int) -> String: ${twoParams("Count", 5)}")
    println("(Int, Int, Int) -> Int: ${threeParams(1, 2, 3)}")

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 괄호 안에 파라미터 타입들을 나열")
    println("- 화살표(->)로 구분")
    println("- 화살표 뒤에 반환 타입 지정")
    println("- 파라미터가 없으면 빈 괄호 () 사용")
    println("=".repeat(60))
}
