package com.bible.ch06.examples.HighFunction.ResourceManagement
/**
 * use 함수를 사용한 리소스 관리
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * use 함수로 리소스를 자동으로 닫는 방법을 학습합니다.
 * Java의 try-with-resources와 유사하지만 더 간결합니다.
 */

/**
 * Listing 10.17 시뮬레이션: use 함수 패턴
 */

fun readFirstLineFromFile(content: String): String {
    return MockReader(content).use { reader ->
        reader.readLine()
    }
}

fun main() {
    println("=".repeat(60))
    println("use 함수를 사용한 리소스 관리")
    println("=".repeat(60))

    println("\n예제: use 함수")
    val line = readFirstLineFromFile("Hello, World!")
    println("읽은 내용: $line")

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- use: 리소스를 자동으로 닫음 (try-with-resources)")
    println("- AutoCloseable 인터페이스를 구현한 모든 리소스에 사용")
    println("- 예외 발생 시에도 리소스 정리 보장")
    println("- Java의 try-with-resources보다 간결")
    println()
    println("사용 패턴:")
    println("  resource.use { res ->")
    println("    // 리소스 사용")
    println("  } // 자동으로 close() 호출")
    println("=".repeat(60))
}
