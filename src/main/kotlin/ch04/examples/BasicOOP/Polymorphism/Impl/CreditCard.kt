package com.bible.ch04.examples.BasicOOP.Polymorphism.Impl

import com.bible.ch04.examples.BasicOOP.Polymorphism.IPaymentMethod

class CreditCard(private val cardNumber: String) : IPaymentMethod {
    override fun processPayment(amount: Double): String {
        return "신용카드(${cardNumber.takeLast(4)})로 ${amount}원 결제 완료"
    }

    override fun getMethodName() = "신용카드"
}