package com.bible.ch05.examples

// ✅ fun interface 선언
fun interface Operation {
    fun apply(x: Int, y: Int): Int
}
fun calculate(a: Int, b: Int, op: Operation): Int {
    return op.apply(a, b)
}

fun main(){
    val result1 = calculate(10, 5) { x, y -> x + y }
    val result2 = calculate(10, 5) { x, y -> x * y }

    println(result1) // 15
    println(result2) // 50
}