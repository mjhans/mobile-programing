package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * 실전 예제: 로깅 시스템
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 설정에 따라 다른 로거 함수를 생성하는 실전 예제를 학습합니다.
 * 로그 레벨과 접두사를 캡처하여 맞춤형 로거를 만듭니다.
 */

enum class LogLevel { DEBUG, INFO, WARNING, ERROR }

fun createLogger(level: LogLevel, prefix: String): (String) -> Unit {
    return { message ->
        if (level >= LogLevel.INFO) {  // 최소 레벨 확인
            println("[$prefix] ${level.name}: $message")
        }
    }
}

fun main() {
    println("=".repeat(60))
    println("실전 예제 - 로깅 시스템")
    println("=".repeat(60))

    val userLogger = createLogger(LogLevel.INFO, "USER")
    val systemLogger = createLogger(LogLevel.WARNING, "SYSTEM")

    userLogger("사용자 로그인")     // [USER] INFO: 사용자 로그인
    systemLogger("시스템 경고")    // [SYSTEM] WARNING: 시스템 경고

    // DEBUG 레벨은 출력 안 됨
    val debugLogger = createLogger(LogLevel.DEBUG, "DEBUG")
    debugLogger("디버그 메시지")   // (출력 안 됨)

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 설정에 따라 다른 로거 함수 생성")
    println("- 로그 레벨과 접두사를 클로저로 캡처")
    println("- 재사용 가능한 로깅 함수 생성")
    println("=".repeat(60))
}
