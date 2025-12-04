package com.bible.ch06.examples.HighFunction.RemovingDuplication
/**
 * 더 복잡한 필터링 요구사항
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 단순한 OS 필터링을 넘어 복잡한 조건이 필요함을 보여줍니다.
 * 일반 함수로는 이런 다양한 요구사항을 처리할 수 없습니다.
 */

/**
 * Listing 10.12: 복잡한 하드코딩된 필터로 site visit 데이터 분석
 */
fun main() {
    println("=".repeat(60))
    println("더 복잡한 필터링 요구사항")
    println("=".repeat(60))

    // 모바일 사용자 (iOS + Android) 평균 체류 시간
    val averageMobileDuration = log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average()

    println("모바일 평균 체류 시간: $averageMobileDuration")  // 12.15

    // 문제: averageDurationFor 함수로는 이런 복잡한 조건 처리 불가
    // 또 다른 함수를 만들어야 함

    println("\n" + "=".repeat(60))
    println("새로운 문제:")
    println("=".repeat(60))
    println("- OS 외에 path, duration 등 다양한 조건으로 필터링 필요")
    println("- 여러 조건을 조합해야 하는 경우 발생")
    println("- 조건마다 새로운 함수를 만들 수는 없음")
    println("- Higher-order function이 필요한 이유!")
    println("=".repeat(60))
}
