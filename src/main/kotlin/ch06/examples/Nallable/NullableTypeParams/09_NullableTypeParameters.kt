package com.bible.ch06.examples.Nallable.NullableTypeParams
/**
 * Week 6 Code Examples: Nullability of Type Parameters
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * 제네릭 타입 파라미터의 nullability를 이해하고 제어하는 방법을 학습합니다.
 */

// Listing 7.13: Nullable 타입 파라미터 다루기
fun <T> printHashCode(t: T) {
    println(t?.hashCode())  // t가 null일 수 있으므로 safe call 사용
}

// Listing 7.14: Non-nullable upper bound를 가진 타입 파라미터 선언
fun <T : Any> printHashCodeNonNull(t: T) {  // 이제 T는 nullable이 될 수 없음
    println(t.hashCode())  // Safe call 불필요
}

fun main() {
    println("=== Nullable Type Parameters 예제 ===\n")

    // 예제 1: 기본 타입 파라미터 (nullable)
    println("예제 1: 기본 타입 파라미터")
    printHashCode("Kotlin")  // Kotlin의 hashCode
    printHashCode(null)      // null

    println("\n타입 파라미터 T는 기본적으로 nullable")
    println("T는 Any?로 추론됨")

    // 예제 2: Non-nullable upper bound
    println("\n예제 2: Non-nullable upper bound")
    printHashCodeNonNull("Kotlin")  // Kotlin의 hashCode
    printHashCodeNonNull(42)        // 42의 hashCode
    // printHashCodeNonNull(null)   // ERROR: Type mismatch

    println("\n<T : Any>로 non-nullable 타입 파라미터 선언")

    // 예제 3: List 타입 파라미터
    println("\n예제 3: List의 타입 파라미터")

    fun <T> processList(list: List<T>) {
        for (item in list) {
            println("Item: $item (${item?.javaClass?.simpleName})")
        }
    }

    processList(listOf("a", "b", null))  // null 허용
    processList(listOf(1, 2, 3))

    println("\n" + "=".repeat(50))
    println("핵심 포인트:")
    println("1. 타입 파라미터 <T>는 기본적으로 nullable (T = Any?)")
    println("2. ?를 명시하지 않아도 null 가능")
    println("3. <T : Any>로 non-nullable 제약")
    println("4. upper bound로 nullability 제어")
    println("=".repeat(50))
}
