package com.bible.week02.examples

fun main(){
    // 1부터 5까지
//    for (i in 1..5) {
//        println("for: ${i *10}")
//    }
//
//    // 5부터 1까지 (역순)
//    for (i in 5 downTo 1) {
//        println("역순: $i")
//    }
//
//    // 2씩 증가
//    for (i in 1..10 step 2) {
//        println("2씩: $i")  // 1, 3, 5, 7, 9
//    }
//
    val fruits = listOf("사과", "바나나", "오렌지")

    // 값만 반복
    for (fruit in fruits) {
        println("과일: $fruit")
    }

    // 인덱스와 함께 반복
//    for ((index, fruit) in fruits.withIndex()) {
//        println("$index: $fruit")
//    }
//
    // 구구단 3단
    for (i in 1..9) {
        println("3 x $i = ${3 * i}")
    }
//
// 짝수만 출력
    for (i in 2 .. 10 step 2) {
        println("$i")
    }
    for (i in 1..10) {
        if (i % 2 == 0) {
            println("짝수: $i")
        }
    }
}