package com.bible.ch05.examples.sequences
// Generate Sequence - Kotlin in Action Ch6.2

fun main() {
    println("=== generateSequence로 시퀀스 생성 ===\n")

    // 1. 자연수 시퀀스 생성
    println("1. 자연수 시퀀스 (0부터 100까지 합계):")
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    val sum = numbersTo100.sum()
    println("0 + 1 + 2 + ... + 100 = $sum")
    println("계산식: (0 + 100) * 101 / 2 = ${(0 + 100) * 101 / 2}\n")

    println("=".repeat(50) + "\n")

    // 2. 조건부 시퀀스 (짝수)
    println("2. 조건부 시퀀스 (0부터 20까지 짝수):")
    val evenNumbers = generateSequence(0) { it + 2 }
        .takeWhile { it <= 20 }
        .toList()
    println(evenNumbers)
    println()

    println("=".repeat(50) + "\n")

    // 3. 피보나치 수열
    println("3. 피보나치 수열 (처음 10개):")
    val fibonacci = generateSequence(Pair(0, 1)) {
        Pair(it.second, it.first + it.second)
    }
        .map { it.first }
        .take(10)
        .toList()
    println(fibonacci)
    println()

    println("=".repeat(50) + "\n")

    // 4. 제곱수 시퀀스
    println("4. 제곱수 시퀀스 (100 이하):")
    val squares = generateSequence(1) { it + 1 }
        .map { it * it }
        .takeWhile { it <= 100 }
        .toList()
    println(squares)
    println()

    println("핵심:")
    println("- generateSequence: 무한 시퀀스 생성 가능")
    println("- takeWhile/take: 필요한 만큼만 생성")
    println("- Lazy evaluation으로 메모리 효율적")
}
