package com.bible.week03.examples


fun String.lastChar(): Char = get(length - 1)
//   ↑       ↑        ↑           ↑
// Receiver Extension Return   this 키워드
//  Type    Function   Type    (생략 가능)

fun String.getOrNull(index: Int): Char? =
    if (index in 0 until length) get(index) else null

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]  // this 명시적 사용
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main() {
    // 자연스러운 호출
    println("Hello".lastChar())        // 'o'
    println("Hello".getOrNull(10))     // null

    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    println(list)  // [3, 2, 1]
}