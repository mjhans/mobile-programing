package com.bible.week02.examples

fun fizzBuzz(i: Int) : String = when {
    i % 3 == 0 ->  "fizz"
    i % 5 == 0 -> "buzz"
    i % 15 == 0 -> "fizzbuzz"
    else -> "$i"

}

fun main(){
    for (i in 1..100) {
        print("$i ${fizzBuzz(i)} ")
    }
}