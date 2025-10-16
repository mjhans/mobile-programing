package com.bible.ch04.examples.BasicOOP.Inheritance

class Intern(
    id: String,
    name: String,
    salary: Double,
    val mentor: String  // Intern만의 추가 속성
) : Employee(id, name, salary) {

    override fun calculateBonus(): Double {
        // 인턴은 보너스가 적음
        return salary * 0.05
    }

    override fun printDetails() {
        super.printDetails()
        println("  직급: 인턴")
        println("  멘토: $mentor")
    }

    fun learn(skill: String) {
        println("$name 인턴이 $mentor 멘토에게 $skill 을/를 배웁니다")
    }
}