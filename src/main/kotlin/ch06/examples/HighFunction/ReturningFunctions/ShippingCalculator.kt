package com.bible.ch06.examples.HighFunction.ReturningFunction

/**
 * 배송비 계산기
 * 출처: Kotlin in Action, Second Edition - Chapter 10
 *
 * 배송 방식에 따라 다른 계산 함수를 반환하는 실용적인 예제를 학습합니다.
 * 조건에 따라 적절한 함수를 선택하여 반환합니다.
 */

/**
 * Listing 10.7: 다른 함수를 반환하는 함수 정의
 */
enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {  // 함수를 반환하는 함수 선언
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }  // 함수에서 람다 반환
    }
    return { order -> 1.2 * order.itemCount }  // 함수에서 람다 반환
}

fun main() {
    println("=".repeat(60))
    println("배송비 계산기")
    println("=".repeat(60))

    val standardCalc = getShippingCostCalculator(Delivery.STANDARD)
    val expeditedCalc = getShippingCostCalculator(Delivery.EXPEDITED)

    val order1 = Order(3)
    val order2 = Order(10)

    println("주문 1 (3개):")
    println("  일반 배송: \$${standardCalc(order1)}")   // 3.6
    println("  빠른 배송: \$${expeditedCalc(order1)}")  // 12.3

    println("\n주문 2 (10개):")
    println("  일반 배송: \$${standardCalc(order2)}")   // 12.0
    println("  빠른 배송: \$${expeditedCalc(order2)}")  // 27.0

    println("\n" + "=".repeat(60))
    println("핵심 포인트:")
    println("=".repeat(60))
    println("- 배송 방식에 따라 다른 계산 함수 반환")
    println("- 반환된 함수를 재사용하여 여러 주문 계산")
    println("- 비즈니스 로직을 함수로 캡슐화")
    println("=".repeat(60))
}
