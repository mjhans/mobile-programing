package com.bible.ch04.examples.KotlinOOP

/*
 * Sealed Class와 계층 제어
 *
 * sealed class/interface는 제한된 상속 계층을 관리하여 타입 안전성을 보장합니다.
 *
 * 장점:
 * - 컴파일 타임에 모든 하위 타입을 알 수 있음
 * - when 식에서 모든 경우를 다루었는지 컴파일러가 검증
 * - else 분기 불필요
 */

// ============================================
// 수식 계산기 예제
// ============================================

sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        // else 분기 불필요 - 모든 경우를 다룸
    }

// ============================================
// API 결과 처리 예제
// ============================================

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}

fun <T> processResult(result: ApiResult<T>) {
    when (result) {
        is ApiResult.Success -> println("✅ 데이터: ${result.data}")
        is ApiResult.Error -> println("❌ 에러: ${result.exception.message}")
        ApiResult.Loading -> println("⏳ 로딩 중...")
        // No else needed - all cases covered
    }
}

// ============================================
// 네트워크 상태 예제
// ============================================

sealed class NetworkState {
    object Idle : NetworkState()
    object Connecting : NetworkState()
    data class Connected(val serverUrl: String) : NetworkState()
    data class Disconnected(val reason: String) : NetworkState()
    data class Error(val errorCode: Int, val message: String) : NetworkState()
}

class NetworkManager {
    private var state: NetworkState = NetworkState.Idle

    fun handleState(newState: NetworkState) {
        state = newState

        // Exhaustive when - 모든 경우를 다루어야 함
        val message = when (state) {
            NetworkState.Idle -> "대기 중"
            NetworkState.Connecting -> "연결 중..."
            is NetworkState.Connected -> "연결됨: ${(state as NetworkState.Connected).serverUrl}"
            is NetworkState.Disconnected -> "연결 끊김: ${(state as NetworkState.Disconnected).reason}"
            is NetworkState.Error -> {
                val error = state as NetworkState.Error
                "오류 발생 (${error.errorCode}): ${error.message}"
            }
        }

        println("[NetworkState] $message")
    }
}

// ============================================
// UI 이벤트 처리 예제
// ============================================

sealed class UiEvent {
    data class ButtonClick(val buttonId: String) : UiEvent()
    data class TextInput(val fieldId: String, val text: String) : UiEvent()
    data class ItemSelected(val itemId: String, val position: Int) : UiEvent()
    object ScreenRefresh : UiEvent()
    object BackPressed : UiEvent()
}

class EventHandler {
    fun handleEvent(event: UiEvent) {
        when (event) {
            is UiEvent.ButtonClick -> {
                println("버튼 클릭: ${event.buttonId}")
            }
            is UiEvent.TextInput -> {
                println("텍스트 입력: ${event.fieldId} = ${event.text}")
            }
            is UiEvent.ItemSelected -> {
                println("아이템 선택: ${event.itemId} at position ${event.position}")
            }
            UiEvent.ScreenRefresh -> {
                println("화면 새로고침")
            }
            UiEvent.BackPressed -> {
                println("뒤로 가기")
            }
        }
    }
}

// ============================================
// Enum vs Sealed Class 비교
// ============================================

// Enum: 각 상수가 단일 인스턴스
enum class ColorEnum { RED, GREEN, BLUE }

// Sealed Class: 각 하위 타입이 여러 인스턴스 가능
sealed class ColorSealed {
    data class RGB(val r: Int, val g: Int, val b: Int) : ColorSealed()
    data class HSL(val h: Int, val s: Int, val l: Int) : ColorSealed()
    object Transparent : ColorSealed()
}

