package com.bible.week02.examples

fun main() {
    val binaryReps = mutableMapOf<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("withIndex = $index: $element")
    }
}