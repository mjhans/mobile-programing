package com.bible.week02.examples

import java.io.BufferedReader
import java.io.File


fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        return null
    }
    finally {
        reader.close()
    }
}

//fun readNumber(reader: BufferedReader) {
//    val number = try {
//        Integer.parseInt(reader.readLine())
//    } catch (e: NumberFormatException) {
//        null
//    }
//    println(number)
//}

fun readFromFile(filename: String): String {
    val file = File(filename)
    return file.readText()  // IOException을 던질 수 있지만 처리 강제 안함
}


fun main(){
    readNumber(BufferedReader("s"))

}