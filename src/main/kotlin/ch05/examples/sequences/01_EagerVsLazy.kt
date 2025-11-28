package com.bible.ch05.examples.sequences
// Eager vs Lazy Evaluation - Kotlin in Action Ch6.2

fun main() {
    println("=== Eager vs Lazy Evaluation ===\n")

    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Charlie", 27)
    )

    // Eager 실행 (컬렉션)
    println("1. Eager 실행 (일반 컬렉션):")
    val eager = people
        .map {
            println("  map($it)")
            it.name
        }
        .filter {
            println("  filter($it)")
            it.startsWith("A")
        }
    println("결과: $eager")
    println("→ map 3번, filter 3번 실행\n")

    println("=".repeat(50) + "\n")

    // Lazy 실행 (시퀀스)
    println("2. Lazy 실행 (시퀀스):")
    val lazy = people.asSequence()
        .map {
            println("  map($it)")
            it.name
        }
        .filter {
            println("  filter($it)")
            it.startsWith("A")
        }
        .toList()
    println("결과: $lazy")
    println("→ 요소별로 map-filter 순차 처리\n")

    println("=".repeat(50) + "\n")

    // 핵심 차이점
    println("핵심 차이점:")
    println("- Eager: 각 연산마다 중간 리스트 생성")
    println("- Lazy: 중간 컬렉션 없이 요소별 처리")
}
