package com.bible.ch06.examples.HighFunction.ControlFlow

/**
 * Label을 사용한 Local Return
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 람다에서만 반환하고 싶을 때 레이블을 사용하는 방법을 학습합니다.
 * 레이블을 사용하면 람다에서만 빠져나옵니다.
 */

/**
 * Listing 10.21: Label을 사용한 local return
 */
fun lookForAliceLabeled(people: List<Person>) {
    people.forEach label@{
        if (it.name != "Alice") return@label  // 람다에서만 반환 (local return)
        print("Found Alice!")
    }
}

fun main() {
    println("=".repeat(60))
    println("Label을 사용한 Local Return")
    println("=".repeat(60))

    println("\n예제: return@label")
    lookForAliceLabeled(people)
    println()  // Found Alice!

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- label@를 람다 앞에 붙임")
    println("- return@label로 람다에서만 반환")
    println("- Alice가 아닌 사람은 건너뜀 (continue와 유사)")
    println("- Alice를 찾으면 \"Found Alice!\" 출력")
    println("- 함수는 계속 실행됨")
    println()
    println("동작:")
    println("  Bob -> return@label (람다만 종료, 다음 반복)")
    println("  Alice -> \"Found Alice!\" 출력")
    println("=".repeat(60))
}
