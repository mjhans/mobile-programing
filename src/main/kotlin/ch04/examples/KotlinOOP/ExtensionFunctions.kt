package com.bible.ch04.examples.KotlinOOP

/*
 * 상속 없이 기존 클래스에 기능 확장
 */

// String 확장 함수
fun String.lastChar(): Char = this[length - 1]

// Product 모델
data class Product(val id: String, val name: String, val price: Double, val category: String)

// List<Product> 확장 함수들
fun List<Product>.getTotalValue(): Double = this.sumOf { it.price }

fun List<Product>.filterByCategory(category: String): List<Product> =
    this.filter { it.category == category }

fun List<Product>.getMostExpensive(): Product? = this.maxByOrNull { it.price }

fun main() {
    println("Extension Functions".repeat(35).take(70))

    // String extension
    println("\nString 확장:")
    println("Kotlin".lastChar())  // n

    // Product extensions
    val products = listOf(
        Product("1", "Laptop", 1000.0, "Electronics"),
        Product("2", "Mouse", 20.0, "Electronics"),
        Product("3", "Desk", 200.0, "Furniture")
    )

    println("\nList<Product> 확장:")
    println("총 가격: ${products.getTotalValue()}")
    println("전자제품: ${products.filterByCategory("Electronics")}")
    println("최고가: ${products.getMostExpensive()}")

//    val orders = listOf( "1", "2", "a")
//    orders.getTotalValue()
}
