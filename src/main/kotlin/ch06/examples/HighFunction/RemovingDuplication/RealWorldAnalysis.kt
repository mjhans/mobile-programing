package com.bible.ch06.examples.HighFunction.RemovingDuplication
/**
 * 실전 분석 예제
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Higher-order function 패턴으로 다양한 분석 기능을 일관되게 구현합니다.
 * count, sum, max 등 여러 집계 함수에 같은 패턴을 적용합니다.
 */


fun List<SiteVisit>.countVisits(predicate: (SiteVisit) -> Boolean) =
    count(predicate)

fun List<SiteVisit>.totalDuration(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).sumOf { it.duration }

fun List<SiteVisit>.mostVisitedPath(predicate: (SiteVisit) -> Boolean) =
    filter(predicate)
        .groupBy { it.path }
        .maxByOrNull { it.value.size }
        ?.key

fun main() {
    println("=".repeat(60))
    println("실전 분석 예제")
    println("=".repeat(60))

    // Windows 방문 횟수
    println("Windows 방문 횟수: ${log.countVisits { it.os == OS.WINDOWS }}")  // 2

    // 모바일 총 체류 시간
    println("모바일 총 체류 시간: ${log.totalDuration {
        it.os in setOf(OS.IOS, OS.ANDROID)
    }}")  // 24.3

    // Mac 사용자가 가장 많이 방문한 페이지
    println("Mac 최다 방문 페이지: ${log.mostVisitedPath { it.os == OS.MAC }}")  // /

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- HOF 패턴으로 다양한 분석 기능을 일관되게 구현")
    println("- countVisits, totalDuration, mostVisitedPath 모두 동일한 패턴")
    println("- predicate로 필터링 조건을 자유롭게 조합")
    println("- 코드 재사용과 확장성 극대화")
    println("=".repeat(60))
}
