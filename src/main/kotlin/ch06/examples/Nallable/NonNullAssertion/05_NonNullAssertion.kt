package com.bible.ch06.examples.Nallable.NonNullAssertion
/**
 * Week 6 Code Examples: Non-null Assertion Operator
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * Non-null assertion operator (!!)의 동작과 올바른 사용법을 학습합니다.
 * 언제 사용해야 하고 언제 피해야 하는지 이해합니다.
 *
 * 다루는 내용:
 * - Non-null assertion (!!) 기본 동작
 * - 예외 발생 메커니즘
 * - 올바른 사용 사례
 * - 피해야 할 안티패턴
 */

// ========================================
// 1. Non-null Assertion 기본 동작
// ========================================

/**
 * Listing 7.7: Non-null assertion 사용
 */
fun ignoreNulls(str: String?) {
    val strNotNull: String = str!!  // 예외는 이 라인을 가리킴
    println(strNotNull.length)
}

fun demonstrateBasicAssertion() {
    println("예제 1: Non-null assertion 기본 동작")

    // 정상 동작
    ignoreNulls("Kotlin")  // 6

    // 예외 발생
    try {
        ignoreNulls(null)
    } catch (e: NullPointerException) {
        println("예외 발생: ${e::class.simpleName}")
        println("→ str!! 라인에서 예외 발생")
    }

    println("\n→ !!는 값이 null이면 NullPointerException 발생")
    println("→ null이 아니면 non-null 타입으로 변환")
}

// ========================================
// 2. !! 연산자의 의미
// ========================================

fun demonstrateMeaning() {
    println("\n예제 2: !! 연산자의 의미")

    val str: String? = "Kotlin"

    // !! 사용: "이 값은 절대 null이 아니야!"
    val nonNull: String = str!!

    println("변환 전 타입: String?")
    println("변환 후 타입: String")
    println("값: $nonNull")

    println("\n→ !!는 컴파일러에게 '이 값은 null이 아님'을 보장")
    println("→ 개발자가 null이 아님을 확신할 때만 사용")
}

// ========================================
// 3. 올바른 사용 사례
// ========================================

/**
 * Listing 7.8: Action 클래스에서 non-null assertion 사용
 */
data class SelectableTextList(
    val contents: List<String>,
    var selectedIndex: Int? = null,
)

class CopyRowAction(val list: SelectableTextList) {
    fun isActionEnabled(): Boolean =
        list.selectedIndex != null

    fun executeCopyRow() {  // isActionEnabled가 true일 때만 호출됨
        val index = list.selectedIndex!!
        val value = list.contents[index]
        println("복사: $value")
    }
}

fun demonstrateValidUseCase() {
    println("\n예제 3: 올바른 사용 사례")

    val textList = SelectableTextList(listOf("Line 1", "Line 2", "Line 3"))
    val action = CopyRowAction(textList)

    // 선택하지 않았을 때
    println("선택 전 - 활성화: ${action.isActionEnabled()}")  // false

    // 선택한 후
    textList.selectedIndex = 1
    println("선택 후 - 활성화: ${action.isActionEnabled()}")  // true

    if (action.isActionEnabled()) {
        action.executeCopyRow()  // 복사: Line 2
    }

    println("\n→ isActionEnabled()로 null 체크")
    println("→ executeCopyRow()는 null이 아님을 보장받음")
    println("→ 이런 경우 !!가 안전함")
}

// ========================================
// 4. 안티패턴: 한 줄에 여러 !!
// ========================================

data class Address(val street: String, val city: String)
data class Company(val name: String, val address: Address?)
data class Person(val name: String, val company: Company?)

fun demonstrateAntiPattern() {
    println("\n예제 4: 안티패턴 - 한 줄에 여러 !!  ")

    val person: Person? = Person("Alice",
        Company("ACME", Address("Main St", "Springfield")))

    // 나쁜 예: 한 줄에 여러 !!
    // val city = person!!.company!!.address!!.city

    // 예외가 발생하면 어느 것이 null인지 알 수 없음!
    try {
        val badPerson: Person? = Person("Bob", Company("Corp", null))
        // val city = badPerson!!.company!!.address!!.city
    } catch (e: NullPointerException) {
        println("예외 발생: 어느 것이 null인가?")
        println("→ person? company? address?")
    }

    // 좋은 예: 하나씩 체크
    val goodPerson: Person? = Person("Charlie", null)
    val company = goodPerson?.company
    if (company != null) {
        val address = company.address
        if (address != null) {
            println("주소: ${address.city}")
        }
    }

    println("\n→ 한 줄에 여러 !!는 절대 사용하지 말 것!")
}

