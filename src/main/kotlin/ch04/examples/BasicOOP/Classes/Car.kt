package com.bible.ch04.examples.BasicOOP.Classes

class Car (
    val brand: String,      // 속성 (Property) - read-only
    val model: String,      // 속성 (Property) - read-only
    var speed: Int = 0      // 속성 (Property) - mutable, default value
) {
    // 행동 (Method/Function)
    fun accelerate(amount: Int) {
        speed += amount
        println("$brand ${model}이 ${speed}km/h로 가속합니다")
    }

    fun brake() {
        speed = 0
        println("$brand ${model}이 정지했습니다")
    }

    fun displayInfo() {
        println("[$brand $model] 현재 속도: ${speed}km/h")
    }
}