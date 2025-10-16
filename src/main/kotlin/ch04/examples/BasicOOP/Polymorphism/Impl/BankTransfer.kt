package com.bible.ch04.examples.BasicOOP.Polymorphism.Impl

import com.bible.ch04.examples.BasicOOP.Polymorphism.IPaymentMethod

class BankTransfer(private val accountNumber: String) : IPaymentMethod {
    override fun processPayment(amount: Double): String {
        return "계좌이체(${accountNumber})로 ${amount}원 결제 완료"
    }

    override fun getMethodName() = "계좌이체"
}
