package com.bible.ch03.examples
/**
 * 3.4.1 Varargs: 가변 인자 함수
 * 여러 개의 인자를 받을 수 있는 함수 만들기
 */

fun <T> listOf(vararg values: T): List<T> {
    return values.toList()
}

fun main() {
    val list = listOf("args", "passed", "as", "varargs")
    println(list)

    // 배열을 varargs로 전달 (spread 연산자 사용)
    val args = arrayOf("a", "b", "c")
    val list2 = listOf("args: ", *args)  // *를 붙여야 함 (spread operator)
    println(list2)
}