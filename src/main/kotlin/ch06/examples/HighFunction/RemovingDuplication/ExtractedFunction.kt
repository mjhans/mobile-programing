package com.bible.ch06.examples.HighFunction.RemovingDuplication

/**
 * 일반 함수로 중복 제거
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 중복 코드를 함수로 추출하여 개선합니다.
 * 하지만 이 방법은 OS별 필터링만 가능하다는 제한이 있습니다.
 */

/**
 * Listing 10.11: 일반 함수로 중복 제거
 */
fun List<SiteVisit>.averageDurationFor(os: OS) =  // 중복 코드를 함수로 추출
    filter { it.os == os }.map(SiteVisit::duration).average()

fun main() {
    println("=".repeat(60))
    println("일반 함수로 중복 제거")
    println("=".repeat(60))

    println("Windows: ${log.averageDurationFor(OS.WINDOWS)}")  // 23.0
    println("Mac: ${log.averageDurationFor(OS.MAC)}")          // 22.0
    println("Linux: ${log.averageDurationFor(OS.LINUX)}")      // NaN (데이터 없음)

    println("\n" + "=".repeat(60))
    println("개선점과 한계:")
    println("=".repeat(60))
    println("- OS별 평균 체류 시간 계산 로직 재사용 가능")
    println("- 하지만 여전히 제한적: OS만 필터링 가능")
    println("- path, duration 등 다른 조건으로는 필터링 불가")
    println("=".repeat(60))
}
