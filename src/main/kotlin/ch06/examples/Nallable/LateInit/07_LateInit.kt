package com.bible.ch06.examples.Nallable.LateInit
/**
 * Week 6 Code Examples: Late-Initialized Properties
 * 출처: Kotlin in Action, Second Edition - Chapter 7
 *
 * lateinit 키워드를 사용하여 non-null 타입이지만 즉시 초기화하지 않아도
 * 되는 프로퍼티를 선언하는 방법을 학습합니다.
 *
 * 다루는 내용:
 * - lateinit var의 필요성
 * - 프레임워크 초기화 패턴
 * - lateinit의 제약사항
 * - 초기화 전 접근 시 예외 처리
 */

// ========================================
// 1. 문제: Nullable 프로퍼티의 불편함
// ========================================

/**
 * Listing 7.10: Nullable 프로퍼티에 접근하기 위한 non-null assertions 사용
 */
class MyService {
    fun performAction(): String = "Action Done!"
}

// 이 어노테이션들은 실제로는 JUnit import가 필요하지만, 데모용으로 정의
annotation class TestInstance(val value: Lifecycle) {
    enum class Lifecycle { PER_CLASS }
}
annotation class BeforeAll
annotation class Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyTestWithNullable {
    private var myService: MyService? = null  // null로 초기화하기 위해 nullable 타입 선언

    @BeforeAll
    fun setUp() {
        myService = MyService()  // setUp 메서드에서 실제 초기화
    }

    @Test
    fun testAction() {
        // 매번 !! 사용 필요
        val result = myService!!.performAction()
        println("결과: $result")
        // assertEquals("Action Done!", myService!!.performAction())
    }
}

fun demonstrateProblem() {
    println("예제 1: Nullable 프로퍼티의 문제점")

    val test = MyTestWithNullable()
    test.setUp()
    test.testAction()  // 결과: Action Done!

    println("\n→ myService는 항상 초기화되지만 nullable 타입")
    println("→ 매번 !!를 사용해야 함")
    println("→ 코드가 지저분하고 의도가 불명확")
}

// ========================================
// 2. 해결책: lateinit var
// ========================================

