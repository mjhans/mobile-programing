package com.bible.ch05.examples.sequences
// Operation Order Optimization - Kotlin in Action Ch6.2

fun main() {
    println("=== 연산 순서 최적화 ===\n")

    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Charlie", 27),
        Person("Dan", 28),
        Person("Eve", 32)
    )

    // 1. filter → map (효율적)
    println("1. filter 먼저 실행 (효율적):")
    var filterCount = 0
    var mapCount = 0

    val filterFirst = people.asSequence()
        .filter {
            filterCount++
            println("  filter: ${it.name} (길이 ${it.name.length})")
            it.name.length < 4
        }
        .map {
            mapCount++
            println("  map: ${it.name}")
            it.name
        }
        .toList()

    println("결과: $filterFirst")
    println("실행 횟수 → filter: ${filterCount}회, map: ${mapCount}회\n")

    println("=".repeat(50) + "\n")

    // 2. map → filter (비효율적)
    println("2. map 먼저 실행 (비효율적):")
    filterCount = 0
    mapCount = 0

    val mapFirst = people.asSequence()
        .map {
            mapCount++
            println("  map: ${it.name}")
            it.name
        }
        .filter {
            filterCount++
            println("  filter: $it (길이 ${it.length})")
            it.length < 4
        }
        .toList()

    println("결과: $mapFirst")
    println("실행 횟수 → filter: ${filterCount}회, map: ${mapCount}회\n")

    println("=".repeat(50) + "\n")

    // 3. 성능 차이 분석
    println("3. 성능 차이 분석:")
    println("filter → map: 5명 중 2명만 map 실행 (40%)")
    println("map → filter: 5명 모두 map 실행 (100%)")
    println()
    println("결론:")
    println("→ filter를 먼저 하면 불필요한 변환 작업 제거!")
    println("→ 데이터를 줄이는 연산을 먼저 배치하는 것이 효율적")
}
