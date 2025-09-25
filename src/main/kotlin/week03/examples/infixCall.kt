package com.bible.week03.examples


//infix fun Any.to(other: Any) = Pair(this, other)

fun main(args: Array<String>) {
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    for ((k, v) in map) {
        println("$k -> $v")
    }
    val (number, name) = 1 to "one"
    println("$name, $number, $name")
}

