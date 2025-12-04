package com.bible.ch06.examples.HighFunction.ResourceManagement
/**
 * 여러 리소스 관리
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 중첩된 use를 사용하여 여러 리소스를 안전하게 관리하는 방법을 학습합니다.
 * 모든 리소스가 올바른 순서로 닫히는 것을 보장합니다.
 */

class MockReader(private val content: String) : AutoCloseable {
    fun readLine(): String = content

    override fun close() {
        println("  → '$content' 리소스 닫힘")
    }
}

fun main() {
    println("=".repeat(60))
    println("여러 리소스 관리")
    println("=".repeat(60))

    println("\n예제: 중첩된 use")
    MockReader("Line 1").use { reader1 ->
        MockReader("Line 2").use { reader2 ->
            println("  읽기: ${reader1.readLine()}")
            println("  읽기: ${reader2.readLine()}")
        }
    }

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 중첩된 use로 여러 리소스 관리")
    println("- 안쪽에서 바깥쪽 순서로 리소스 닫힘")
    println("- 예외가 발생해도 모든 리소스 정리 보장")
    println()
    println("닫히는 순서:")
    println("  1. reader2.close()")
    println("  2. reader1.close()")
    println()
    println("장점:")
    println("  - 리소스 누수 방지")
    println("  - 코드가 간결하고 명확")
    println("  - 예외 안전성 보장")
    println("=".repeat(60))
}
