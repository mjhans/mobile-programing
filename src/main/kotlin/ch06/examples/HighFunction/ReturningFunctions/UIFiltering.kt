package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * UI 필터링 시스템
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 설정에 따라 동적으로 필터 조건을 조합하는 UI 시스템 예제를 학습합니다.
 * 여러 조건을 조합하여 하나의 predicate 함수를 생성합니다.
 */

/**
 * Listing 10.8: UI 코드에서 함수를 반환하는 함수 사용
 */
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {  // 함수를 반환하는 함수 선언
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix  // 함수 타입 변수 반환
        }
        return { startsWithPrefix(it) && it.phoneNumber != null }  // 람다 반환
    }
}

fun main() {
    println("=".repeat(60))
    println("UI 필터링 시스템")
    println("=".repeat(60))

    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null),
        Person("Daria", "Smith", "987-6543"),
        Person("Alice", "Johnson", null)
    )

    val filters = ContactListFilters()

    // 필터 1: prefix만
    filters.prefix = "D"
    filters.onlyWithPhoneNumber = false
    val filtered1 = contacts.filter(filters.getPredicate())
    println("D로 시작: ${filtered1.map { it.firstName }}")
    // [Dmitry, Daria]

    // 필터 2: prefix + 전화번호 있음
    filters.prefix = "D"
    filters.onlyWithPhoneNumber = true
    val filtered2 = contacts.filter(filters.getPredicate())
    println("D로 시작 + 전화번호: ${filtered2.map { it.firstName }}")
    // [Dmitry, Daria]

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 설정에 따라 다른 필터 함수 반환")
    println("- 동적으로 필터 조건 조합")
    println("- UI 상태를 로직으로 변환하는 패턴")
    println("=".repeat(60))
}
