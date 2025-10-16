package com.bible.ch03.examples


fun <T> listOf(vararg values: T): List<T> {
    return values.toList()
}

fun main() {
    val list = listOf("args", "passed", "as", "varargs")
    val list_new = listOf("args", "passed", "as", "varargs", "dd")
    println(list)
    println(list_new)
    println(list.MyJoinToString(separator = "|", prefix = "[", postfix = "]"))
    println(list_new.MyJoinToString(separator = "% ", prefix = "[", postfix = "]"))

    // 배열을 varargs로 전달 (spread 연산자 사용)
    val args = arrayOf("a", "b", "c")
    // 배열 구조 분해 (destructuring) - spread 연산자 불필요
    val (a, b, c) = args
    println("a : $a, b : $b, c : $c")
    val list2 = listOf("args: ", *args)  // *를 붙여야 함 (spread operator) ,
    println(list2.MyJoinToString(separator = "|", prefix = "[", postfix = "]"))
    // MyJoinToString 이런류의 함수는 utils 패키지를 만들어서 따로 정의한다.
}