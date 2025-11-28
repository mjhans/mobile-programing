package com.bible.ch05.examples

fun main(){
    val fruits = listOf("Apple", "Banana", "Cherry")
    val uppercaseFruits = mutableListOf<String>()

    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruits.addAll(it) }  // 부수 효과
        .filter { it.length > 5 }
        .also { println(it) }  // 중간 결과 출력
        .reversed()

// [BANANA, CHERRY]
    println(uppercaseFruits)  // [APPLE, BANANA, CHERRY]
    println(reversedLongFruits)  // [CHERRY, BANANA]
}