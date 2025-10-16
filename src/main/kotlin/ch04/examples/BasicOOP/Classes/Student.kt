package com.bible.ch04.examples.BasicOOP.Classes

class Student (
    val id: String,
    var name: String,
    var grade: Int
) {
    // 계산된 프로퍼티 (computed property)
    val isExcellent: Boolean
        get() = grade >= 90

    fun study(hours: Int) {
        println("$name 학생이 ${hours}시간 공부했습니다")
        // 공부 시간에 따라 성적 향상
        grade = (grade + hours).coerceAtMost(100)
    }

    fun printReport() {
        println("학생 ID: $id")
        println("이름: $name")
        println("성적: $grade 점")
        println("우수 학생: ${if (isExcellent) "예" else "아니오"}")
    }
}