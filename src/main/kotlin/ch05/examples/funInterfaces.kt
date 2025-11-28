package com.bible.ch05.examples


fun interface StringProcessor {
    fun process(value: String): String //추상 메서드

    // 디폴트 메서드 (추상 아님 → 허용됨)
    fun trimAndProcess(value: String): String {
        return process(value.trim())
    }
}

fun main() {
    val msgs = listOf<String>("   HelLO", "   World  ", "   HI")
    val upperCase = StringProcessor { it.uppercase() }

    println(upperCase.process("hello"))         // HELLO
    println(upperCase.trimAndProcess("  hi "))  // HI

    msgs.forEach {
        println("[${upperCase.trimAndProcess(it)}] [$it]")
    }


    val lowerCase = StringProcessor { it.lowercase() }
    msgs.forEach {
        println("[${lowerCase.trimAndProcess(it)}] [$it]")
    }
}