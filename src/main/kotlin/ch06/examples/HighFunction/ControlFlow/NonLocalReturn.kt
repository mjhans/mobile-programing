package com.bible.ch06.examples.HighFunction.ControlFlow

/**
 * forEach에서 Non-local Return
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Inline 함수의 람다에서 return을 사용하면 외부 함수에서 반환됩니다.
 * 이를 non-local return이라고 합니다.
 */

/**
 * Listing 10.20: forEach에서 non-local return
 */
fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return  // lookForAlice 함수에서 반환 (non-local return)
        }
    }
    println("Alice is not found")
}

fun main() {
    println("=".repeat(60))
    println("forEach에서 Non-local Return")
    println("=".repeat(60))

    println("\n예제: forEach에서 return")
    lookForAlice(people)  // Found!

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- Inline 함수의 람다에서 return 사용 가능")
    println("- return은 람다가 아닌 외부 함수(lookForAlice)에서 반환")
    println("- 이를 non-local return이라고 함")
    println("- \"Alice is not found\"는 출력되지 않음")
    println()
    println("왜 가능한가?")
    println("- forEach는 inline 함수")
    println("- 람다 코드가 호출 위치에 직접 삽입됨")
    println("- 일반 for 루프와 동일하게 동작")
    println("=".repeat(60))
}
