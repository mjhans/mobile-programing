package com.bible.ch06.examples.Nallable.ElvisOperator
/**
 * Week 6 Code Examples: Elvis Operator
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * Elvis operator (?:)를 사용하여 null일 경우 기본값을 제공하는
 * 방법을 학습합니다. Return과 throw와 함께 사용하는 고급 패턴도 다룹니다.
 *
 * 다루는 내용:
 * - Elvis operator (?:) 기본 사용법
 * - Safe-call과 Elvis operator 조합
 * - Elvis operator와 함께 return 사용
 * - Elvis operator와 함께 throw 사용
 */

// ========================================
// 데이터 클래스 정의
// ========================================

data class Address(
    val streetAddress: String,
    val zipCode: Int,
    val city: String,
    val country: String
)

data class Company(val name: String, val address: Address?)

data class Person(val name: String, val company: Company?)

// ========================================
// 1. Elvis Operator 기본 사용법
// ========================================

fun greet(name: String?) {
    val recipient: String = name ?: "unnamed"  // name이 null이면 "unnamed" 사용
    println("Hello, $recipient!")
}

fun demonstrateBasicElvis() {
    println("예제 1: Elvis operator 기본 사용법")

    greet("Alice")  // Hello, Alice!
    greet(null)     // Hello, unnamed!

    println("\n→ ?: 연산자는 왼쪽 값이 null이면 오른쪽 기본값을 사용합니다")
}

// ========================================
// 2. Safe Call과 Elvis Operator 조합
// ========================================

/**
 * Listing 7.4: Elvis operator를 사용한 null 값 처리
 */
fun strLenSafe(s: String?): Int = s?.length ?: 0

fun demonstrateSafeCallWithElvis() {
    println("\n예제 2: Safe-call과 Elvis operator 조합")

    println("strLenSafe(\"abc\") = ${strLenSafe("abc")}")   // 3
    println("strLenSafe(null) = ${strLenSafe(null)}")       // 0
    println("strLenSafe(\"\") = ${strLenSafe("")}")         // 0

    println("\n→ s?.length는 s가 null이면 null 반환")
    println("→ ?: 0은 null일 경우 0을 기본값으로 제공")
}

// ========================================
// 3. Elvis Operator와 체이닝
// ========================================

fun Person.countryName() = company?.address?.country ?: "Unknown"

fun demonstrateChaining() {
    println("\n예제 3: 체이닝과 Elvis operator")

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val dmitry = Person("Dmitry", jetbrains)
    val personWithoutCompany = Person("Alice", null)

    println("Dmitry의 국가: ${dmitry.countryName()}")              // Germany
    println("Alice의 국가: ${personWithoutCompany.countryName()}")  // Unknown

    println("\n→ 긴 체인의 끝에 Elvis operator로 기본값 제공")
}

// ========================================
// 4. Elvis Operator와 return
// ========================================

fun processName(name: String?): String {
    val validName = name ?: return "이름이 제공되지 않았습니다"
    return "처리된 이름: ${validName.uppercase()}"
}

fun demonstrateElvisWithReturn() {
    println("\n예제 4: Elvis operator와 return")

    println(processName("Kotlin"))  // 처리된 이름: KOTLIN
    println(processName(null))      // 이름이 제공되지 않았습니다

    println("\n→ Elvis의 오른쪽에 return을 사용하여 함수에서 일찍 반환 가능")
}

// ========================================
// 5. Elvis Operator와 throw
// ========================================

/**
 * Listing 7.5: Elvis operator와 함께 throw 사용
 */
fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")  // 주소가 없으면 예외 발생

    with(address) {  // address는 non-null로 보장됨
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun demonstrateElvisWithThrow() {
    println("\n예제 5: Elvis operator와 throw")

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)

    println("정상적인 경우:")
    printShippingLabel(person)
    // Elsestr. 47
    // 80687 Munich, Germany

    println("\n예외 발생 경우:")
    try {
        printShippingLabel(Person("Alexey", null))
    } catch (e: IllegalArgumentException) {
        println("예외 발생: ${e.message}")
    }

    println("\n→ Elvis의 오른쪽에 throw를 사용하여 예외 발생 가능")
    println("→ Kotlin에서 throw와 return은 표현식(expression)입니다")
}

// ========================================
// 6. 다양한 Elvis 사용 패턴
// ========================================

fun demonstrateVariousPatterns() {
    println("\n예제 6: 다양한 Elvis 사용 패턴")

    // 패턴 1: 기본값 제공
    val name: String? = null
    val displayName = name ?: "Guest"
    println("1. 기본값: $displayName")

    // 패턴 2: 빈 컬렉션 기본값
    val list: List<String>? = null
    val safeList = list ?: emptyList()
    println("2. 빈 리스트: $safeList")

    // 패턴 3: 다른 nullable 값 체이닝
    val primary: String? = null
    val secondary: String? = null
    val fallback = "Default"
    val result = primary ?: secondary ?: fallback
    println("3. 다중 체이닝: $result")

    // 패턴 4: 복잡한 표현식
    val config: Map<String, String>? = null
    val value = config?.get("key") ?: "default-value"
    println("4. 복잡한 표현식: $value")

    println("\n→ Elvis operator는 다양한 상황에서 유연하게 사용 가능")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Elvis Operator (?:)")
    println("=".repeat(60))

    demonstrateBasicElvis()
    demonstrateSafeCallWithElvis()
    demonstrateChaining()
    demonstrateElvisWithReturn()
    demonstrateElvisWithThrow()
    demonstrateVariousPatterns()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. ?: 연산자는 왼쪽이 null일 때 오른쪽 기본값 제공")
    println("2. Safe-call과 조합하여 안전하게 기본값 제공")
    println("3. return, throw와 함께 사용하여 제어 흐름 관리")
    println("4. return과 throw는 Kotlin에서 표현식(expression)")
    println("5. 여러 Elvis operator를 체이닝하여 다단계 폴백 가능")
    println("=".repeat(60))
}
