package com.bible.week03.examples

// 읽기 전용 extension property - backing field 없음
val String.lastChar: Char
    get() = get(length - 1)

// 읽기/쓰기 가능한 extension property
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        setCharAt(length - 1, value)
    }

// 더 복잡한 예제
val String.indices: IntRange
    get() = 0 until length

fun main() {
    println("Kotlin".lastChar)  // 'n',계산된 결과를 보여주는것
    println("Hello".indices)    // 0..4

    val sb = StringBuilder("Hello")
    sb.lastChar = '!'
    println(sb)  // "Hell!" 계산된 결과만 보인다. 실제로 !를 저장하지 않음
}