// ========================================
// 5. !! vs ?. 선택 가이드
// ========================================

fun demonstrateChoiceGuide() {
    println("\n예제 5: !! vs ?. 선택 가이드")

    val str: String? = "Kotlin"

    // Safe-call 사용 (추천)
    val length1 = str?.length ?: 0
    println("Safe-call: $length1")

    // Non-null assertion 사용 (신중히)
    val length2 = str!!.length
    println("Assertion: $length2")

    println("\n선택 기준:")
    println("1. 다른 함수에서 null 체크 완료 → !! 가능")
    println("2. 값이 null일 수 있음 → ?. 사용")
    println("3. 확신할 수 없으면 → ?. 사용")
    println("4. 빠른 실패가 필요하면 → !! 고려")
}

// ========================================
// 6. 실전 예제: 초기화 패턴
// ========================================

class Configuration {
    private var apiKey: String? = null

    fun initialize(key: String) {
        apiKey = key
    }

    fun makeRequest() {
        // initialize()가 호출되었음을 가정
        val key = apiKey!!  // 초기화 보장
        println("API 요청: key=${key.take(5)}...")
    }
}

fun demonstrateRealWorldExample() {
    println("\n예제 6: 실전 예제 - 초기화 패턴")

    val config = Configuration()

    // 초기화 전 사용 (잘못된 사용)
    try {
        config.makeRequest()
    } catch (e: NullPointerException) {
        println("초기화 전 호출: 예외 발생")
    }

    // 올바른 사용
    config.initialize("secret-key-12345")
    config.makeRequest()  // API 요청: key=secre...

    println("\n→ 초기화가 보장된 상황에서 !! 사용")
    println("→ 하지만 lateinit var가 더 나은 선택")
}

// ========================================
// 7. !! 사용 체크리스트
// ========================================

fun demonstrateChecklist() {
    println("\n예제 7: !! 사용 전 체크리스트")

    println("✓ 다음을 모두 확인하세요:")
    println("  1. 값이 정말로 null이 아닌가?")
    println("  2. 다른 곳에서 null 체크를 했는가?")
    println("  3. 예외가 발생해도 괜찮은가?")
    println("  4. Safe-call이나 Elvis를 쓸 수 없는가?")
    println("  5. 같은 줄에 다른 !!는 없는가?")

    println("\n하나라도 '아니오'면 → !!를 사용하지 마세요!")

    println("\n더 나은 대안:")
    println("  - Safe-call (?.)과 Elvis (  ?: )")
    println("  - 명시적 if (x != null)")
    println("  - lateinit var")
    println("  - requireNotNull() 또는 checkNotNull()")
}

// ========================================
// 8. requireNotNull과 checkNotNull
// ========================================

fun demonstrateHelperFunctions() {
    println("\n예제 8: requireNotNull과 checkNotNull")

    val str: String? = null

    // requireNotNull: 더 나은 메시지와 함께 예외
    try {
        val nonNull = requireNotNull(str) { "String must not be null" }
    } catch (e: IllegalArgumentException) {
        println("requireNotNull: ${e.message}")
    }

    // checkNotNull: 상태 검증용
    try {
        val nonNull = checkNotNull(str) { "Invalid state: string is null" }
    } catch (e: IllegalStateException) {
        println("checkNotNull: ${e.message}")
    }

    println("\n→ !! 대신 명확한 의도를 전달하는 함수 사용")
    println("→ 더 나은 에러 메시지 제공")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Non-null Assertion Operator (!!)")
    println("=".repeat(60))

    demonstrateBasicAssertion()
    demonstrateMeaning()
    demonstrateValidUseCase()
    demonstrateAntiPattern()
    demonstrateChoiceGuide()
    demonstrateRealWorldExample()
    demonstrateChecklist()
    demonstrateHelperFunctions()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. !!는 null일 경우 NullPointerException 발생")
    println("2. 다른 함수에서 null 체크 완료 시에만 사용")
    println("3. 한 줄에 여러 !!는 절대 금지")
    println("4. 확신이 없으면 ?. 이나 Elvis 사용")
    println("5. requireNotNull/checkNotNull이 더 나은 대안")
    println("=".repeat(60))
}
