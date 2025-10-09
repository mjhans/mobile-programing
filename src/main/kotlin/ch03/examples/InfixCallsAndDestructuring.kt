package com.bible.ch03.examples
/**
 * 3.4.2 Infix calls와 destructuring declarations
 * 중위 호출과 구조 분해 선언으로 더 읽기 쉬운 코드
 */
//infix fun Any.to(other: Any) = Pair(this, other) // 단일인자 함수에만 적용가능

infix fun Int.pow(exponent: Int): Int {
    //require는 조건이 true인지 검사하고,
    //false일 경우 IllegalArgumentException 예외를 던지는 함수
    require(exponent >= 0) { "Exponent must be non-negative" }
    //fold는 누적연산을 실행, 인자는 초기값으로 여기서는 1
    return (1..exponent).fold(1) { acc, _ -> acc * this } // 람다 함수
}
infix fun String.concat(other: String) = this + other

fun main() {
    // Infix call 문법
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    // 실제로는 1.to("one")과 같음 - to는 infix 함수

    // Pair 생성의 두 가지 방법
    val pair1 = Pair(7, "seven")
    val pair2 = 7 to "seven"  // infix call

    println("pair1: $pair1")
    println("pair2: $pair2")

    // Destructuring declaration
    val (number, name) = 1 to "one"
    println("number: $number, name: $name")

    // for 루프에서 destructuring
    for ((index, element) in listOf("a", "b", "c").withIndex()) {
        println("$index: $element")
    }

    println("2 pow 4 : ${2.pow(4)}")
}