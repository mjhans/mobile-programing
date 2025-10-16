package com.bible.ch04.examples.BasicOOP.Polymorphism

interface IPaymentMethod {
    fun processPayment(amount: Double): String
    fun getMethodName(): String
}