fun main() {
    println("=" .repeat(70))
    println("Sealed Class와 계층 제어")
    println("=" .repeat(70))

    // ============================================
    // 수식 계산기
    // ============================================
    println("\n[수식 계산기 - Exhaustive When]")
    println("-".repeat(70))

    val expr1 = Sum(Num(1), Num(2))  // 1 + 2
    val expr2 = Sum(Sum(Num(1), Num(2)), Num(4))  // (1 + 2) + 4

    println("expr1 = 1 + 2 = ${eval(expr1)}")
    println("expr2 = (1 + 2) + 4 = ${eval(expr2)}")

    // ============================================
    // API 결과 처리
    // ============================================
    println("\n[API 결과 처리]")
    println("-".repeat(70))

    val results = listOf<ApiResult<String>>(
        ApiResult.Loading,
        ApiResult.Success("사용자 데이터"),
        ApiResult.Error(Exception("네트워크 오류")),
        ApiResult.Success("시스템"),
        ApiResult.Loading,
        ApiResult.Success("데이터")
    )

    results.forEach { processResult(it) }

    // ============================================
    // 네트워크 상태
    // ============================================
    println("\n[네트워크 상태 관리]")
    println("-".repeat(70))

    val manager = NetworkManager()

    manager.handleState(NetworkState.Idle)
    manager.handleState(NetworkState.Connecting)
    manager.handleState(NetworkState.Connected("https://api.example.com"))
    manager.handleState(NetworkState.Disconnected("사용자 요청"))
    manager.handleState(NetworkState.Error(404, "Not Found"))

    // ============================================
    // UI 이벤트 처리
    // ============================================
    println("\n[UI 이벤트 처리]")
    println("-".repeat(70))

    val handler = EventHandler()

    handler.handleEvent(UiEvent.ButtonClick("btn_submit"))
    handler.handleEvent(UiEvent.TextInput("username", "john_doe"))
    handler.handleEvent(UiEvent.ItemSelected("item_123", 5))
    handler.handleEvent(UiEvent.ScreenRefresh)
    handler.handleEvent(UiEvent.BackPressed)

    // ============================================
    // Enum vs Sealed Class
    // ============================================
    println("\n[Enum vs Sealed Class 비교]")
    println("-".repeat(70))

    // Enum: 제한된 단일 인스턴스
    val enumColor = ColorEnum.RED
    println("Enum: $enumColor")

    // Sealed Class: 다양한 인스턴스 생성 가능
    val rgb1 = ColorSealed.RGB(255, 0, 0)
    val rgb2 = ColorSealed.RGB(0, 255, 0)
    val hsl = ColorSealed.HSL(120, 100, 50)

    listOf(rgb1, rgb2, hsl, ColorSealed.Transparent).forEach { color ->
        val description = when (color) {
            is ColorSealed.RGB -> "RGB(${color.r}, ${color.g}, ${color.b})"
            is ColorSealed.HSL -> "HSL(${color.h}, ${color.s}, ${color.l})"
            ColorSealed.Transparent -> "투명"
        }
        println("Color: $description")
    }

}
/*
[타입 안전성 - 컴파일 타임 검증]
----------------------------------------------------------------------
Sealed Class를 사용하면 새로운 하위 타입 추가 시:

1. 모든 when 식에서 컴파일 에러 발생
2. 개발자가 모든 경우를 다루도록 강제
3. 런타임 에러 방지

예: NetworkState에 새로운 타입 추가
- data class Reconnecting : NetworkState()
→ 모든 when 식에서 Reconnecting 처리 필요
→ 컴파일 에러로 알려줌

======================================================================
Sealed Class의 장점
======================================================================
✅ 타입 안전성:
   - 컴파일 타임에 모든 하위 타입을 알 수 있음
   - when 식에서 모든 경우를 다루었는지 컴파일러가 검증

✅ else 분기 불필요:
   - 모든 경우를 명시적으로 처리
   - 새로운 타입 추가 시 컴파일 에러

✅ 유연성:
   - Enum보다 유연 (각 타입이 여러 인스턴스 가능)
   - 각 타입이 다른 프로퍼티 가질 수 있음

✅ 활용 사례:
   - API 응답 모델 (Success, Error, Loading)
   - 상태 관리 (Idle, Connecting, Connected, etc.)
   - 이벤트 처리 (Click, Input, Select, etc.)
   - 수식 계산 (Num, Sum, Mul, etc.)

핵심: 제한된 계층 구조 + 타입 안전성
 */