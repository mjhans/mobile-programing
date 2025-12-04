package com.bible.ch06.examples.HighFunction.HigherOrderBasics

/**
 * Filter 함수 구현 (Filter Function Implementation)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * String에 대한 filter 함수를 직접 구현하여 higher-order function의 동작을 이해합니다.
 * predicate 함수를 사용하여 각 문자를 검사하고 필터링합니다.
 */

/**
 * Listing 10.2: 간단한 버전의 filter 함수 구현
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    return buildString {
        for (char in this@filter) {  // 입력 문자열을 문자별로 반복
            if (predicate(char)) append(char)  // predicate 파라미터로 전달된 함수 호출
        }
    }
}

fun main() {
    println("=".repeat(60))
    println("Filter 함수 구현 및 사용")
    println("=".repeat(60))

    val input = "ab1c2d3e"

    // 소문자만 필터링
    val letters = input.filter { it in 'a'..'z' }
    println("문자만: \"$letters\"")  // abcde

    // 숫자만 필터링
    val digits = input.filter { it.isDigit() }
    println("숫자만: \"$digits\"")   // 123

    // 특정 문자 제외
    val without1 = input.filter { it != '1' }
    println("1 제외: \"$without1\"") // ab2c2d3e

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- predicate 함수로 각 문자를 검사")
    println("- true를 반환하는 문자만 결과에 포함")
    println("- buildString을 사용하여 효율적으로 문자열 생성")
    println("- Extension function으로 String에 filter 기능 추가")
    println("=".repeat(60))
}
