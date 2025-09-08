package com.bible.week02.examples

fun buyDrink(money: Int): String {
    return when {
        money >= 1500 -> "콜라"
        money >= 1000 -> "물"
        else -> "돈이 부족합니다"
    }
}

// 사용하기 (자판기에 동전 넣기)
fun main() {
    println(buyDrink(2000))  // 콜라
    println(buyDrink(1200))  // 물
    println(buyDrink(500))   // 돈이 부족합니다
}