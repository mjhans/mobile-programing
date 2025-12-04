package com.bible.ch06.examples.HighFunction.FunctionParameters

/**
 * 실전 예제: 로깅 시스템
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * Nullable 함수 타입을 사용한 실전 로깅 시스템 예제를 학습합니다.
 * 선택적 커스터마이징을 제공하는 방법을 이해합니다.
 */

enum class LogLevel { DEBUG, INFO, WARNING, ERROR }

fun log(
    level: LogLevel,
    message: String,
    formatter: ((LogLevel, String) -> String)? = null
) {
    val formattedMessage = formatter?.invoke(level, message)
        ?: "[$level] $message"  // 기본 포맷

    println(formattedMessage)
}

fun main() {
    println("=".repeat(60))
    println("실전 예제 - 로깅 시스템")
    println("=".repeat(60))

    // 기본 포맷 사용
    log(LogLevel.INFO, "Application started")

    // 커스텀 포맷 사용
    log(LogLevel.ERROR, "Connection failed") { level, msg ->
        "!!! ${level.name}: $msg !!!"
    }

    // 타임스탬프 포함 포맷
    log(LogLevel.DEBUG, "Debug information") { level, msg ->
        "[${System.currentTimeMillis()}] ${level.name}: $msg"
    }

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- Nullable 함수 타입으로 선택적 커스터마이징 제공")
    println("- 기본 동작은 간단하게, 필요시 커스텀 가능")
    println("- 실무에서 자주 사용되는 패턴")
    println("- 유연성과 단순성의 균형")
    println("=".repeat(60))
}
