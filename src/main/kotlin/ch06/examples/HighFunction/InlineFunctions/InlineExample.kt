package com.bible.ch06.examples.HighFunction.InlineFunctions
/**
 * Inline 함수 기본 예제
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Inline 함수의 동작 원리와 사용법을 학습합니다.
 * Inline 키워드를 사용하면 함수 호출 위치에 코드가 직접 삽입됩니다.
 */

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Listing 10.14: Inline 함수 정의
 */
inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

data class Person(val name: String, val age: Int)

fun main() {
    println("=".repeat(60))
    println("Inline Functions 예제")
    println("=".repeat(60))

    // 예제 1: Inline 함수 사용
    println("\n예제 1: Inline 함수로 Lock 보호")
    val l = ReentrantLock()
    synchronized(l) {
        println("  Lock으로 보호된 코드 실행")
    }

    // 예제 2: 컬렉션 연산의 inline
    println("\n예제 2: Filter (Listing 10.15)")
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println("  30세 미만: ${people.filter { it.age < 30 }}")

    // 예제 3: 체이닝 (filter + map)
    println("\n예제 3: 체이닝 (filter + map)")
    println("  30세 초과 이름: ${people.filter { it.age > 30 }.map(Person::name)}")

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- inline 함수는 호출 위치에 코드가 직접 삽입됨")
    println("- 람다의 오버헤드(객체 생성) 제거")
    println("- 표준 라이브러리의 filter, map 등은 inline")
    println("- 큰 함수는 inline 비추천 (코드 크기 증가)")
    println("=".repeat(60))
}
