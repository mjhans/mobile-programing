package com.bible.ch04.examples.KotlinOOP.CompanionObject

/*
 * Companion Object - 클래스 레벨 멤버
 *
 * Companion object는 클래스의 인스턴스 없이 호출할 수 있는 멤버를 정의합니다.
 * Java의 static과 유사하지만, 더 강력한 기능을 제공합니다.
 *
 * 핵심 특징:
 * - 클래스당 하나의 companion object만 가질 수 있음
 * - 인터페이스를 구현할 수 있음 (Java static은 불가능)
 * - 확장 함수를 정의할 수 있음
 * - private 생성자와 함께 사용하여 팩토리 패턴 구현
 *
 * 주요 활용:
 * 1. Factory Method Pattern - 객체 생성 로직 캡슐화
 * 2. Singleton Pattern - object 키워드로 구현
 * 3. Constants - 상수 정의
 * 4. Utility Functions - 클래스 관련 헬퍼 함수
 */

// ============================================
// Factory Method Pattern - 객체 생성 제어
// ============================================
class User private constructor(val id: String, val name: String) {
    companion object {
        // private 필드 - companion object 내부에서만 접근 가능
        private var idCounter = 0

        // Factory method - 검증 로직 포함
        fun create(name: String): User {
            require(name.isNotBlank()) { "Name cannot be blank" }
            return User("user_${++idCounter}", name)
        }

        // JSON 파싱 팩토리 메서드
        fun fromJson(json: String): User {
            // 실제로는 JSON 파싱 로직이 들어감
            val name = json.substringAfter("name:").substringBefore(",").trim()
            return User("json_${++idCounter}", name)
        }

        // 특별한 객체 생성 (테스트용 등)
        fun createGuest(): User {
            return User("guest_${System.currentTimeMillis()}", "Guest")
        }
    }

    override fun toString() = "User(id='$id', name='$name')"
}

// ============================================
// Interface Implementation - Companion이 인터페이스 구현
// ============================================

// 제네릭 팩토리 인터페이스
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person(val name: String, val age: Int) {
    // Companion이 인터페이스를 구현 (Java static으로는 불가능!)
    companion object : JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person {
            // 간단한 JSON 파싱 시뮬레이션
            val name = jsonText.substringAfter("\"name\":\"").substringBefore("\"")
            val age = jsonText.substringAfter("\"age\":").substringBefore("}").trim().toIntOrNull() ?: 0
            return Person(name, age)
        }

        // 추가 팩토리 메서드
        fun createDefault(): Person = Person("Unknown", 0)
    }

    override fun toString() = "Person(name='$name', age=$age)"
}

// ============================================
// Singleton Pattern - object 키워드
// ============================================

object DatabaseConfig {
    // const: 컴파일 타임 상수
    const val URL = "jdbc:mysql://localhost:3306/mydb"
    const val MAX_CONNECTIONS = 10

    // var도 가능 (싱글톤의 상태)
    private var connectionCount = 0

    fun getConnection(): String {
        connectionCount++
        return "Connected to $URL (Total connections: $connectionCount)"
    }

    fun getMaxConnections() = MAX_CONNECTIONS
}

// ============================================
// Constants 관리 - 상수 그룹화
// ============================================

class ApiClient {
    companion object {
        // 상수 정의 - 클래스 관련 상수를 한곳에 모음
        const val BASE_URL = "https://api.example.com"
        const val TIMEOUT_SECONDS = 30L
        const val MAX_RETRIES = 3

        // 비상수 값 (런타임에 초기화)
        val defaultHeaders = mapOf(
            "Content-Type" to "application/json",
            "User-Agent" to "KotlinApp/1.0"
        )

        fun createUrl(endpoint: String) = "$BASE_URL/$endpoint"
    }

    fun fetch(endpoint: String): String {
        return "Fetching from ${ApiClient.createUrl(endpoint)}"
    }
}

// ============================================
// Named Companion - companion에 이름 부여
// ============================================

class Database {
    companion object Factory {  // 이름: Factory
        private var instanceCount = 0

        fun create(name: String): Database {
            instanceCount++
            return Database(name, instanceCount)
        }

        fun getInstanceCount() = instanceCount
    }

    private val name: String
    private val id: Int

    private constructor(name: String, id: Int) {
        this.name = name
        this.id = id
    }

    override fun toString() = "Database(name='$name', id=$id)"
}

// ============================================
// Extension on Companion - companion에 확장 함수
// ============================================

class Product(val name: String, val price: Double) {
    companion object {
        // 기본 팩토리 메서드
        fun create(name: String, price: Double) = Product(name, price)
    }

    override fun toString() = "Product(name='$name', price=$$price)"
}

