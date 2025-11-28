package com.bible.ch05.examples.sequences
// Element-wise Processing and Early Termination - Kotlin in Action Ch6.2

fun main() {
    println("=== 요소별 순차 처리와 조기 종료 ===\n")

    // 1. 시퀀스 - find로 조기 종료
    println("1. 시퀀스 - find로 조기 종료:")
    val sequenceResult = listOf(1, 2, 3, 4)
        .asSequence()
        .map {
            print("map($it) ")
            it * it
        }
        .find {
            print("find($it) ")
            it > 3
        }
    println("\n결과: $sequenceResult")
    println("→ 1, 2만 처리하고 종료 (4 > 3이므로)\n")

    println("=".repeat(50) + "\n")

    // 2. 컬렉션 - 모든 요소 처리
    println("2. 컬렉션 - 모든 요소 먼저 처리:")
    val collectionResult = listOf(1, 2, 3, 4)
        .map {
            print("map($it) ")
            it * it
        }
        .find {
            print("find($it) ")
            it > 3
        }
    println("\n결과: $collectionResult")
    println("→ 모든 요소를 먼저 map한 후 find\n")

    println("=".repeat(50) + "\n")

    // 3. 효율성 비교
    println("3. 효율성 비교 (큰 리스트):")
    val largeList = (1..10).toList()

    print("시퀀스: ")
    val seqEfficient = largeList.asSequence()
        .map {
            print(".")
            it * it
        }
        .find { it > 10 }
    println(" → $seqEfficient")

    print("컬렉션: ")
    val colEfficient = largeList
        .map {
            print(".")
            it * it
        }
        .find { it > 10 }
    println(" → $colEfficient\n")

    println("핵심:")
    println("- 시퀀스: 조건 만족 시 즉시 종료 (효율적)")
    println("- 컬렉션: 모든 변환 후 검색 (비효율적)")
}
