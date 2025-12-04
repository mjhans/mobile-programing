package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * 함수 팩토리 패턴
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 파라미터로 맞춤형 함수를 생성하는 함수 팩토리 패턴을 학습합니다.
 * 설정값을 받아 그에 맞는 함수를 생성하여 반환합니다.
 */

fun createValidator(minLength: Int, maxLength: Int): (String) -> Boolean {
    return { input ->
        input.length in minLength..maxLength
    }
}

fun createFormatter(prefix: String, suffix: String): (String) -> String {
    return { text ->
        "$prefix$text$suffix"
    }
}

fun main() {
    println("=".repeat(60))
    println("함수 팩토리 패턴")
    println("=".repeat(60))

    // 서로 다른 검증기 생성
    val usernameValidator = createValidator(3, 15)
    val passwordValidator = createValidator(8, 20)

    println("사용자명 검증:")
    println("  'ab': ${usernameValidator("ab")}")      // false
    println("  'alice': ${usernameValidator("alice")}")  // true

    println("\n비밀번호 검증:")
    println("  '1234': ${passwordValidator("1234")}")    // false
    println("  '12345678': ${passwordValidator("12345678")}")  // true

    // 서로 다른 포맷터 생성
    val htmlTag = createFormatter("<b>", "</b>")
    val quote = createFormatter("\"", "\"")

    println("\nHTML 태그: ${htmlTag("중요")}")     // <b>중요</b>
    println("인용: ${quote("Hello World")}")      // "Hello World"

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 파라미터로 맞춤형 함수 생성")
    println("- 설정값을 캡처하여 함수에 포함")
    println("- 재사용 가능한 함수 생성 패턴")
    println("=".repeat(60))
}
