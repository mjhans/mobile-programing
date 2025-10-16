package com.bible.ch04.examples.BasicOOP.Inheritance

class Manager(
    id: String,
    name: String,
    salary: Double,
    val teamSize: Int  // Manager만의 추가 속성
) : Employee(id, name, salary) {
    // 기본 기능은 모두 상속받음
    // 추가 기능만 구현

    override fun calculateBonus(): Double {
        // 팀 크기에 따라 보너스 증가
        return salary * 0.2 * (1 + teamSize * 0.01)
    }

    override fun printDetails() {
        super.printDetails()  // 부모의 printDetails 호출
        println("  직급: 매니저")
        println("  팀 크기: ${teamSize}명")
    }

    fun holdMeeting() {
        println("$name 매니저가 팀 미팅을 진행합니다 (${teamSize}명 참석)")
    }
}