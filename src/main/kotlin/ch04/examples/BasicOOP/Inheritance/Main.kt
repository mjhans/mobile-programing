package com.bible.ch04.examples.BasicOOP.Inheritance

fun main() {
    println("=" .repeat(70))
    println("Inheritance (상속) - 코드 재사용의 메커니즘")
    println("=" .repeat(70))

    // ============================================
    // 다양한 직원 생성
    // ============================================
    println("\n[직원 생성]")
    println("-".repeat(70))

    val manager = Manager("M001", "김팀장", 5000000.0, teamSize = 5)
    val developer1 = Developer(
        "D001", "이개발", 4000000.0,
        programmingLanguages = listOf("Kotlin", "Java", "Python", "JavaScript")
    )
    val developer2 = Developer(
        "D002", "박코딩", 3000000.0,
        programmingLanguages = listOf("Kotlin", "Java")
    )
    val intern = Intern("I001", "최인턴", 2000000.0, mentor = "이개발")

    val employees = listOf(manager, developer1, developer2, intern)

    // ============================================
    // 공통 기능 사용 (상속받은 기능)
    // ============================================
    println("\n[공통 정보 출력]")
    println("-".repeat(70))

    employees.forEach { employee ->
        println("\n${employee.getInfo()}")  // 모든 직원이 getInfo() 사용 가능
        employee.printDetails()
    }

    // ============================================
    // 다형성: 같은 메서드, 다른 결과
    // ============================================
    println("\n" + "=".repeat(70))
    println("[보너스 계산 - 각 직급별로 다른 계산 방식]")
    println("-".repeat(70))

    employees.forEach { employee ->
        val bonus = employee.calculateBonus()
        println("${employee.name}: ${bonus}원")
    }

    // ============================================
    // 각 하위 클래스의 고유 기능
    // ============================================
    println("\n" + "=".repeat(70))
    println("[각 직급의 고유 기능]")
    println("-".repeat(70))

    println("\n[Manager의 고유 기능]")
    manager.holdMeeting()

    println("\n[Developer의 고유 기능]")
    developer1.writeCode("Kotlin")
    developer1.writeCode("Rust")  // 배우지 않은 언어
    developer2.writeCode("Java")

    println("\n[Intern의 고유 기능]")
    intern.learn("Kotlin")
    intern.learn("디자인 패턴")
}
/*
======================================================================
상속의 장점
======================================================================
✅ 코드 재사용:
   - getAnnualSalary(), getInfo() 등 공통 메서드를 한 번만 구현
   - 모든 하위 클래스에서 자동으로 사용 가능

✅ 일관성:
   - 모든 직원이 동일한 기본 구조를 가짐
   - 새로운 직원 타입 추가 시 일관된 인터페이스 보장

✅ 유지보수성:
   - Employee 클래스만 수정하면 모든 하위 클래스에 반영
   - 예: getAnnualSalary() 계산 방식 변경 시 한 곳만 수정

✅ 확장성:
   - 새로운 직원 타입 추가 쉬움
   - Designer, Accountant 등을 쉽게 추가 가능

✅ 개발 속도:
   - 검증된 기능을 재사용하여 빠른 개발
   - 새로운 기능만 집중해서 개발 가능

======================================================================
재사용된 코드량
======================================================================
Employee 클래스의 코드:
  - getAnnualSalary()
  - getInfo()
  - calculateBonus() (기본 구현)
  - printDetails() (기본 구현)

→ Manager, Developer, Intern 모두 이 코드를 재사용
→ 3번 반복 작성하지 않고 1번만 작성
→ 버그 수정이나 개선도 1번만 하면 모든 곳에 반영
 */