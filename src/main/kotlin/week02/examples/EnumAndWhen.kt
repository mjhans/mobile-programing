package com.bible.week02.examples

//enum class Color {
//    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
//}

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int          // enum 상수
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);   // 반드시 필요, enum 정의 구역

    val rgb = (r * 256 + g) * 256 + b     // 임의로 정한 rgb 계산식
    fun printColor() = println("$this is $rgb")
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun main() {
    println(Color.BLUE.rgb)             // 255
    Color.GREEN.printColor()            // GREEN is 65280

    println(getMnemonic(Color.BLUE))     // Battle

}