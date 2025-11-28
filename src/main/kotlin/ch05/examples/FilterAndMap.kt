package com.bible.ch05.examples

import com.bible.ch05.examples.sequences.Person

data class Student(val name: String, val score: Int)

fun main() {

    val list = listOf(1, 2, 3, 4)
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    println(list.filter { it % 2 == 0 })
    println(people.filter { it.age > 30 })

    println(list.map { it * it })
    println(list.map { it + 1 })
    println(people.map { it.name })
    println(people.map { Person::name })

    val students = listOf(
        Student("Alice", 92),
        Student("Bob", 85),
        Student("Carol", 95),
        Student("David", 78),
        Student("Fuzz", 95),
        Student("FuzzBizz", 95),
    )
    // Filter
    val excellent = students.filter { it.score >= 90 }
    println("Excellent students: $excellent")

    // Map
    val names = students.map { it.name }
    println("All names: $names")

    // Chaining
    //학생들중 90점이 넘는 학생들의 이름만 추출
    val excellentNames = students
        .filter { it.score >= 90 }
        .map { it.name }
    println("Excellent names: $excellentNames")

    // 가장 높은 점수의 학생을 찾아라
    val maxScoreStudents = students.filter {
        val maxScoreStudent = students.maxBy(Student::score)
        maxScoreStudent.score == it.score
    }
    val maxScore = students.maxByOrNull(Student::score)?.score
    val topStudents = students.filter { it.score == maxScore }

    println("Max score students: $maxScoreStudents")

}