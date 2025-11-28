package com.bible.ch06.examples.Nallable.SafeCallOperator
/**
 * Week 6 Code Examples: Safe Call Operator
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * Safe-call operator (?.)를 사용하여 null 체크와 메서드 호출을
 * 하나의 연산으로 결합하는 방법을 학습합니다.
 *
 * 다루는 내용:
 * - Safe-call operator (?.) 기본 사용법
 * - Nullable 결과 타입 처리
 * - 여러 safe-call 체이닝
 * - 프로퍼티 접근에서의 safe-call 활용
 */

// ========================================
// 데이터 클래스 정의
// ========================================

// Listing 7.2를 위한 Employee 클래스
data class Employee(val name: String, val manager: Employee?)

// Listing 7.3을 위한 클래스들
data class Address(
    val streetAddress: String,
    val zipCode: Int,
    val city: String,
    val country: String
)

data class Company(val name: String, val address: Address?)

data class Person(val name: String, val company: Company?)

// ========================================
// 1. Safe Call 기본 사용법
// ========================================

fun demonstrateBasicSafeCall() {
    println("예제 1: Safe-call 기본 사용법")

    val str: String? = "Kotlin"
    val nullStr: String? = null

    // str?.uppercase()는 다음과 동일:
    // if (str != null) str.uppercase() else null

    println("str?.uppercase() = ${str?.uppercase()}")        // KOTLIN
    println("nullStr?.uppercase() = ${nullStr?.uppercase()}") // null

    println("\n→ Safe-call은 null이 아닐 때만 메서드를 호출합니다")
    println("→ 결과는 nullable 타입입니다")
}

// ========================================
// 2. 프로퍼티 접근에서의 Safe Call
// ========================================

/**
 * Listing 7.2: Safe calls를 사용한 nullable 프로퍼티 처리
 */
fun managerName(employee: Employee): String? = employee.manager?.name

fun demonstratePropertyAccess() {
    println("\n예제 2: 프로퍼티 접근에서의 Safe-call")

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)

    println("CEO의 매니저: ${managerName(ceo)}")           // null
    println("개발자의 매니저: ${managerName(developer)}")  // Da Boss

    println("\n→ employee.manager?.name은 manager가 null이면 null 반환")
    println("→ manager가 null이 아니면 name 프로퍼티 반환")
}

// ========================================
// 3. Safe Call 체이닝
// ========================================

/**
 * Listing 7.3: 여러 safe-call operator 체이닝
 */
fun Person.countryName(): String {
    val country = this.company?.address?.country  // 체인으로 여러 safe-call 사용
    return if (country != null) country else "Unknown"
}

fun demonstrateChaining() {
    println("\n예제 3: Safe-call 체이닝")

    // 모든 값이 있는 경우
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val dmitry = Person("Dmitry", jetbrains)

    // company가 null인 경우
    val personWithoutCompany = Person("Alice", null)

    // address가 null인 경우
    val companyWithoutAddress = Company("Startup", null)
    val bob = Person("Bob", companyWithoutAddress)

    println("Dmitry의 국가: ${dmitry.countryName()}")              // Germany
    println("Alice의 국가: ${personWithoutCompany.countryName()}")  // Unknown
    println("Bob의 국가: ${bob.countryName()}")                    // Unknown

    println("\n→ 체인 중 하나라도 null이면 전체 결과가 null")
    println("→ company?.address?.country는 단계별로 null 체크")
}

// ========================================
// 4. Safe Call vs 명시적 if 체크 비교
// ========================================

fun demonstrateComparison() {
    println("\n예제 4: Safe-call vs 명시적 if 체크")

    val person: Person? = Person("Charlie", null)

    // 명시적 if 체크 방식
    val country1 = if (person != null && person.company != null && person.company.address != null) {
        person.company.address.country
    } else {
        "Unknown"
    }

    // Safe-call 체이닝 방식 (훨씬 간결!)
    val country2 = person?.company?.address?.country ?: "Unknown"

    println("명시적 if 체크 결과: $country1")
    println("Safe-call 체이닝 결과: $country2")

    println("\n→ Safe-call 체이닝이 훨씬 간결하고 읽기 쉽습니다")
}

// ========================================
// 5. Safe Call의 결과 타입
// ========================================

fun printAllCaps(str: String?) {
    val allCaps: String? = str?.uppercase()  // allCaps는 nullable 타입
    println(allCaps)
}

fun demonstrateResultType() {
    println("\n예제 5: Safe-call의 결과 타입")

    printAllCaps("abc")  // ABC
    printAllCaps(null)   // null

    println("\n→ Safe-call의 결과는 항상 nullable 타입입니다")
    println("→ str이 String?이면 str?.uppercase()는 String? 반환")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Safe Call Operator (?.)")
    println("=".repeat(60))

    demonstrateBasicSafeCall()
    demonstratePropertyAccess()
    demonstrateChaining()
    demonstrateComparison()
    demonstrateResultType()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. ?. 연산자는 null 체크와 메서드 호출을 결합")
    println("2. 값이 null이면 메서드를 호출하지 않고 null 반환")
    println("3. 여러 safe-call을 체인으로 연결 가능")
    println("4. 체인 중 하나라도 null이면 전체 결과가 null")
    println("5. Safe-call의 결과는 항상 nullable 타입")
    println("=".repeat(60))
}
