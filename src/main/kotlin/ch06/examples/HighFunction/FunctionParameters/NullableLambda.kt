package com.bible.ch06.examples.HighFunction.FunctionParameters

/**
 * Nullable 함수 타입 파라미터
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Nullable 함수 타입 파라미터를 사용하는 방법을 학습합니다.
 * null을 명시적으로 전달할 수 있고, invoke()를 safe-call과 함께 사용합니다.
 */

/**
 * Listing 10.6: Nullable 함수 타입 파라미터 사용
 */
fun <T> Collection<T>.joinToStringNullable(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null  // Nullable 함수 타입 파라미터 선언
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element)  // Safe-call 문법으로 함수 호출
                  ?: element.toString()       // callback이 지정되지 않은 경우 처리
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    println("=".repeat(60))
    println("Nullable 함수 타입 파라미터")
    println("=".repeat(60))

    val numbers = listOf(1, 2, 3, 4, 5)

    // transform을 null로 전달 (기본 toString 사용)
    println("변환 없음: ${numbers.joinToStringNullable()}")
    // 1, 2, 3, 4, 5

    // transform에 람다 전달
    println("제곱 변환: ${numbers.joinToStringNullable { "${it * it}" }}")
    // 1, 4, 9, 16, 25

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- Nullable 함수 타입은 null을 명시적으로 전달 가능")
    println("- invoke()를 safe-call(?.)과 함께 사용")
    println("- Elvis 연산자(?:)로 null일 때 기본 동작 지정")
    println("=".repeat(60))
}
