package com.bible.ch04.examples.BasicOOP.Classes

fun main() {
    println("=" .repeat(60))
    println("Class (클래스) - 객체의 설계도")
    println("=" .repeat(60))

    // ============================================
    // Car 객체 생성 = 설계도로부터 실제 자동차들 만들기
    // ============================================
    println("\n[Car 예제]")
    println("-".repeat(60))

    // 객체 = 실제 자동차들
    val myCar = Car("현대", "아반떼")
    val yourCar = Car("기아", "K5")
    val sportsCar = Car("포르쉐", "911", 50) // 초기 속도 50km/h

    println("1. 객체 생성:")
    myCar.displayInfo()
    yourCar.displayInfo()
    sportsCar.displayInfo()

    println("\n2. 메서드 호출:")
    myCar.accelerate(30)
    myCar.accelerate(20)
    myCar.displayInfo()

    yourCar.accelerate(60)
    yourCar.displayInfo()

    sportsCar.accelerate(100)
    sportsCar.displayInfo()

    println("\n3. 브레이크:")
    myCar.brake()
    myCar.displayInfo()

    // ============================================
    // Student 예제
    // ============================================
    println("\n" + "=".repeat(60))
    println("[Student 예제]")
    println("-".repeat(60))

    val students = listOf(
        Student("S001", "김철수", 85),
        Student("S002", "이영희", 92),
        Student("S003", "박민수", 78)
    )

    println("1. 초기 상태:")
    students.forEach { it.printReport(); println() }

    println("2. 학생들이 공부합니다:")
    students[0].study(3)  // 김철수: 85 + 3 = 88
    students[1].study(5)  // 이영희: 92 + 5 = 97
    students[2].study(10) // 박민수: 78 + 10 = 88

    println("\n3. 공부 후 상태:")
    students.forEach { it.printReport(); println() }

    /*
    ============================================================
    클래스의 장점
    ============================================================
    1. 모듈화:
       - Car 클래스는 자동차 관련 모든 것을 포함
       - Student 클래스는 학생 관련 모든 것을 포함
       - 독립적으로 개발하고 테스트 가능

    2. 재사용성:
       - 같은 설계도(클래스)로 여러 객체 생성 가능
       - myCar, yourCar, sportsCar 모두 Car 클래스 사용

    3. 유지보수성:
       - Car 클래스만 수정하면 모든 자동차 객체에 반영
       - 데이터(속성)와 기능(메서드)이 함께 관리됨

    4. 현실 세계 모델링:
       - 현실의 개념(자동차, 학생)을 코드로 직관적으로 표현
       - 코드를 이해하기 쉬움
     */
}