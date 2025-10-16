package com.bible.ch04.examples.KotlinOOP.DataClasses

import com.bible.ch04.examples.KotlinOOP.DataClasses.Models.*

fun main() {
    println("=" .repeat(70))
    println("Data Class")
    println("=" .repeat(70))

    // ============================================
    // toString() 자동 생성
    // ============================================
    println("\n[toString() 자동 생성]")
    println("-".repeat(70))

    val lee = Client("이지영", 4122)
    println("Data class: $lee")
    // Client(name=이지영, postalCode=4122)

    val regular = RegularClient("이지영", 4122)
    println("Regular class: $regular")
    // RegularClient@해시코드 (의미 없음)

    // ============================================
    // equals() 구조적 동등성
    // ============================================
    println("\n[equals() 구조적 동등성]")
    println("-".repeat(70))

    val lee2 = Client("이지영", 4122)
    println("lee == lee2: ${lee == lee2}")  // true
    println("lee === lee2: ${lee === lee2}") // false (참조는 다름)

    val regular2 = RegularClient("이지영", 4122)
    println("regular == regular2: ${regular == regular2}")  // false

    // ============================================
    // copy() 메서드로 불변 객체 패턴
    // ============================================
    println("\n[copy() 메서드 - 불변 객체 패턴]")
    println("-".repeat(70))

    val movedLee = lee.copy(postalCode = 4000)
    println("원본: $lee")
    println("복사본: $movedLee")

    val user = User("U001", "john_doe", "john@example.com", 30)
    println("\n원본 사용자: $user")

    // 일부만 변경한 복사본 생성
    val olderUser = user.copy(age = 31)
    println("나이만 변경: $olderUser")

    val renamedUser = user.copy(username = "john_smith")
    println("이름만 변경: $renamedUser")

    // ============================================
    // Destructuring declarations (구조 분해)
    // ============================================
    println("\n[Destructuring Declarations]")
    println("-".repeat(70))

    val (name, address) = lee
    println("이름: $name")
    println("우편번호: $address")

    val (id, username, email, age) = user
    println("ID: $id, 이름: $username, 이메일: $email, 나이: $age")

    // 일부만 사용
    val (productId, productName) = Product("P001", "노트북", 1500000.0, "전자제품")
    println("상품 ID: $productId, 상품명: $productName")

    // ============================================
    // hashCode() 자동 생성 (컬렉션에서 유용)
    // ============================================
    println("\n[hashCode() - 컬렉션에서 활용]")
    println("-".repeat(70))

    val clients = setOf(
        Client("김철수", 1000),
        Client("이영희", 2000),
        Client("김철수", 1000)  // 중복
    )
    println("Set 크기: ${clients.size}") // 2 (중복 제거됨)
    println("클라이언트: $clients")

    val clientMap = mapOf(
        Client("김철수", 1000) to "주문1",
        Client("이영희", 2000) to "주문2"
    )
    val order = clientMap[Client("김철수", 1000)]
    println("주문 조회: $order")

    // ============================================
    // 복잡한 데이터 구조
    // ============================================
    println("\n[복잡한 데이터 구조]")
    println("-".repeat(70))

    val products = listOf(
        Product("P001", "노트북", 1500000.0, "전자제품"),
        Product("P002", "마우스", 30000.0, "전자제품")
    )

    val order1 = Order(
        orderId = "ORD001",
        client = lee,
        products = products,
        totalAmount = products.sumOf { it.price }
    )

    println(order1)

    // copy로 주문 복사 (다른 고객으로)
    val order2 = order1.copy(
        orderId = "ORD002",
        client = Client("박민수", 3000)
    )
    println("\n복사된 주문:")
    println(order2)
}

/*
======================================================================
Data Class의 장점
======================================================================
✅ 자동 생성 메서드:
   - equals(): 구조적 동등성 비교
   - hashCode(): 컬렉션(Set, Map)에서 사용
   - toString(): 읽기 쉬운 문자열 표현
   - copy(): 불변 객체 패턴 구현
   - componentN(): 구조 분해 선언

✅ 간결함:
   - data class Client(val name: String, val postalCode: Int)
   - Java로 작성하면 수십 줄

✅ 불변성:
   - val 프로퍼티 사용
   - copy()로 변경된 복사본 생성
   - 스레드 안전성 향상

✅ 활용 시점:
   - 데이터를 담는 간단한 클래스
   - DTO (Data Transfer Object)
   - Value Object
   - API 응답 모델

❌ 일반 클래스:
   - toString(): 의미 없는 해시코드
   - equals(): 참조 비교만 가능
   - copy(), componentN() 없음
 */