package com.bible.ch04.examples

// ============================================
// 절차지향적 접근
// ============================================

var studentNames = arrayOf("김철수", "이영희", "박민수")
var studentScores = arrayOf(85, 92, 78)
var studentGrades = arrayOf("B", "A", "C")

fun printStudent(index: Int) {
    println("이름: ${studentNames[index]}")
    println("점수: ${studentScores[index]}")
    println("등급: ${studentGrades[index]}")
}

fun calculateAverage(scores: Array<Int>): Double {
    return scores.average()
}

// ============================================
// 객체지향적 접근
// ============================================

class Student(
    val name: String,
    val score: Int,
    val grade: String
) {
    fun printInfo() {
        println("이름: $name")
        println("점수: $score")
        println("등급: $grade")
    }

    fun isPassing(): Boolean = score >= 60
}

class StudentManager(private val students: List<Student>) {
    fun calculateAverage(): Double {
        return students.map { it.score }.average()
    }

    fun getPassingStudents(): List<Student> {
        return students.filter { it.isPassing() }
    }

    fun printAll() {
        students.forEach { it.printInfo() }
    }
}

fun main() {
    println("=" .repeat(50))
    println("절차적 프로그래밍 vs 객체지향 프로그래밍 비교")
    println("=" .repeat(50))

    // ============================================
    // 절차적 방식 실행
    // ============================================
    println("\n[절차적 방식]")
    println("-".repeat(50))
    printStudent(0)
    println()
    println("평균 점수: ${calculateAverage(studentScores)}")

    /*
    문제점:
        - 데이터(studentNames, studentScores, studentGrades)가 분리되어 있음
        - 새로운 학생 추가 시 3개의 배열을 모두 수정해야 함
        - 인덱스 관리가 어렵고 실수하기 쉬움
     */

    // ============================================
    // OOP 방식 실행
    // ============================================
    println("\n" + "=".repeat(50))
    println("[객체지향 방식]")
    println("-".repeat(50))

    val students = listOf(
        Student("김철수", 85, "B"),
        Student("이영희", 92, "A"),
        Student("박민수", 78, "C")
    )

    val manager = StudentManager(students)

    println("첫 번째 학생:")
    students[0].printInfo()
    println()

    println("평균 점수: ${manager.calculateAverage()}")
    println()

    println("합격한 학생들:")
    manager.getPassingStudents().forEach {
        println("  - ${it.name}: ${it.score}점")
    }

    /*
    장점:
        - 데이터와 기능이 하나의 Student 클래스에 결합
        - 새로운 학생 추가가 간단함 (List에 Student 객체 추가)
        - 각 학생이 자신의 정보를 관리
        - 유지보수와 확장이 용이
     */
}
