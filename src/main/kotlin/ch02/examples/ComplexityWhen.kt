package com.bible.ch02.examples

// 복잡한 조건 처리: 날씨 분석 시스템
fun analyzeWeather(temperature: Int, isRaining: Boolean): String = when {
    temperature < 0 -> "추워요! 두꺼운 옷을 입으세요. ❄️"
    temperature > 30 -> "더워요! 시원한 곳을 찾으세요. 🔥"
    isRaining -> "비가 와요! 우산을 챙기세요. ☔"
    temperature in 20..25 -> "완벽한 날씨예요! 산책하세요. 🌤️"
    else -> "괜찮은 날씨네요."
}

// 사용자 검증 시스템
fun validateUser(name: String, age: Int, email: String): String = when {
    name.isEmpty() -> "❌ 이름을 입력하세요"
    age < 0 -> "❌ 나이가 잘못되었습니다"
    age < 18 -> "⚠️ 미성년자: $name (보호자 동의 필요)"
    !email.contains("@") -> "❌ 올바른 이메일을 입력하세요"
    else -> "✅ 환영합니다, ${name}님!"
}

fun main() {
    // 날씨 분석
    println(analyzeWeather(25, false))  // 완벽한 날씨예요! 산책하세요. 🌤️
    println(analyzeWeather(15, true))   // 비가 와요! 우산을 챙기세요. ☔

    // 사용자 검증
    println(validateUser("철수", 20, "chulsoo@email.com"))  // ✅ 환영합니다, 철수님!
    println(validateUser("", 25, "test@email.com"))        // ❌ 이름을 입력하세요
}