// Companion에 확장 함수 추가 (다른 파일에서도 가능)
fun Product.Companion.createWithDiscount(name: String, price: Double, discount: Double): Product {
    val finalPrice = price * (1 - discount)
    return Product("$name (할인)", finalPrice)
}

// Companion에 확장 프로퍼티
val Product.Companion.taxRate: Double
    get() = 0.1

// ============================================
// Multiple Interfaces - 여러 인터페이스 구현
// ============================================

interface Serializable {
    fun toJson(): String
}

interface Comparable<T> {
    fun compareTo(other: T): Int
}

class Employee(val id: Int, val name: String, val salary: Double) {
    // Companion이 여러 인터페이스 구현
    companion object : JSONFactory<Employee>, Serializable {
        override fun fromJSON(jsonText: String): Employee {
            val id = jsonText.substringAfter("\"id\":").substringBefore(",").trim().toInt()
            val name = jsonText.substringAfter("\"name\":\"").substringBefore("\"")
            val salary = jsonText.substringAfter("\"salary\":").substringBefore("}").trim().toDouble()
            return Employee(id, name, salary)
        }

        override fun toJson(): String {
            return "{\"type\":\"Employee\",\"version\":\"1.0\"}"
        }

        // 추가 헬퍼 함수
        fun createFromCsv(csv: String): Employee {
            val parts = csv.split(",")
            return Employee(parts[0].toInt(), parts[1], parts[2].toDouble())
        }
    }

    override fun toString() = "Employee(id=$id, name='$name', salary=$$salary)"
}

fun main() {
    println("=".repeat(70))
    println("Companion Object - 클래스 레벨 멤버")
    println("=".repeat(70))

    // ============================================
    // Factory Method Pattern
    // ============================================
    println("\n[Factory Method Pattern - 객체 생성 제어]")
    println("-".repeat(70))

    val user1 = User.create("Alice")
    val user2 = User.create("Bob")
    val user3 = User.fromJson("name: Charlie, age: 30")
    val guest = User.createGuest()

    println("user1: $user1")
    println("user2: $user2")
    println("user3: $user3")
    println("guest: $guest")

    // private 생성자이므로 직접 생성 불가능
    // val user = User("id", "name")  // ❌ 컴파일 에러

    // ============================================
    // Interface Implementation
    // ============================================
    println("\n[Interface Implementation - Companion이 인터페이스 구현]")
    println("-".repeat(70))

    val json = """{"name":"John","age":25}"""
    val person = Person.fromJSON(json)
    println("Parsed: $person")

    val defaultPerson = Person.createDefault()
    println("Default: $defaultPerson")

    // Companion을 인터페이스 타입으로 사용 가능
    val factory: JSONFactory<Person> = Person
    val person2 = factory.fromJSON("""{"name":"Jane","age":30}""")
    println("Via interface: $person2")

    // ============================================
    // Singleton Pattern
    // ============================================
    println("\n[Singleton Pattern - object 키워드]")
    println("-".repeat(70))

    println(DatabaseConfig.getConnection())
    println(DatabaseConfig.getConnection())
    println(DatabaseConfig.getConnection())
    println("Max connections: ${DatabaseConfig.getMaxConnections()}")
    println("URL: ${DatabaseConfig.URL}")

    // ============================================
    // Constants 관리
    // ============================================
    println("\n[Constants 관리 - 상수 그룹화]")
    println("-".repeat(70))

    val client = ApiClient()
    println("Base URL: ${ApiClient.BASE_URL}")
    println("Timeout: ${ApiClient.TIMEOUT_SECONDS}s")
    println("Max Retries: ${ApiClient.MAX_RETRIES}")
    println("Headers: ${ApiClient.defaultHeaders}")
    println(client.fetch("users"))
    println("Full URL: ${ApiClient.createUrl("posts/123")}")

    // ============================================
    // Named Companion
    // ============================================
    println("\n[Named Companion - companion에 이름 부여]")
    println("-".repeat(70))

    val db1 = Database.create("MainDB")
    val db2 = Database.Factory.create("CacheDB")  // 이름으로도 접근 가능
    val db3 = Database.create("LogDB")

    println("db1: $db1")
    println("db2: $db2")
    println("db3: $db3")
    println("Total instances created: ${Database.getInstanceCount()}")

    // ============================================
    // Extension on Companion
    // ============================================
    println("\n[Extension on Companion - companion에 확장 함수]")
    println("-".repeat(70))

    val product1 = Product.create("Laptop", 1000.0)
    val product2 = Product.createWithDiscount("Phone", 800.0, 0.2)  // 20% 할인

    println("product1: $product1")
    println("product2: $product2")
    println("Tax rate: ${Product.taxRate * 100}%")

    // ============================================
    // Multiple Interfaces
    // ============================================
    println("\n[Multiple Interfaces - 여러 인터페이스 구현]")
    println("-".repeat(70))

    val empJson = """{"id":1,"name":"Alice","salary":50000.0}"""
    val employee1 = Employee.fromJSON(empJson)
    println("From JSON: $employee1")

    val employee2 = Employee.createFromCsv("2,Bob,60000.0")
    println("From CSV: $employee2")

    println("Companion metadata: ${Employee.toJson()}")

    // Companion을 여러 인터페이스 타입으로 사용 가능
    val jsonFactory: JSONFactory<Employee> = Employee
    val serializable: Serializable = Employee
    println("JSONFactory type: ${jsonFactory::class.simpleName}")
    println("Serializable type: ${serializable::class.simpleName}")
}

