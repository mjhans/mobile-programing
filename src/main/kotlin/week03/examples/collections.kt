package com.bible.week03.examples

fun main() {
    // Kotlin 컬렉션 생성
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven")

    // 실제로는 Java 클래스를 사용
    println(set.javaClass)  // class java.util.LinkedHashSet
    println(list.javaClass) // class java.util.Arrays$ArrayList
    println(map.javaClass)

    // Java 메서드도 그대로 사용 가능
    println(list.size)      // 3
    println(set.contains(7)) // true

    // 하지만 Kotlin 확장 함수도 사용 가능!
    println(list.last())    // 53 (Kotlin 확장 함수)
    println(list.getOrNull(10)) // null (안전한 접근)
}