package com.bible.week02.examples

fun main() {
    // 고정 상자 (val)
    val treasure = "다이아몬드"
    // treasure = "금"

    // 교환 상자 (var)
    var backpack = "책"
    backpack = "노트북"
    backpack = "물병"

    println("안전금고: $treasure")
    println("가방: $backpack")

    // Kotlin이 자동으로 상자 크기를 결정
    val age = 25        // Int  (정수용)
    val name = "철수"   // String  (문자열용)
    val height = 175.5  // Double  (소수점용)
    val isStudent = true // Boolean  (참/거짓용)

// 필요하면 직접 상자 크기 지정도 가능
    val explicitAge: Int = 25

}
