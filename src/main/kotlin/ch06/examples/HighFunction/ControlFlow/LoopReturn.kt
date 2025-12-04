package com.bible.ch06.examples.HighFunction.ControlFlow

/**
 * 일반 루프에서 return
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 일반 for 루프에서 return이 함수를 빠져나가는 것을 학습합니다.
 * 이것이 우리가 기대하는 일반적인 동작입니다.
 */


/**
 * Listing 10.19: 일반 루프에서 return
 */
fun lookForAliceLoop(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return  // lookForAliceLoop 함수에서 반환
        }
    }
    println("Alice is not found")
}

fun main() {
    println("=".repeat(60))
    println("일반 루프에서 return")
    println("=".repeat(60))

    println("\n예제: for 루프에서 return")
    lookForAliceLoop(people)  // Found!

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- return은 가장 가까운 fun 키워드의 함수에서 반환")
    println("- for 루프의 return은 함수 전체를 빠져나감")
    println("- \"Alice is not found\"는 출력되지 않음")
    println("- 이것이 우리가 기대하는 일반적인 동작")
    println("=".repeat(60))
}
