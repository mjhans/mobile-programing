package com.bible.ch05.problem

data class CartItem(
    val productName: String,
    val price: Int,
    val quantity: Int
)

fun main() {
    val cart = listOf(
        CartItem("노트북", 1200000, 1),
        CartItem("마우스", 30000, 2),
        CartItem("키보드", 80000, 1),
        CartItem("모니터", 350000, 1)
    )

    // 할인율 계산 함수
    fun calculateDiscount(price: Int): Double {
        return when {
            price >= 100000 -> 0.9  // 10% 할인
            price >= 50000 -> 0.95  // 5% 할인
            else -> 1.0             // 할인 없음
        }
    }

//    // 각 상품의 할인 적용된 최종 가격 계산
//    val finalPrices = cart.map { item ->
//        val discountRate = calculateDiscount(item.price)
//        val finalPrice = (item.price * discountRate * item.quantity).toInt()
//
//        println("${item.productName}: 원가 ${item.price} × ${item.quantity}개 " +
//                "→ 할인율 ${(1 - discountRate) * 100}% " +
//                "→ 최종가 $finalPrice")
//
//        item.productName to finalPrice
//    }
//
//    // 전체 총액 계산
//    val totalAmount = finalPrices.sumOf { it.second }
//    println("\n총 결제 금액: ${totalAmount}원")

    // 보너스: 람다를 더 간결하게
    val total = cart.sumOf { item ->
        val discount = when {
            item.price >= 100000 -> 0.9
            item.price >= 50000 -> 0.95
            else -> 1.0
        }
        (item.price * discount * item.quantity).toInt()
    }
    println("간결한 방식 총액: ${total}원")
}