package com.bible.ch04.examples.KotlinOOP

/*
 * 클래스 선언의 간결함
 *
 * Kotlin의 Primary Constructor는 Java의 보일러플레이트 코드를 대폭 줄여줍니다.
 *
 * Primary constructor와 property 통합:
 * - 생성자 파라미터와 프로퍼티 선언을 하나로 통합
 * - val: read-only property
 * - var: mutable property
 * - private: 외부 접근 불가
 */

// ============================================
// Kotlin의 간결한 클래스 선언
// ============================================

class Person(val name: String, var age: Int)

// ============================================
// Primary constructor와 property 통합
// ============================================

class Student(
    val id: String,           // read-only property (val)
    var name: String,         // mutable property (var)
    private val ssn: String,  // private property
    var age: Int = 18         // default value
) {
    // init 블록: primary constructor 이후 실행
    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(age >= 0) { "Age cannot be negative" }
        println("Student 객체 생성: $name (ID: $id)")
    }

    // 추가 메서드
    fun printInfo() {
        println("학생 ID: $id")
        println("이름: $name")
        println("나이: $age")
        // println("주민번호: $ssn")  // private이므로 여기서만 접근 가능
    }

    fun celebrateBirthday() {
        age++
        println("$name 학생의 생일입니다! 나이: $age")
    }
}

// ============================================
// init 블록을 활용한 초기화
// ============================================

class BankAccount(
    val accountNumber: String,
    var balance: Double
) {
    // 여러 init 블록 가능 (선언 순서대로 실행)
    init {
        require(balance >= 0) { "초기 잔액은 0 이상이어야 합니다" }
        println("계좌 개설: $accountNumber (초기 잔액: ${balance}원)")
    }

    private val createdAt = System.currentTimeMillis()

    init {
        println("  생성 시각: $createdAt")
    }

    fun deposit(amount: Double) {
        require(amount > 0) { "입금액은 양수여야 합니다" }
        balance += amount
        println("입금: ${amount}원 → 잔액: ${balance}원")
    }
}

// ============================================
// Secondary constructor (부 생성자)
// ============================================

class Rectangle(
    val width: Double,
    val height: Double
) {
    // Primary constructor
    init {
        println("primary 사각형 생성: $width x $height")
    }
    // Secondary constructor는 primary constructor를 호출해야 함
    constructor(side: Double) : this(side, side) {
        println("Secondary 정사각형 생성: $side x $side")
    }

    init {
        println("2번째 init")
    }

    constructor() : this(0.0) {

    }

    constructor(x: Double, y: Double, z: Double) : this() {
        println("3 생성: $x x $y x $z")
    }


    val area: Double
        get() = width * height

    fun printInfo() {
        println("사각형: ${width} x ${height}, 넓이: $area")
    }
}

fun main() {
    println("=".repeat(70))
    println("Kotlin 클래스 선언의 간결함")
    println("=".repeat(70))

    // ============================================
    // Person 예제
    // ============================================
    println("\n[Person - 간결한 클래스]")
    println("-".repeat(70))

    val person = Person("김철수", 30)
    println("이름: ${person.name}")
    println("나이: ${person.age}")

    // val은 read-only
    // person.name = "이영희"  // 컴파일 에러!

    // var는 mutable
    person.age = 31
    println("변경된 나이: ${person.age}")

    // ============================================
    // Student 예제 (init 블록)
    // ============================================
    println("\n[Student - init 블록과 검증]")
    println("-".repeat(70))

    val student1 = Student(
        id = "S001",
        name = "박민수",
        ssn = "123456-1234567",
        age = 20
    )
    student1.printInfo()

    println()
    student1.celebrateBirthday()

    println("\n[기본값 사용]")
    val student2 = Student(
        id = "S002",
        name = "이영희",
        ssn = "234567-2345678"
        // age 생략 → 기본값 18 사용
    )
    student2.printInfo()

    println("\n[검증 실패 예제]")
    try {
        val invalidStudent = Student("S003", "", "111111-1111111", 20)
    } catch (e: IllegalArgumentException) {
        println("❌ 오류: ${e.message}")
    }

    try {
        val invalidStudent = Student("S004", "김철수", "222222-2222222", -5)
    } catch (e: IllegalArgumentException) {
        println("❌ 오류: ${e.message}")
    }

    // ============================================
    // BankAccount 예제 (여러 init 블록)
    // ============================================
    println("\n[BankAccount - 여러 init 블록]")
    println("-".repeat(70))

    val account = BankAccount("110-123-456", 100000.0)
    account.deposit(50000.0)

    // ============================================
    // Rectangle 예제 (Secondary constructor)
    // ============================================
    println("\n[Rectangle - Primary & Secondary Constructor]")
    println("-".repeat(70))

    println("Primary constructor:")
    val rect1 = Rectangle(10.0, 20.0)
    rect1.printInfo()

    println("\nSecondary constructor:")
    val square = Rectangle(15.0)  // secondary constructor 호출
    square.printInfo()

    println("\n3 constructor:")
    val triangle = Rectangle(15.0, 19.0, 0.0)  // secondary constructor 호출
    triangle.printInfo()
}
/*
======================================================================
Java vs Kotlin 클래스 선언 비교
======================================================================
[Kotlin - 간결함]
class Person(val name: String, var age: Int)

[Java - 보일러플레이트]
public class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

Kotlin 장점:
✅ 1줄 vs Java 13줄
✅ getter/setter 자동 생성
✅ 생성자와 프로퍼티를 하나로 통합
✅ 더 읽기 쉽고 유지보수 쉬움

======================================================================
Kotlin 클래스 선언의 장점
======================================================================
✅ 간결함:
   - class Person(val name: String, var age: Int)
   - 한 줄로 클래스 선언 + 프로퍼티 + 생성자

✅ val/var:
   - val: read-only (Java의 final 필드 + getter)
   - var: mutable (Java의 필드 + getter + setter)

✅ 기본값:
   - 생성자 파라미터에 기본값 지정 가능
   - 오버로드 생성자 불필요

✅ init 블록:
   - 초기화 로직을 명확하게 분리
   - 여러 init 블록 가능
   - 검증 로직 구현에 유용

✅ 가시성:
   - private val: 외부 접근 불가
   - val: 외부에서 읽기만 가능
   - var: 외부에서 읽기/쓰기 가능
 */