package com.bible.ch06.examples.HighFunction.FunctionParameters

/**
 * 기본 joinToString (변환 함수 없음)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 하드코딩된 toString 변환을 사용하는 joinToString을 학습합니다.
 * 이 버전은 기본 toString() 메서드만 사용하여 유연성이 제한됩니다.
 */

/**
 * Listing 10.4: 하드코딩된 toString 변환을 사용하는 joinToString
 */
fun <T> Collection<T>.joinToStringBasic(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)  // 기본 toString 메서드 사용
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    println("=".repeat(60))
    println("기본 joinToString (변환 함수 없음)")
    println("=".repeat(60))

    val letters = listOf("Alpha", "Beta", "Gamma")

    println(letters.joinToStringBasic())  // Alpha, Beta, Gamma
    println(letters.joinToStringBasic(separator = " | "))  // Alpha | Beta | Gamma
    println(letters.joinToStringBasic(prefix = "[", postfix = "]"))  // [Alpha, Beta, Gamma]

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 기본 toString()만 사용하여 유연성이 제한됨")
    println("- 각 요소를 변환하는 방법을 커스터마이징할 수 없음")
    println("- 개선이 필요: 변환 함수를 파라미터로 받아야 함")
    println("=".repeat(60))
}
