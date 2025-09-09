package com.bible.week02.examples

fun main(){
    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'

    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know..."
    }

    println("recognize(8) = ${recognize('8')}")  // It's a digit!
    println("recognize(c) = ${recognize('c')}")
    println(isLetter('a'))
    println(isNotDigit('A'))

}