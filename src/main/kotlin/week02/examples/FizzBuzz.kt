package com.bible.week02.examples

fun main(){
    fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "FizzBuzz "
        i % 3 == 0 -> "Fizz "
        i % 5 == 0 -> "Buzz "
        else -> "$i "
    }

    for (i in 1..100) {
        print(fizzBuzz(i))
    }
}