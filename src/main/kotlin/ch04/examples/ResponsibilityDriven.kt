package com.bible.ch04.examples

/**
 * Section 1: OOP의 철학과 방향성
 *
 * 책임 주도 설계 (Responsibility-Driven Design)
 *
 * 진정한 객체지향은 "누가 무엇을 책임질 것인가?"를 고민하는 것입니다.
 *
 * ❌ 절차지향적 사고: "어떻게 할 것인가?"
 * ✅ 객체지향적 사고: "누가 무엇을 책임질 것인가?"
 */

// ============================================
// 데이터 모델
// ============================================

class OrderItem(
    val productId: String,
    val productName: String,
    val quantity: Int,
    val price: Double
) {
    fun isValid(): Boolean = quantity > 0 && price > 0
}

class ShippingInfo(
    val trackingNumber: String,
    val estimatedDelivery: String
)

sealed class PaymentResult {
    class Success(val transactionId: String) : PaymentResult()
    class Failure(val reason: String) : PaymentResult()
}

// ============================================
// 절차지향적 접근 (❌ 나쁜 예)
// ============================================

fun processOrderProcedural(items: List<OrderItem>) {
    // 모든 로직이 한 곳에 집중
    println("[절차적 방식] 주문 처리 시작...")

    // 주문 검증
    println("  1. 주문 검증 중...")
    val allValid = items.all { it.isValid() }
    if (!allValid) {
        println("  ❌ 주문 검증 실패")
        return
    }

    // 재고 확인
    println("  2. 재고 확인 중...")
    // ... 재고 확인 로직

    // 결제 처리
    println("  3. 결제 처리 중...")
    // ... 결제 로직

    // 배송 요청
    println("  4. 배송 요청 중...")
    // ... 배송 로직

    // 이메일 발송
    println("  5. 이메일 발송 중...")
    // ... 이메일 로직

    println("  ✅ 주문 처리 완료\n")
}

// ============================================
// 객체지향적 접근 (✅ 좋은 예)
// ============================================

// 각 객체가 자신의 책임을 담당

class Order(private val items: List<OrderItem>) {
    fun validate(): Boolean {
        println("  [Order] 주문 검증 중...")
        return items.all { it.isValid() }
    }

    fun getTotalAmount(): Double = items.sumOf { it.price * it.quantity }
}

class Inventory {
    fun checkAvailability(items: List<OrderItem>): Boolean {
        println("  [Inventory] 재고 확인 중...")
        // 실제로는 DB 조회 등의 로직
        return true // 간단히 항상 true 반환
    }
}

class PaymentService {
    fun processPayment(order: Order): PaymentResult {
        println("  [PaymentService] 결제 처리 중...")
        val amount = order.getTotalAmount()
        println("    결제 금액: ${amount}원")

        // 실제로는 PG사 연동 등의 로직
        return PaymentResult.Success("TXN-${System.currentTimeMillis()}")
    }
}

class ShippingService {
    fun requestShipping(order: Order): ShippingInfo {
        println("  [ShippingService] 배송 요청 중...")

        // 실제로는 배송사 API 호출 등의 로직
        return ShippingInfo(
            trackingNumber = "TRACK-${System.currentTimeMillis()}",
            estimatedDelivery = "2025-01-15"
        )
    }
}

class NotificationService {
    fun sendOrderConfirmation(order: Order, shippingInfo: ShippingInfo) {
        println("  [NotificationService] 이메일 발송 중...")
        println("    운송장 번호: ${shippingInfo.trackingNumber}")
        println("    예상 배송일: ${shippingInfo.estimatedDelivery}")
    }
}

// 각 서비스를 조율하는 조정자
class OrderProcessor(
    private val inventory: Inventory,
    private val paymentService: PaymentService,
    private val shippingService: ShippingService,
    private val notificationService: NotificationService
) {
    fun processOrder(order: Order) {
        println("[객체지향 방식] 주문 처리 시작...")

        // 1. 주문 검증
        if (!order.validate()) {
            println("  ❌ 주문 검증 실패")
            return
        }

        // 2. 재고 확인 (Inventory가 책임)
        if (!inventory.checkAvailability(emptyList())) {
            println("  ❌ 재고 부족")
            return
        }

        // 3. 결제 처리 (PaymentService가 책임)
        when (val result = paymentService.processPayment(order)) {
            is PaymentResult.Success -> {
                println("    ✅ 결제 성공: ${result.transactionId}")
            }
            is PaymentResult.Failure -> {
                println("    ❌ 결제 실패: ${result.reason}")
                return
            }
        }

        // 4. 배송 요청 (ShippingService가 책임)
        val shippingInfo = shippingService.requestShipping(order)

        // 5. 이메일 발송 (NotificationService가 책임)
        notificationService.sendOrderConfirmation(order, shippingInfo)

        println("  ✅ 주문 처리 완료\n")
    }
}

fun main() {
    println("=" .repeat(60))
    println("책임 주도 설계 (Responsibility-Driven Design)")
    println("=" .repeat(60))

    val items = listOf(
        OrderItem("P001", "노트북", 1, 1200000.0),
        OrderItem("P002", "마우스", 2, 25000.0)
    )

    // ============================================
    // 절차적 방식
    // ============================================
    println("\n❌ 절차지향적 사고: \"어떻게 할 것인가?\"")
    println("-".repeat(60))
    processOrderProcedural(items)

    // ============================================
    // 객체지향 방식
    // ============================================
    println("\n" + "=".repeat(60))
    println("✅ 객체지향적 사고: \"누가 무엇을 책임질 것인가?\"")
    println("-".repeat(60))

    val order = Order(items)
    val processor = OrderProcessor(
        inventory = Inventory(),
        paymentService = PaymentService(),
        shippingService = ShippingService(),
        notificationService = NotificationService()
    )

    processor.processOrder(order)

    /*
    ============================================================
    핵심 차이점
    ============================================================
    절차적:
      - 하나의 함수가 모든 책임을 가짐
      - 변경 시 영향 범위가 넓음
      - 테스트하기 어려움

    객체지향:
      - Order: 주문 검증 책임
      - Inventory: 재고 관리 책임
      - PaymentService: 결제 처리 책임
      - ShippingService: 배송 요청 책임
      - NotificationService: 알림 발송 책임
      - OrderProcessor: 각 서비스 조율 책임

      → 각 객체가 명확한 책임을 가지고 협력
      → 변경 시 해당 책임을 가진 객체만 수정
      → 테스트하기 쉬움 (각 객체를 독립적으로 테스트)
     */
}
