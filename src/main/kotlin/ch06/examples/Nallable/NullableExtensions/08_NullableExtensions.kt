package com.bible.ch06.examples.Nallable.NullableExtensions
/**
 * Week 6 Code Examples: Extensions for Nullable Types
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * Nullable 타입에 대한 확장 함수를 정의하는 방법을 학습합니다.
 */

// Listing 7.12: Nullable receiver를 가진 확장 함수
fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {  // Safe call 불필요
        println("Please fill in the required fields")
    } else {
        println("Input valid: $input")
    }
}

// 커스텀 nullable 확장
fun String?.orDefault(default: String): String {
    return if (this.isNullOrBlank()) default else this
}

fun main() {
    println("=== Nullable Extensions 예제 ===\n")

    // 예제 1: isNullOrBlank 사용
    println("예제 1: isNullOrBlank")
    verifyUserInput(" ")      // Please fill in the required fields
    verifyUserInput(null)     // Please fill in the required fields
    verifyUserInput("valid")  // Input valid: valid

    // 예제 2: 커스텀 확장
    println("\n예제 2: 커스텀 nullable 확장")
    val name1: String? = null
    val name2: String? = "Alice"

    println("name1: ${name1.orDefault("Guest")}")  // Guest
    println("name2: ${name2.orDefault("Guest")}")  // Alice

    // 예제 3: let과의 차이
    println("\n예제 3: let과의 차이")
    val value: String? = null

    // nullable 확장은 safe-call 불필요
    println("isNullOrEmpty: ${value.isNullOrEmpty()}")  // true

    // let은 safe-call 필요
    value?.let { println("With let: $it") } ?: println("Value is null")

    println("\n" + "=".repeat(50))
    println("핵심 포인트:")
    println("1. Nullable 타입에 대한 확장 함수 정의 가능")
    println("2. Safe-call 없이 호출 가능")
    println("3. 함수 내부에서 this가 null일 수 있음")
    println("4. isNullOrBlank, isNullOrEmpty 등 표준 라이브러리 활용")
    println("=".repeat(50))
}
