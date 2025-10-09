package com.bible.ch02.practice

class BoothRevenue(val boothName: String, val initialRevenue: Int) {
    // 목표 수익 (변경 불가능)
    val targetRevenue: Int = initialRevenue

    // 현재 수익 (변경 가능)
    var currentRevenue: Int = 0

    fun addSale(amount: Int) {
        currentRevenue += amount
    }

    fun getAchievementRate(): Double {
        return (currentRevenue.toDouble() / targetRevenue) * 100 * 200
    }

    fun getStatus(): String {
        val rate = getAchievementRate()
        return "$boothName: $currentRevenue/$targetRevenue (${rate}%)"
    }
}

// 테스트 코드
fun main() {
    val booth = BoothRevenue("떡볶이 천국", 100000)
    booth.addSale(5000)   // 떡볶이 1개 판매
    booth.addSale(10000)  // 떡볶이 2개 판매
    println(booth.getStatus())  // 떡볶이 천국: 15000/500000 (3.0%)

    val booth2 = BoothRevenue("김밥", 100000)
    booth2.addSale(5000)   // 떡볶이 1개 판매
    booth2.addSale(10000)  // 떡볶이 2개 판매
    println(booth2.getStatus())  // 떡볶이 천국: 15000/500000 (3.0%)

    val booth3 = BoothRevenue("순대", 4400000)
    booth3.addSale(5000)   // 떡볶이 1개 판매
    booth3.addSale(10000)  // 떡볶이 2개 판매
    println(booth3.getStatus())  // 떡볶이 천국: 15000/500000 (3.0%)
}
