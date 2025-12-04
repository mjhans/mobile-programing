package com.bible.ch06.examples.HighFunction.HigherOrderBasics

/**
 * 다양한 Higher-Order Functions (Various Higher-Order Functions)
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * filter, map 등 여러 higher-order function을 직접 구현하여 패턴을 이해합니다.
 * 재사용 가능한 알고리즘을 작성하는 방법을 학습합니다.
 */

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun <T> List<T>.customMap(transform: (T) -> T): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        result.add(transform(item))
    }
    return result
}

fun main() {
    println("=".repeat(60))
    println("다양한 Higher-Order Functions")
    println("=".repeat(60))

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // customFilter 사용
    val evens = numbers.customFilter { it % 2 == 0 }
    println("짝수: $evens")  // [2, 4, 6, 8, 10]

    val greaterThan5 = numbers.customFilter { it > 5 }
    println("5보다 큰 수: $greaterThan5")  // [6, 7, 8, 9, 10]

    // customMap 사용
    val doubled = numbers.customMap { it * 2 }
    println("2배: $doubled")  // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

    val squared = numbers.customMap { it * it }
    println("제곱: $squared")  // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- Higher-order function으로 재사용 가능한 알고리즘 작성")
    println("- customFilter: predicate로 요소 선택")
    println("- customMap: transform으로 요소 변환")
    println("- 제네릭 타입으로 다양한 타입에 적용 가능")
    println("=".repeat(60))
}
