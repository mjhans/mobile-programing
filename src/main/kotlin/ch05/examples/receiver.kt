package com.bible.ch05.examples

//개선전
//fun alphabet(): String {
//    val result = StringBuilder()
//    for (letter in 'A'..'Z') {
//        result.append(letter)
//    }
//    result.append("\nNow I know the alphabet!")
//    return result.toString()
//}
//
//개선 후
//fun alphabet(): String {
//    val stringBuilder = StringBuilder()
//    return with(stringBuilder) {
//        for (letter in 'A'..'Z') {
//            this.append(letter)  // this는 stringBuilder
//        }
//        this.append("\nNow I know the alphabet!")
//        this.toString()  // 반환값
//    }
//}
//
//fun alphabet() = with(StringBuilder()) {
//    for (letter in 'A'..'Z') {
//        append(letter)
//    }
//    append("\nNow I know the alphabet!")
//    toString()
//}

fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}//ing()

fun main(){
    println(alphabet().toString())
}