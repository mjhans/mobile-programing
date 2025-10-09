package com.bible.ch02.practice

//fun getPerformance(hour: Int): String {
//    // TODO: 입력받은 시간(hour)에 따라 적절한 공연 정보를 반환하세요
//    // - 12시 미만: "오전 공연은 준비 중입니다"
//    // - 12-14시: "댄스팀 공연"
//    // - 15-17시: "밴드 공연"
//    // - 18시 이후: "저녁 특별 공연"
//    // - 그 외: "공연이 없는 시간입니다"
//
//    // 힌트: when 표현식과 범위(in) 연산자를 활용하면 깔끔하게 구현할 수 있습니다
//    var infoMsg = ""
//    when {
//        hour < 12 -> infoMsg = "오전 공연은 준비 중입니다"
//        hour in 12..14 -> infoMsg = "댄스팀 공연"
//        hour in 15..17 -> infoMsg = "밴드 공연"
//        hour >= 18 -> infoMsg = "저녁 특별 공연"
//        else -> infoMsg = "잘못된 시간입니다. "
//    }
//    return infoMsg
//}

fun getPerformance(hour: Int): String = when (hour) {
        in 0..11 -> "오전 공연은 준비 중입니다"
        12, 13 -> "댄스팀 공연"
        15, 16 -> "밴드 공연"
        in 18..23 -> "저녁 특별 공연"
        else -> "공연이 없는 시간입니다"
    }

// 테스트 코드
fun main() {
    println(getPerformance(10))  // 오전 공연은 준비 중입니다
    println(getPerformance(13))  // 댄스팀 공연
    println(getPerformance(16))  // 밴드 공연
    println(getPerformance(20))  // 저녁 특별 공연
    println(getPerformance(14))  // 공연이 없는 시간입니다
}