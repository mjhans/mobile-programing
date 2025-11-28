package com.bible.ch05.problem

data class Employee(
    val name: String,
    val department: String,
    val salary: Int
)

fun main() {
    val employees = listOf(
        Employee("김철수", "개발팀", 5000),
        Employee("이영희", "개발팀", 5500),
        Employee("박민수", "디자인팀", 4500),
        Employee("정수진", "개발팀", 6000),
        Employee("최지훈", "마케팅팀", 4000)
    )

    // 1. "개발팀" 직원 필터링
    val devEmployees = employees.filter { it.department == "개발팀" }
    println("개발팀 직원: $devEmployees")

    // 2. 개발팀 직원 이름만 추출
    val devNames = devEmployees.map { it.name }
    // 또는 체이닝: employees.filter { it.department == "개발팀" }.map { it.name }
    println("개발팀 직원 이름: $devNames")

    // 3. 개발팀 총 급여
    val totalSalary = devEmployees.sumOf { it.salary }
    println("개발팀 총 급여: $totalSalary")

    // 4. 개발팀 평균 급여
    val avgSalary = devEmployees.map { it.salary }.average()
    // 또는: devEmployees.sumOf { it.salary } / devEmployees.size.toDouble()
    println("개발팀 평균 급여: $avgSalary")

    // 보너스: 한 번에 체이닝
    val result = employees
        .filter { it.department == "개발팀" }
        .also { println("필터링된 직원 수: ${it.size}") }
        .map { it.name to it.salary }
    println("이름-급여 쌍: $result")
}