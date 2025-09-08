package com.bible.week02.examples

// 다양한 타입을 받을 수 있는 함수
fun describe(obj: Any): String = when (obj) {
    1 -> "숫자 1입니다"
    "Hello" -> "인사말입니다"
    is Long -> "긴 숫자입니다: $obj"        // Smart Cast: obj가 Long으로 자동 변환
    is String -> "문자열입니다: 길이는 ${obj.length}"  // Smart Cast: obj가 String으로 자동 변환
    is IntArray -> "정수 배열입니다: ${obj.size}개 원소"  // Smart Cast: obj가 IntArray로 자동 변환
    else -> "알 수 없는 객체입니다"
}

// 조건부 Smart Cast 예제
fun processString(value: Any?) {
    // null 체크 후 Smart Cast
    if (value is String) {
        // 이 블록에서 value는 자동으로 String 타입
        println("문자열 길이: ${value.length}")
        println("대문자: ${value.uppercase()}")
    }

    // when에서의 Smart Cast
    when (value) {
        is Int -> println("정수 연산: ${value + 10}")      // value는 Int
        is Double -> println("실수 연산: ${value * 2}")    // value는 Double
        is List<*> -> println("리스트 크기: ${value.size}") // value는 List
    }
}

fun main() {
    // 다양한 타입 테스트
    println(describe(1))                    // 숫자 1입니다
    println(describe("Hello"))              // 인사말입니다
    println(describe(1000L))                // 긴 숫자입니다: 1000
    println(describe("Kotlin"))             // 문자열입니다: 길이는 6
    println(describe(intArrayOf(1, 2, 3)))  // 정수 배열입니다: 3개 원소

    // Smart Cast 활용
    processString("코틀린")      // 문자열 길이: 3, 대문자: 코틀린
    processString(42)           // 정수 연산: 52
    processString(3.14)        // 실수 연산: 6.28
}