package com.bible.ch06.examples.HighFunction.HigherOrderBasics

/**
 * 함수 참조를 인자로 전달 (Function References as Arguments)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 람다 외에도 함수 참조(::)를 higher-order function의 인자로 전달하는 방법을 학습합니다.
 * 이미 정의된 함수를 재사용할 수 있습니다.
 */

fun <T> List<T>.customFilterBasic(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun isEven(n: Int): Boolean = n % 2 == 0

fun String.isVowel(c: Char): Boolean = c in "aeiouAEIOU"

fun main() {
    println("=".repeat(60))
    println("함수 참조를 Higher-Order Function에 전달")
    println("=".repeat(60))

    val numbers = listOf(1, 2, 3, 4, 5, 6)

    // 함수 참조 사용
    val evens = numbers.customFilterBasic(::isEven)
    println("짝수 (함수 참조): $evens")  // [2, 4, 6]

    // 람다 사용 (위와 동일한 결과)
    val evens2 = numbers.customFilterBasic { isEven(it) }
    println("짝수 (람다): $evens2")     // [2, 4, 6]

    // 문자열 필터링
    val text = "Hello World"
    val vowels = text.filter { "Hello World".isVowel(it) }
    println("모음만: \"$vowels\"")      // eoo

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 람다 외에도 함수 참조(::)를 인자로 전달 가능")
    println("- ::functionName으로 함수 참조 생성")
    println("- 이미 정의된 함수를 재사용할 수 있어 편리")
    println("- 람다와 함수 참조는 동일한 방식으로 동작")
    println("=".repeat(60))
}