/*
======================================================================
Companion Object 핵심 정리
======================================================================

1. 기본 개념
-----------
- 클래스당 하나의 companion object만 가질 수 있음
- Java의 static과 유사하지만 더 강력함
- 클래스 이름으로 직접 호출 가능: User.create()

2. Java static과의 차이점
-----------------------
┌─────────────────────┬──────────────┬──────────────────┐
│ 기능                │ Java static  │ Companion Object │
├─────────────────────┼──────────────┼──────────────────┤
│ 인터페이스 구현     │ ❌ 불가능    │ ✅ 가능          │
│ 확장 함수           │ ❌ 불가능    │ ✅ 가능          │
│ 상속                │ ❌ 불가능    │ ✅ 가능          │
│ 런타임 다형성       │ ❌ 불가능    │ ✅ 가능          │
│ 이름 부여           │ ❌ 불가능    │ ✅ 가능          │
└─────────────────────┴──────────────┴──────────────────┘

3. 주요 활용 패턴
---------------

📌 Factory Method Pattern
class User private constructor(...) {
    companion object {
        fun create(...) = User(...)
    }
}
→ 객체 생성 로직을 캡슐화
→ 검증 로직 중앙화
→ 생성 방식 다양화 (JSON, CSV 등)

📌 Singleton Pattern
object DatabaseConfig {
    const val URL = "..."
    fun getConnection() = ...
}
→ 전역 상태 관리
→ 리소스 공유

📌 Constants 관리
class ApiClient {
    companion object {
        const val BASE_URL = "..."
        const val TIMEOUT = 30
    }
}
→ 클래스 관련 상수 그룹화
→ 네임스페이스 제공

📌 Interface Implementation
class Person {
    companion object : JSONFactory<Person> {
        override fun fromJSON(...) = ...
    }
}
→ 타입 안전한 팩토리 패턴
→ 전략 패턴 구현

4. 고급 기능
-----------

✅ Named Companion
companion object Factory { }
→ 명시적 이름으로 접근 가능
→ Database.Factory.create()

✅ Extension Functions
fun Product.Companion.createWithDiscount(...) = ...
→ 외부에서 companion 기능 확장
→ 라이브러리 클래스 확장 가능

✅ Multiple Interfaces
companion object : Interface1, Interface2 { }
→ 여러 역할 동시 수행
→ 유연한 설계

5. const vs val
--------------
const val URL = "..."     // 컴파일 타임 상수 (primitive/String만)
val headers = mapOf(...)  // 런타임에 초기화

6. 실전 활용 사례
---------------
🎯 Android
- ViewModel Factory
- Fragment/Activity 생성 팩토리
- Intent Builder

🎯 백엔드
- DTO 변환 (toEntity, fromEntity)
- 설정 관리
- 로깅 유틸

🎯 라이브러리
- Builder 패턴
- DSL 구성
- 타입 안전 API

7. 주의사항
----------
⚠️ Companion은 클래스 로딩 시 초기화됨
   → 무거운 초기화는 lazy { } 사용

⚠️ Private 생성자와 함께 사용
   → 객체 생성을 완전히 제어

⚠️ Object는 싱글톤이지만 companion은 아님
   companion object { } // 이 블록 자체가 싱글톤
   class User { }       // User 인스턴스는 여러 개

8. 패러다임 연결
--------------
🔷 OOP
- Factory Pattern 구현
- Singleton Pattern 구현
- 캡슐화 (private 생성자)

🔷 FP
- 순수 함수형 팩토리
- 불변 객체 생성

🔷 타입 시스템
- 인터페이스 기반 다형성
- 제네릭 활용

======================================================================
핵심: Companion Object = Java static의 강력한 객체지향 버전
      "클래스 레벨의 기능을 객체로 표현"
======================================================================
 */