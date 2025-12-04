package com.bible.ch06.examples.HighFunction.ControlFlow
/**
 * Anonymous Function에서 Return
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 익명 함수(Anonymous function)를 사용하면 return이 자동으로 local이 됩니다.
 * 레이블 없이도 람다에서만 반환할 수 있습니다.
 */

/**
 * Listing 10.23: Anonymous function에서 return
 */
fun lookForAliceAnonymous(people: List<Person>) {
    people.forEach(fun (person) {  // fun 키워드 사용 -> anonymous function
        if (person.name == "Alice") return  // anonymous function에서 반환
        println("${person.name} is not Alice")
    })
}

fun main() {
    println("=".repeat(60))
    println("Anonymous Function에서 Return")
    println("=".repeat(60))

    println("\n예제: Anonymous function")
    lookForAliceAnonymous(people)  // Bob is not Alice

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- fun 키워드로 anonymous function 선언")
    println("- return은 가장 가까운 fun 함수에서 반환")
    println("- 레이블 없이도 local return 가능")
    println()
    println("동작:")
    println("  Bob -> 조건 불일치, \"Bob is not Alice\" 출력")
    println("  Alice -> return (anonymous function 종료)")
    println("  함수는 계속 실행됨")
    println()
    println("언제 사용?")
    println("  - 여러 return 지점이 있을 때")
    println("  - 레이블 없이 local return이 필요할 때")
    println("=".repeat(60))
}
