package com.bible.ch06.examples.HighFunction.FunctionParameters

/**
 * 함수 타입 파라미터에 기본값 지정
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입 파라미터에 기본값으로 람다를 제공하는 방법을 학습합니다.
 * 기본값이 있으면 변환이 필요 없을 때 람다를 생략할 수 있습니다.
 */

/**
 * Listing 10.5: 함수 타입 파라미터에 기본값 지정
 */
fun <T> Collection<T>.joinToStringWithDefault(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }  // 람다를 기본값으로 사용
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))  // transform 파라미터로 전달된 함수 호출
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    println("=".repeat(60))
    println("함수 타입 파라미터에 기본값")
    println("=".repeat(60))

    val letters = listOf("Alpha", "Beta", "Gamma")

    // 기본 변환 함수 사용
    println("기본 변환: ${letters.joinToStringWithDefault()}")
    // Alpha, Beta, Gamma

    // 커스텀 람다 전달 (마지막 파라미터)
    println("소문자 변환: ${letters.joinToStringWithDefault { it.lowercase() }}")
    // alpha, beta, gamma

    // 여러 인자와 함께 람다 전달
    println("대문자 변환: ${letters.joinToStringWithDefault(
        separator = "! ",
        postfix = "! ",
        transform = { it.uppercase() }
    )}")
    // ALPHA! BETA! GAMMA!

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 기본값이 있어 변환이 필요 없으면 람다 생략 가능")
    println("- 필요할 때만 커스텀 변환 함수 전달")
    println("- 함수 타입 파라미터도 일반 파라미터처럼 기본값 지정 가능")
    println("=".repeat(60))
}
