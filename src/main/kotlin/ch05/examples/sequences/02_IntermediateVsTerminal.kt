package com.bible.ch05.examples.sequences
// Intermediate vs Terminal Operations - Kotlin in Action Ch6.2

fun main() {
    println("=== Intermediate vs Terminal Operations ===\n")

    // 1. Terminal operation 없음 - 실행 안 됨
    println("1. Terminal operation 없음:")
    println("아래 시퀀스는 출력이 없습니다:")
    listOf(1, 2, 3, 4)
        .asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
    println("← 출력 없음 (terminal operation이 없어서 실행 안 됨)\n")

    println("=".repeat(50) + "\n")

    // 2. Terminal operation 있음 - 실행됨
    println("2. Terminal operation 있음 (toList):")
    val result = listOf(1, 2, 3, 4)
        .asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\n결과: $result\n")

    println("=".repeat(50) + "\n")

    // 3. 다양한 Terminal operations
    println("3. 다양한 Terminal operations:")

    val numbers = listOf(1, 2, 3, 4).asSequence()
        .map { it * it }

    println("toList(): ${numbers.toList()}")
    println("count(): ${numbers.count()}")
    println("sum(): ${numbers.sum()}")
    println("max(): ${numbers.max()}")
    println()

    println("핵심 개념:")
    println("- Intermediate: map, filter 등은 지연 실행")
    println("- Terminal: toList, count 등이 실제 실행 트리거")
}