/**
 * Listing 7.11: Late-initialized 프로퍼티 사용
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyTestWithLateinit {
    private lateinit var myService: MyService  // 초기화 없이 non-null 타입 선언

    @BeforeAll
    fun setUp() {
        myService = MyService()  // 이전과 동일하게 초기화
    }

    @Test
    fun testAction() {
        val result = myService.performAction()  // 추가 null 체크 불필요
        println("결과: $result")
        // assertEquals("Action Done!", myService.performAction())
    }
}

fun demonstrateSolution() {
    println("\n예제 2: lateinit으로 해결")

    val test = MyTestWithLateinit()
    test.setUp()
    test.testAction()  // 결과: Action Done!

    println("\n→ myService는 non-null 타입")
    println("→ !! 불필요")
    println("→ 코드가 깔끔하고 의도가 명확")
}

// ========================================
// 3. lateinit 초기화 전 접근
// ========================================

class DatabaseConnection {
    private lateinit var connection: String

    fun connect() {
        connection = "Connected to DB"
    }

    fun query() {
        println(connection)  // 초기화되지 않았으면 예외 발생
    }
}

fun demonstrateUninitializedAccess() {
    println("\n예제 3: 초기화 전 접근 시 예외")

    val db = DatabaseConnection()

    try {
        db.query()  // 초기화 전 접근
    } catch (e: UninitializedPropertyAccessException) {
        println("예외: ${e.message}")
        println("→ 명확한 에러 메시지 제공")
    }

    // 초기화 후 정상 동작
    db.connect()
    db.query()  // Connected to DB

    println("\n→ NullPointerException 대신")
    println("→ UninitializedPropertyAccessException 발생")
}

// ========================================
// 4. lateinit의 제약사항
// ========================================

class LateinitConstraints {
    // ✓ 가능: var 프로퍼티
    private lateinit var validString: String

    // ✗ 불가능: val 프로퍼티
    // private lateinit val invalidVal: String  // ERROR

    // ✗ 불가능: Primitive 타입
    // private lateinit var invalidInt: Int  // ERROR

    // ✓ 가능: Nullable이 아닌 참조 타입만
    private lateinit var validList: List<String>
    private lateinit var validMap: Map<String, Int>

    fun initialize() {
        validString = "OK"
        validList = listOf("a", "b")
        validMap = mapOf("key" to 1)
    }
}

fun demonstrateConstraints() {
    println("\n예제 4: lateinit의 제약사항")

    println("lateinit 사용 가능:")
    println("  ✓ var 프로퍼티만")
    println("  ✓ Non-null 참조 타입만")
    println("  ✓ 클래스 본문에 선언된 프로퍼티")

    println("\nlate init 사용 불가:")
    println("  ✗ val 프로퍼티")
    println("  ✗ Primitive 타입 (Int, Boolean 등)")
    println("  ✗ Nullable 타입 (String? 등)")
    println("  ✗ 커스텀 getter/setter가 있는 프로퍼티")
}

// ========================================
// 5. Android에서의 활용
// ========================================

// Android Activity 시뮬레이션
abstract class Activity {
    open fun onCreate() {}
}

class MyActivity : Activity() {
    private lateinit var textView: String  // TextView 시뮬레이션
    private lateinit var adapter: String   // Adapter 시뮬레이션

    override fun onCreate() {
        // Activity 생성 시 View 초기화
        textView = "TextView initialized"
        adapter = "Adapter initialized"
    }

    fun updateUI() {
        println(textView)
        println(adapter)
    }
}

fun demonstrateAndroidPattern() {
    println("\n예제 5: Android Activity 패턴")

    val activity = MyActivity()
    activity.onCreate()
    activity.updateUI()
    // TextView initialized
    // Adapter initialized

    println("\n→ Android의 onCreate()에서 View 초기화")
    println("→ lateinit으로 nullable 프로퍼티 회피")
}

// ========================================
// 6. 초기화 여부 확인
// ========================================

class ConfigManager {
    private lateinit var apiKey: String

    fun setApiKey(key: String) {
        apiKey = key
    }

    fun isInitialized(): Boolean {
        return ::apiKey.isInitialized  // 초기화 여부 확인
    }

    fun getApiKey(): String {
        return if (isInitialized()) {
            apiKey
        } else {
            "Not initialized"
        }
    }
}

fun demonstrateInitializationCheck() {
    println("\n예제 6: 초기화 여부 확인")

    val config = ConfigManager()

    println("초기화 전: ${config.isInitialized()}")  // false
    println("값 조회: ${config.getApiKey()}")        // Not initialized

    config.setApiKey("secret-123")

    println("\n초기화 후: ${config.isInitialized()}")  // true
    println("값 조회: ${config.getApiKey()}")         // secret-123

    println("\n→ ::프로퍼티.isInitialized로 확인 가능")
}

// ========================================
// 7. lateinit vs lazy 비교
// ========================================

class ComparisonExample {
    // lateinit: 언제든지 값을 할당
    lateinit var mutableValue: String

    // lazy: 최초 접근 시 한 번만 초기화
    val immutableValue: String by lazy {
        println("  lazy 초기화 실행")
        "Lazy initialized"
    }

    fun demonstrate() {
        println("lateinit 할당 전: ${::mutableValue.isInitialized}")
        mutableValue = "First"
        println("lateinit 값: $mutableValue")

        mutableValue = "Second"  // 재할당 가능
        println("lateinit 재할당: $mutableValue")

        println("\nlazy 첫 접근:")
        println(immutableValue)  // 이때 초기화

        println("lazy 두 번째 접근:")
        println(immutableValue)  // 초기화 안 함
    }
}

fun demonstrateLateinitVsLazy() {
    println("\n예제 7: lateinit vs lazy")

    ComparisonExample().demonstrate()

    println("\n차이점:")
    println("lateinit:")
    println("  - var만 가능")
    println("  - 여러 번 할당 가능")
    println("  - 외부에서 초기화")

    println("\nlazy:")
    println("  - val에 사용")
    println("  - 한 번만 초기화")
    println("  - 첫 접근 시 자동 초기화")
}

// ========================================
// Main 함수: 모든 예제 실행
// ========================================

fun main() {
    println("=".repeat(60))
    println("Chapter 7: Late-Initialized Properties (lateinit)")
    println("=".repeat(60))

    demonstrateProblem()
    demonstrateSolution()
    demonstrateUninitializedAccess()
    demonstrateConstraints()
    demonstrateAndroidPattern()
    demonstrateInitializationCheck()
    demonstrateLateinitVsLazy()

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("1. lateinit: Non-null 타입이지만 나중에 초기화")
    println("2. var 프로퍼티에만 사용 가능")
    println("3. Primitive 타입은 불가능 (Int, Boolean 등)")
    println("4. 초기화 전 접근 시 명확한 예외 발생")
    println("5. ::프로퍼티.isInitialized로 확인 가능")
    println("=".repeat(60))
}
