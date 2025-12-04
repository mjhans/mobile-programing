package com.bible.ch06.examples.HighFunction.FunctionParameters

/**
 * 다양한 함수 타입 파라미터 패턴
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 함수 타입 파라미터의 기본값과 nullable을 다양하게 활용하는 패턴을 학습합니다.
 */

fun <T, R> Collection<T>.customMap(
    transform: (T) -> R = { it as R }  // 기본값: 타입 캐스팅
): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        result.add(transform(item))
    }
    return result
}

fun <T> Collection<T>.customFilterOrNull(
    predicate: ((T) -> Boolean)? = null  // Nullable 기본값
): List<T> {
    if (predicate == null) return this.toList()  // null이면 전체 반환

    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun main() {
    println("=".repeat(60))
    println("다양한 함수 타입 파라미터 패턴")
    println("=".repeat(60))

    val numbers = listOf(1, 2, 3, 4, 5)

    // customMap 예제
    println("기본 map: ${numbers.customMap<Int, Int>()}")  // [1, 2, 3, 4, 5]
    println("곱하기 2: ${numbers.customMap { it * 2 }}")    // [2, 4, 6, 8, 10]

    // customFilterOrNull 예제
    println("\n필터 없음: ${numbers.customFilterOrNull()}")         // [1, 2, 3, 4, 5]
    println("짝수만: ${numbers.customFilterOrNull { it % 2 == 0 }}")  // [2, 4]

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 함수 타입 파라미터의 기본값과 nullable을 적절히 활용")
    println("- 기본값: 일반적인 동작을 미리 정의")
    println("- Nullable: 선택적 동작을 위해 null 허용")
    println("- 두 가지를 조합하여 유연한 API 설계")
    println("=".repeat(60))
}
