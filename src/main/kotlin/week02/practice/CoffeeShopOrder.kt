package com.bible.week02.practice

// TODO: 다음 함수들을 완성하세요

// 1. 기본 음료 가격 (자판기 개념 적용)
fun getBasePrice(drink: String): Int {
    // 아메리카노: 3000, 라떼: 4000, 프라푸치노: 5000
    // 기타: 0 (메뉴에 없음)
    return 0
}

// 2. 사이즈별 추가 요금 계산
fun getSizeMultiplier(size: String): Double {
    // Small: 0.8배, Regular: 1.0배, Large: 1.5배
    // 기타: 1.0배 (기본값)
    return 1.0
}

// 3. 최종 주문 정보 생성 (문자열 템플릿 활용)
fun createOrderSummary(customerName: String, drink: String, size: String): String {
    val basePrice = getBasePrice(drink)
    val multiplier = getSizeMultiplier(size)
    val finalPrice = (basePrice * multiplier).toInt()

    // "고객님: [이름], 주문: [사이즈] [음료], 가격: [최종가격]원"
    // 형태로 반환하세요
    return String.format("%.2f", finalPrice)
}

fun main() {
    // 테스트 케이스
    println(createOrderSummary("김철수", "아메리카노", "Large"))
    // 고객님: 김철수, 주문: Large 아메리카노, 가격: 4500원

    println(createOrderSummary("이영희", "라떼", "Small"))
    // 고객님: 이영희, 주문: Small 라떼, 가격: 3200원
}