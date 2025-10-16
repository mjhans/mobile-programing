package com.bible.ch04.examples.BasicOOP.Inheritance

class Developer(
    id: String,
    name: String,
    salary: Double,
    val programmingLanguages: List<String>  // Developer만의 추가 속성
) : Employee(id, name, salary) {
    // Employee의 모든 기능 재사용

    fun getSkillLevel(): String {
        return when (programmingLanguages.size) {
            in 1..2 -> "Junior"
            in 3..5 -> "Mid-level"
            else -> "Senior"
        }
    }

    override fun calculateBonus(): Double {
        // 스킬 레벨에 따라 보너스 차등
        val multiplier = when (getSkillLevel()) {
            "Junior" -> 0.1
            "Mid-level" -> 0.15
            "Senior" -> 0.25
            else -> 0.1
        }
        return salary * multiplier
    }

    override fun printDetails() {
        super.printDetails()
        println("  직급: 개발자")
        println("  스킬 레벨: ${getSkillLevel()}")
        println("  프로그래밍 언어: ${programmingLanguages.joinToString(", ")}")
    }

    fun writeCode(language: String) {
        if (language in programmingLanguages) {
            println("$name 개발자가 $language 코드를 작성합니다")
        } else {
            println("$name 개발자는 $language 를 아직 배우지 않았습니다")
        }
    }
}