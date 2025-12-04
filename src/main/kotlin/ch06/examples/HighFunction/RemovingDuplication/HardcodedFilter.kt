package com.bible.ch06.examples.HighFunction.RemovingDuplication

/**
 * 하드코딩된 필터 (중복 코드의 문제)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 하드코딩된 필터로 인한 코드 중복 문제를 학습합니다.
 * OS만 바뀌고 나머지 코드가 반복되는 문제점을 이해합니다.
 */

/**
 * Listing 10.9: Site visit 데이터 정의
 */

/**
 * Listing 10.10: 하드코딩된 필터로 site visit 데이터 분석
 */
fun main() {
    println("=".repeat(60))
    println("하드코딩된 필터 (중복 코드)")
    println("=".repeat(60))

    // Windows 사용자 평균 체류 시간
    val averageWindowsDuration = log
        .filter { it.os == OS.WINDOWS }
        .map(SiteVisit::duration)
        .average()

    println("Windows 평균 체류 시간: $averageWindowsDuration")  // 23.0

    // 문제: Mac 사용자, Linux 사용자 등을 분석하려면 유사한 코드를 반복해야 함
    val averageMacDuration = log
        .filter { it.os == OS.MAC }  // OS만 다르고 나머지는 동일
        .map(SiteVisit::duration)
        .average()

    println("Mac 평균 체류 시간: $averageMacDuration")  // 22.0

    println("\n" + "=".repeat(60))
    println("문제점:")
    println("=".repeat(60))
    println("- OS만 바뀌고 나머지 코드가 중복됨")
    println("- 새로운 OS를 추가할 때마다 복사-붙여넣기 필요")
    println("- 유지보수가 어렵고 실수하기 쉬움")
    println("=".repeat(60))
}
