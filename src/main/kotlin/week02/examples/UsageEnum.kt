package com.bible.week02.examples

// 주문 상태를 문자열로 관리
fun processOrder(status: String) {
    when (status) {
        "pending" -> println("주문 대기중")
        "approved" -> println("주문 승인됨")
        "rejected" -> println("주문 거절됨")
    }
}

const val ORDER_PENDING = 1
const val ORDER_APPROVED = 2
const val ORDER_REJECTED = 3

fun processOrderNum(status: Int) {
    when (status) {
        ORDER_PENDING -> println("주문 대기중")
        ORDER_APPROVED -> println("주문 승인됨")
        ORDER_REJECTED -> println("주문 거절됨")
    }
}

// 더 큰 문제: 다른 종류의 상수와 혼동 가능
//const val USER_ADMIN = 1
//const val USER_NORMAL = 2



fun main(){
    // 문제점들: 런타임시점에 발견
    processOrder("pending")   // 정상
    processOrder("Pending")   // 대소문자 다름 - 버그!
    processOrder("pendng")    // 오타 - 버그!
    processOrder("완료")      // 예상치 못한 값 - 버그!
    processOrder("unknown")   // 존재하지 않는 상태 - 버그!

    // 문제점들: 런타임시점에 발견
    processOrderNum(ORDER_PENDING)  // 정상
    processOrderNum(1)              // 숫자 직접 사용 - 의미 불분명
    processOrderNum(999)            // 존재하지 않는 값 - 버그!
    processOrderNum(-1)             // 음수도 가능 - 버그!
    //processOrder(USER_ADMIN)     // 논리적으로 말이 안 되지만 컴파일됨!

}




