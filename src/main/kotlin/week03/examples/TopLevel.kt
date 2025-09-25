@file:JvmName("Constants")
package com.bible.week03.examples

// Top-level properties
val UNIX_LINE_SEPARATOR = "\n"
val WINDOWS_LINE_SEPARATOR = "\r\n"

// 계산된 프로퍼티
val currentSystemLineSeparator: String
    get() = System.getProperty("line.separator")

// 변경 가능한 프로퍼티
var debugMode = false

// 사용 예
fun printWithSystemSeparator(text: String) {
    print(text + currentSystemLineSeparator)
}

fun main() {
    debugMode = true
    println("Debug mode: $debugMode")

    printWithSystemSeparator("Hello")
    printWithSystemSeparator("World")

    //StringUtils.joinToString<String>(listOf<String>("a", "b"), "", "")
}