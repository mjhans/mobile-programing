package com.bible.ch06.examples.HighFunction.ControlFlow
/**
 * 함수 이름을 Return Label로 사용
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 명시적 레이블 대신 함수 이름을 레이블로 사용하는 방법을 학습합니다.
 * 더 간결하고 읽기 쉬운 코드를 작성할 수 있습니다.
 */

/**
 * Listing 10.22: 함수 이름을 return label로 사용
 */
fun lookForAliceFunctionLabel(people: List<Person>) {
    people.forEach {
        if (it.name != "Alice") return@forEach  // forEach를 레이블로 사용
        print("Found Alice!")
    }
}

fun main() {
    println("=".repeat(60))
    println("함수 이름을 Return Label로 사용")
    println("=".repeat(60))

    println("\n예제: return@forEach")
    lookForAliceFunctionLabel(people)
    println()  // Found Alice!

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수 이름(forEach)을 레이블로 사용")
    println("- 명시적 label@ 선언 불필요")
    println("- return@forEach로 람다에서만 반환")
    println("- 더 간결하고 읽기 쉬움")
    println()
    println("장점:")
    println("  - 추가 레이블 선언 필요 없음")
    println("  - 어떤 함수에서 반환하는지 명확")
    println("  - 권장되는 방식")
    println("=".repeat(60))
}
