package com.bible.week03.examples

fun <T> Collection<T>.joinToString(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator) // 첫원소 앞에는 구분자를 붙이면 안된다.
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// String 컬렉션 전용 특화 버전
fun Collection<String>.join(
    separator: String = ", "
) = joinToString(separator)

// CharSequence를 위한 특화 버전
fun Collection<CharSequence>.joinToText(
    separator: String = " "
) = joinToString(separator)


fun main(){
    val numbers = listOf(1, 2, 3)  // int형 리스트
    val words = listOf("one", "two", "three")  // string형 리스트
    val chars = listOf("a", "b", "c")   // char 형 리스트

    println(numbers.joinToString())  // "1, 2, 3"
    println(words.join(" "))         // "one two three"
    println(chars.joinToText("-"))   // "a-b-c"

}