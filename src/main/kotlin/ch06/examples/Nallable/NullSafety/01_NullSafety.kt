package com.bible.ch06.examples.Nallable.NullSafety
/**
 * Week 6 Code Examples: Null Safety 기초
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * Kotlin의 nullable types와 non-nullable types의 차이를 이해하고,
 * null 체크를 통한 smart cast의 동작 원리를 학습합니다.
 *
 * 다루는 내용:
 * - Non-nullable 타입의 기본 동작
 * - Nullable 타입 선언 방법 (타입 뒤에 ?)
 * - Null 체크 후 smart cast 동작
 * - 컴파일 타임 null 안전성 보장
 */

// ========================================
// 1. Non-nullable Type (기본 동작)
// ========================================

/**
 * Non-nullable 파라미터를 받는 함수
 * String 타입은 null을 허용하지 않음
 */
fun strLen(s: String) = s.length

fun demonstrateNonNullableType() {
    println("예제 1: Non-nullable 타입")
    println("strLen(\"Kotlin\") = ${strLen("Kotlin")}")  // 정상 동작: 6
    println("strLen(\"\") = ${strLen("")}")              // 빈 문자열도 가능: 0

    // 컴파일 에러 예시 (주석 처리됨)
    // strLen(null)  // ERROR: Null can not be a value of a non-null type String

    println("→ Non-nullable 타입은 null 값을 받을 수 없습니다 (컴파일 에러)")
}

// ========================================
// 2. Nullable Type (타입 뒤에 ?)
// ========================================

/**
 * 잘못된 접근: Nullable 타입에 직접 메서드 호출 불가
 */
fun strLenUnsafe(s: String?): Int {
    // return s.length  // ERROR: only safe (?.) or non-null asserted (!!.) calls are allowed
    // Nullable 타입에는 직접 메서드를 호출할 수 없음
    return 0  // 임시 반환값
}

/**
 * Listing 7.1: Nullable 파라미터를 안전하게 처리하는 함수
 */
fun strLenSafe(s: String?): Int =
    if (s != null) s.length else 0  // null 체크 추가로 컴파일 성공

fun demonstrateNullableType() {
    println("\n예제 2: Nullable 타입")

    val nullableString: String? = null
    val validString: String? = "abc"

    println("strLenSafe(null) = ${strLenSafe(nullableString)}")      // 0
    println("strLenSafe(\"abc\") = ${strLenSafe(validString)}")      // 3

    println("→ Nullable 타입은 null 값을 저장할 수 있습니다")
    println("→ Null 체크 후에만 메서드를 호출할 수 있습니다")
}

// ========================================
// 3. Smart Cast (컴파일러의 타입 추론)
// ========================================

fun demonstrateSmartCast() {
    println("\n예제 3: Smart Cast")

    val x: String? = "Kotlin"

    // Smart cast 전: x는 String? 타입
    println("x의 타입: String? (nullable)")

    if (x != null) {
        // Smart cast 후: x는 String 타입으로 자동 변환
        println("null이 아닌 경우, x.length = ${x.length}")
        println("→ 이 블록 안에서 x는 String 타입으로 smart cast됩니다")
    }

    // 블록을 벗어나면 다시 String? 타입
    println("→ 블록을 벗어나면 다시 nullable 타입입니다")
}

// ========================================
// 4. Nullable vs Non-nullable 비교
// ========================================

fun demonstrateComparison() {
    println("\n예제 4: Nullable vs Non-nullable 비교")

    // Non-nullable 타입
    val nonNull: String = "Hello"
    // val nonNull2: String = null  // ERROR: Null can not be a value of a non-null type

    // Nullable 타입
    val nullable: String? = null
    val nullable2: String? = "World"

    println("Non-nullable String: \"$nonNull\"")
    println("Nullable String (null): $nullable")
    println("Nullable String (valid): \"$nullable2\"")

    // 타입 변환 제약
    // var y: String = nullable  // ERROR: Type mismatch
    // strLen(nullable)          // ERROR: Type mismatch

    println("\n→ Nullable 타입은 Non-nullable 변수에 할당할 수 없습니다")
    println("→ Nullable 타입은 Non-nullable 파라미터로 전달할 수 없습니다")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Kotlin Null Safety 기초")
    println("=".repeat(60))

    demonstrateNonNullableType()
    demonstrateNullableType()
    demonstrateSmartCast()
    demonstrateComparison()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. 기본 타입은 non-nullable (null 허용 안 함)")
    println("2. 타입 뒤에 ?를 붙이면 nullable 타입이 됨")
    println("3. Nullable 타입은 null 체크 후에만 메서드 호출 가능")
    println("4. Null 체크 후 컴파일러가 자동으로 smart cast 수행")
    println("5. 컴파일 타임에 null 안전성을 보장하여 NPE 방지")
    println("=".repeat(60))
}
