package com.bible.ch06.examples.Nallable.LetFunction
/**
 * Week 6 Code Examples: Let Function
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * let 함수와 safe-call operator를 결합하여 nullable 표현식을
 * 효과적으로 처리하는 방법을 학습합니다.
 *
 * 다루는 내용:
 * - let 함수의 기본 동작
 * - Safe-call과 let의 결합 (?. let)
 * - Null일 때 let 블록이 실행되지 않는 특징
 * - 긴 표현식에서 let의 유용성
 */

// ========================================
// 1. Let 함수 기본 동작
// ========================================

fun demonstrateBasicLet() {
    println("예제 1: let 함수 기본 동작")

    val name = "Kotlin"

    // let 함수: 수신 객체를 람다의 인자(it)로 전달
    val result = name.let {
        println("  let 블록 내부: it = $it")
        it.length  // 람다의 마지막 표현식이 결과값
    }

    println("  result = $result")  // 6

    println("\n→ let은 수신 객체를 람다 인자로 전달")
    println("→ 람다의 결과값을 반환")
}

// ========================================
// 2. Nullable 타입에 직접 let 사용 (문제점)
// ========================================

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun demonstrateLetWithoutSafeCall() {
    println("\n예제 2: Nullable 타입에 let을 직접 사용")

    val email: String? = null

    // let은 nullable receiver에서도 호출 가능하지만 null 체크를 하지 않음
    // email.let { sendEmailTo(it) }  // ERROR: Type mismatch (String? vs String)

    println("→ let은 nullable receiver를 허용하지만 null 체크를 하지 않음")
    println("→ Safe-call 없이는 nullable 값을 non-null 파라미터로 전달 불가")
}

// ========================================
// 3. Safe Call과 Let의 결합
// ========================================

/**
 * Listing 7.9: Non-nullable 파라미터를 가진 함수를 호출하기 위해 let 사용
 */
fun demonstrateSafeCallWithLet() {
    println("\n예제 3: Safe-call과 let의 결합")

    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    // Sending email to yole@example.com

    println()

    email = null
    email?.let { sendEmailTo(it) }  // 아무것도 출력되지 않음

    println("→ email이 null이 아닐 때만 let 블록 실행")
    println("→ email이 null이면 let 블록을 건너뜀")
}

// ========================================
// 4. 긴 표현식에서 Let의 유용성
// ========================================

data class Person(val name: String, val email: String)

fun getTheBestPersonInTheWorld(): Person? {
    return Person("Alice", "alice@example.com")
}

fun demonstrateLetWithLongExpressions() {
    println("\n예제 4: 긴 표현식에서 let 활용")

    // 방법 1: 명시적 if 체크 (임시 변수 필요)
    println("방법 1: 명시적 if 체크")
    val person: Person? = getTheBestPersonInTheWorld()
    if (person != null) sendEmailTo(person.email)

    // 방법 2: let 사용 (더 간결)
    println("\n방법 2: let 사용")
    getTheBestPersonInTheWorld()?.let { sendEmailTo(it.email) }

    println("\n→ let을 사용하면 임시 변수 없이 표현식 결과를 처리 가능")
    println("→ 긴 표현식을 반복하지 않아도 됨")
}

// ========================================
// 5. Let을 사용한 변환과 처리
// ========================================

fun demonstrateLetForTransformation() {
    println("\n예제 5: let을 사용한 변환과 처리")

    val input: String? = "  hello world  "

    // 여러 변환을 체이닝
    val processed = input
        ?.let { it.trim() }              // 공백 제거
        ?.let { it.uppercase() }         // 대문자 변환
        ?.let { "Processed: $it" }       // 접두사 추가

    println("결과: $processed")  // Processed: HELLO WORLD

    // Null인 경우
    val nullInput: String? = null
    val nullResult = nullInput
        ?.let { it.trim() }
        ?.let { it.uppercase() }

    println("Null 결과: $nullResult")  // null

    println("\n→ 여러 let을 체이닝하여 단계별 변환 가능")
    println("→ 중간에 null이 나오면 나머지 체인이 실행되지 않음")
}

// ========================================
// 6. Let vs Apply vs Also 비교
// ========================================

fun demonstrateLetComparison() {
    println("\n예제 6: let vs 다른 스코프 함수 비교")

    val name: String? = "Kotlin"

    // let: 인자로 전달, 람다 결과 반환
    val letResult = name?.let {
        println("  let - it: $it")
        it.length
    }
    println("  let 결과: $letResult")

    // also: 인자로 전달, 원본 객체 반환
    val alsoResult = name?.also {
        println("  also - it: $it")
        it.length  // 무시됨
    }
    println("  also 결과: $alsoResult")

    // apply: this로 전달, 원본 객체 반환
    val applyResult = name?.apply {
        println("  apply - this: $this")
        length  // 무시됨
    }
    println("  apply 결과: $applyResult")

    println("\n→ let: 변환 결과 반환 (it 사용)")
    println("→ also: 원본 반환, 부수 효과 수행 (it 사용)")
    println("→ apply: 원본 반환, 객체 설정 (this 사용)")
}

// ========================================
// 7. 실전 예제: 설정 값 처리
// ========================================

data class Config(val apiKey: String?, val timeout: Int?)

fun processConfig(config: Config) {
    println("\n예제 7: 실전 예제 - 설정 값 처리")

    // API 키가 있을 때만 초기화
    config.apiKey?.let { key ->
        println("API 초기화: $key")
        // initializeApi(key)
    } ?: println("API 키 없음 - 기본 설정 사용")

    // 타임아웃 설정
    val actualTimeout = config.timeout?.let { timeout ->
        if (timeout > 0) timeout else 30
    } ?: 30

    println("설정된 타임아웃: ${actualTimeout}초")
}

fun demonstrateRealWorldExample() {
    val config1 = Config("secret-key-123", 60)
    processConfig(config1)

    println()

    val config2 = Config(null, null)
    processConfig(config2)

    println("\n→ let과 Elvis operator를 조합하여 유연한 설정 처리")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Let Function")
    println("=".repeat(60))

    demonstrateBasicLet()
    demonstrateLetWithoutSafeCall()
    demonstrateSafeCallWithLet()
    demonstrateLetWithLongExpressions()
    demonstrateLetForTransformation()
    demonstrateLetComparison()
    demonstrateRealWorldExample()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. let은 수신 객체를 람다 인자(it)로 전달")
    println("2. ?.let은 null이 아닐 때만 블록 실행")
    println("3. 긴 표현식의 결과를 임시 변수 없이 처리 가능")
    println("4. 여러 let을 체이닝하여 단계별 변환 가능")
    println("5. Elvis operator와 조합하여 null 처리 완성")
    println("=".repeat(60))
}
