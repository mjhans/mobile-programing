package com.bible.ch04.examples.KotlinOOP.DataClasses.Models

data class Order(
    val orderId: String,
    val client: Client,
    val products: List<Product>,
    val totalAmount: Double
)
