package com.bible.ch04.examples.BasicOOP.Inheritance

open class Employee (
    val id: String,
    val name: String,
    protected var salary: Double  // protected: 하위 클래스에서 접근 가능
) {
    // 모든 직원 공통 기능 - 한 번만 구현
    fun getAnnualSalary(): Double = salary * 12

    fun getInfo(): String = "$name (ID: $id)"

    open fun calculateBonus(): Double = salary * 0.1

    open fun printDetails() {
        println("  ID: $id")
        println("  이름: $name")
        println("  월급: ${salary}원")
        println("  연봉: ${getAnnualSalary()}원")
        println("  보너스: ${calculateBonus()}원")
    }
}