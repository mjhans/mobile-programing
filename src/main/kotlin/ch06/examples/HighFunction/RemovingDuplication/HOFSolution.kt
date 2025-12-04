package com.bible.ch06.examples.HighFunction.RemovingDuplication

/**
 * Higher-Order Function으로 완전한 해결
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Higher-order function을 사용하여 모든 필터링 조건을 처리합니다.
 * 람다로 동작(behavior)을 전달하여 완전한 유연성을 확보합니다.
 */


/**
 * Listing 10.13: Higher-order function으로 중복 제거
 */
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main() {
    println("=".repeat(60))
    println("Higher-Order Function으로 완전한 해결")
    println("=".repeat(60))

    // 모바일 사용자
    println("모바일: ${log.averageDurationFor {
        it.os in setOf(OS.ANDROID, OS.IOS)
    }}")  // 12.15

    // iOS이면서 /signup 페이지
    println("iOS + signup: ${log.averageDurationFor {
        it.os == OS.IOS && it.path == "/signup"
    }}")  // 8.0

    // 체류 시간이 20초 이상인 방문
    println("20초 이상: ${log.averageDurationFor {
        it.duration > 20
    }}")  // 28.15

    // Windows이면서 루트 페이지가 아닌 방문
    println("Windows + 루트 아님: ${log.averageDurationFor {
        it.os == OS.WINDOWS && it.path != "/"
    }}")  // 12.0

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 하나의 함수로 모든 필터링 조건 처리")
    println("- 람다로 동작(behavior)을 전달")
    println("- 새로운 조건이 추가되어도 함수 수정 불필요")
    println("- 완전한 유연성 확보")
    println("=".repeat(60))
}
