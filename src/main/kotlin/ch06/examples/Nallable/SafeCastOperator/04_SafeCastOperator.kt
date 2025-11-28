package com.bible.ch06.examples.Nallable.SafeCastOperator

/**
 * Week 6 Code Examples: Safe Cast Operator
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * Safe-cast operator (as?)를 사용하여 타입 캐스팅을 안전하게 수행하는
 * 방법을 학습합니다. equals() 메서드 구현에서의 활용 패턴을 다룹니다.
 *
 * 다루는 내용:
 * - Safe-cast operator (as?) 기본 동작
 * - 일반 cast (as)와의 차이점
 * - equals() 메서드 구현 패턴
 * - Elvis operator와의 결합
 */

// ========================================
// 1. 일반 Cast vs Safe Cast
// ========================================

fun demonstrateRegularCast() {
    println("예제 1: 일반 Cast (as) - 실패 시 예외 발생")

    val obj: Any = "Kotlin"

    // 성공하는 캐스트
    val str: String = obj as String
    println("성공적인 캐스트: $str")  // Kotlin

    // 실패하는 캐스트 (예외 발생)
    try {
        val num: Int = obj as Int  // ClassCastException 발생
    } catch (e: ClassCastException) {
        println("예외 발생: ${e::class.simpleName}")
    }

    println("\n→ 일반 cast (as)는 실패 시 예외를 던짐")
}

fun demonstrateSafeCast() {
    println("\n예제 2: Safe Cast (as?) - 실패 시 null 반환")

    val obj: Any = "Kotlin"

    // 성공하는 캐스트
    val str: String? = obj as? String
    println("성공적인 캐스트: $str")  // Kotlin

    // 실패하는 캐스트 (null 반환)
    val num: Int? = obj as? Int
    println("실패한 캐스트: $num")  // null

    println("\n→ Safe-cast (as?)는 실패 시 null 반환")
    println("→ 결과 타입은 항상 nullable")
}

// ========================================
// 2. Safe Cast와 Elvis Operator 조합
// ========================================

fun processValue(value: Any): String {
    val str = value as? String ?: return "Not a string"
    return "String value: $str"
}

fun demonstrateSafeCastWithElvis() {
    println("\n예제 3: Safe-cast와 Elvis operator 조합")

    println(processValue("Hello"))    // String value: Hello
    println(processValue(42))         // Not a string
    //println(processValue(null))       // Not a string

    println("\n→ as?와 ?:를 함께 사용하여 타입 체크 및 기본값 제공")
}

// ========================================
// 3. Equals 메서드 구현 패턴
// ========================================

/**
 * Listing 7.6: Safe cast를 사용한 equals 구현
 */
class Person(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false  // 타입 체크 및 false 반환

        return otherPerson.firstName == firstName &&  // Smart cast 적용
               otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()

    override fun toString(): String = "Person($firstName, $lastName)"
}

fun demonstrateEqualsImplementation() {
    println("\n예제 4: equals() 메서드에서 safe-cast 활용")

    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    val p3 = Person("Svetlana", "Isakova")

    println("p1 == p2: ${p1 == p2}")        // true (내용이 같음)
    println("p1 == p3: ${p1 == p3}")        // false (내용이 다름)
    println("p1 == null: ${p1 == null}")    // false
    println("p1.equals(42): ${p1.equals(42)}")  // false

    println("\n→ as? Person으로 타입 체크")
    println("→ 캐스트 실패 시 즉시 false 반환")
    println("→ 성공 시 otherPerson은 Person 타입으로 smart cast")
}

// ========================================
// 4. Safe Cast 패턴 분석
// ========================================

fun demonstrateSafeCastPattern() {
    println("\n예제 5: Safe-cast 패턴의 동작 분석")

    fun analyze(obj: Any): String {
        // 패턴: val 변수 = obj as? 타입 ?: 대체_동작
        val person = obj as? Person ?: return "Not a Person"

        // 이 시점에서 person은 Person 타입 (non-null)
        return "Person: ${person.firstName} ${person.lastName}"
    }

    println(analyze(Person("Alice", "Smith")))  // Person: Alice Smith
    println(analyze("Not a person"))            // Not a Person
    println(analyze(123))                       // Not a Person

    println("\n이 패턴은 다음과 동일:")
    println("if (obj !is Person) return ...")
    println("val person = obj as Person")
}

// ========================================
// 5. 여러 타입 처리하기
// ========================================

sealed class Result
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()
data object Loading : Result()

fun handleResult(result: Result): String {
    return when (val success = result as? Success) {
        null -> "Not a success"
        else -> "Data: ${success.data}"
    }
}

fun demonstrateMultipleTypes() {
    println("\n예제 6: 여러 타입 처리")

    println(handleResult(Success("OK")))         // Data: OK
    println(handleResult(Error("Failed")))       // Not a success
    println(handleResult(Loading))               // Not a success

    println("\n→ 특정 타입만 처리하고 나머지는 거부하는 패턴")
}

// ========================================
// 6. 실전 예제: JSON 파싱
// ========================================

fun parseJsonValue(value: Any): String {
    // String 타입
    val str = value as? String
    if (str != null) return "String: \"$str\""

    // Number 타입
    val num = value as? Number
    if (num != null) return "Number: $num"

    // Boolean 타입
    val bool = value as? Boolean
    if (bool != null) return "Boolean: $bool"

    // List 타입
    val list = value as? List<*>
    if (list != null) return "List with ${list.size} elements"

    return "Unknown type"
}

fun demonstrateRealWorldExample() {
    println("\n예제 7: 실전 예제 - JSON 값 파싱")

    println(parseJsonValue("Hello"))           // String: "Hello"
    println(parseJsonValue(42))                // Number: 42
    println(parseJsonValue(3.14))              // Number: 3.14
    println(parseJsonValue(true))              // Boolean: true
    println(parseJsonValue(listOf(1, 2, 3)))   // List with 3 elements
    println(parseJsonValue(Person("A", "B")))  // Unknown type

    println("\n→ Safe-cast로 런타임 타입을 안전하게 체크")
}

// ========================================
// 7. 성능 고려사항
// ========================================

fun demonstratePerformanceNote() {
    println("\n예제 8: 성능 고려사항")

    val obj: Any = "Test"

    // 비효율적: 같은 캐스트를 반복
    val inefficient = {
        val s1 = obj as? String
        val s2 = obj as? String
        val s3 = obj as? String
        "$s1, $s2, $s3"
    }

    // 효율적: 한 번만 캐스트
    val efficient = {
        val str = obj as? String
        "$str, $str, $str"
    }

    println("비효율적: ${inefficient()}")
    println("효율적: ${efficient()}")

    println("\n→ Safe-cast도 런타임 연산이므로 반복 사용 주의")
    println("→ 가능하면 결과를 변수에 저장하여 재사용")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Safe Cast Operator (as?)")
    println("=".repeat(60))

    demonstrateRegularCast()
    demonstrateSafeCast()
    demonstrateSafeCastWithElvis()
    demonstrateEqualsImplementation()
    demonstrateSafeCastPattern()
    demonstrateMultipleTypes()
    demonstrateRealWorldExample()
    demonstratePerformanceNote()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. as? 연산자는 캐스트 실패 시 null 반환")
    println("2. as 연산자는 캐스트 실패 시 예외 발생")
    println("3. as?와 ?: 조합으로 타입 체크 및 대체 동작 구현")
    println("4. equals() 구현의 표준 패턴")
    println("5. Safe-cast 결과 타입은 항상 nullable")
    println("=".repeat(60))
}
