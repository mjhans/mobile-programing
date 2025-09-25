package com.bible.week03.examples

fun main() {
    // 불변 (읽기 전용) 컬렉션 - 기본값이자 권장사항
    val numbers = listOf(1, 2, 3)
    // numbers.add(4) // 컴파일 에러! add() 메서드가 없음

    // 가변 (수정 가능) 컬렉션 - 명시적 선택
    val mutableNumbers = mutableListOf(1, 2, 3)
    mutableNumbers.add(4) // OK
    mutableNumbers[0] = 10 // OK
    println(mutableNumbers) // [10, 2, 3, 4]

    // Map에서 to infix 함수 활용
    val readOnlyMap = mapOf(
        1 to "one",
        2 to "two"
    )
    val mutableMap = mutableMapOf(
        1 to "one",
        2 to "two"
    )
    mutableMap[3] = "three" // 가변 맵에만 추가 가능
}