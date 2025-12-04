package com.bible.ch06.examples.HighFunction.ResourceManagement
/**
 * withLock을 사용한 동기화
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * withLock 함수로 락을 자동으로 해제하는 방법을 학습합니다.
 * 동기화 코드를 안전하고 간결하게 작성할 수 있습니다.
 */

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main() {
    println("=".repeat(60))
    println("withLock을 사용한 동기화")
    println("=".repeat(60))

    val lock = ReentrantLock()

    println("\n예제: withLock 패턴")
    lock.withLock {
        println("  → Lock으로 보호된 영역")
        println("  → 안전하게 공유 자원에 접근")
    }
    println("  → Lock 자동으로 해제됨")

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- withLock: 락을 자동으로 해제")
    println("- 예외 발생 시에도 락 해제 보장")
    println("- 데드락 위험 감소")
    println()
    println("사용 패턴:")
    println("  lock.withLock {")
    println("    // 보호된 코드")
    println("  } // 자동으로 unlock()")
    println()
    println("Java 동등 코드:")
    println("  lock.lock()")
    println("  try {")
    println("    // 보호된 코드")
    println("  } finally {")
    println("    lock.unlock()")
    println("  }")
    println("=".repeat(60))
}
