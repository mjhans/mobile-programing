package com.bible.ch04.examples.BasicOOP.Abstraction

import com.bible.ch04.examples.BasicOOP.Abstraction.Impl.*
import com.bible.ch04.examples.BasicOOP.Abstraction.Services.*

fun main() {
    println("=" .repeat(70))
    println("Abstraction (추상화) - 본질적 특성만 추출")
    println("=" .repeat(70))

    // ============================================
    // Repository 추상화 예제
    // ============================================
    println("\n[Repository 추상화]")
    println("-".repeat(70))

    val repository = UserRepository()
    val userService = UserService(repository)

    println("\n1. 사용자 생성:")
    println("=".repeat(70))
    val user1 = userService.createUser("김철수", "kim@example.com", 30)
    val user2 = userService.createUser("이영희", "lee@example.com", 25)

    println("\n2. 사용자 조회:")
    println("=".repeat(70))
    val foundUser = userService.getUser(user1.id)
    println("  조회 결과: $foundUser")

    println("\n3. 전체 사용자 조회:")
    println("=".repeat(70))
    val allUsers = userService.getAllUsers()
    println("  전체 사용자 수: ${allUsers.size}")
    allUsers.forEach { println("  - ${it.name} (${it.email})") }

    // ============================================
    // FileStorage 추상화 예제
    // ============================================
    println("\n" + "=".repeat(70))
    println("[FileStorage 추상화]")
    println("-".repeat(70))

    val localStorage: FileStorage = LocalFileStorage()
    val cloudStorage: FileStorage = CloudFileStorage()

    val content = "Hello, World!".toByteArray()

    println("\n1. 로컬 스토리지:")
    val localFileId = localStorage.upload("test.txt", content)

    println("\n2. 클라우드 스토리지 (복잡한 내부 로직):")
    val cloudFileId = cloudStorage.upload("test.txt", content)

    println("\n3. 사용자는 동일한 인터페이스 사용:")
    println("  localStorage.upload() - 간단")
    println("  cloudStorage.upload() - 간단")
    println("  → 내부 복잡도는 숨겨짐")
}
/*
======================================================================
추상화의 장점
======================================================================
✅ 복잡성 숨김:
   - UserService는 DB 연결, SQL, 트랜잭션 등을 몰라도 됨
   - 단순히 repository.findById() 호출
   - 내부에서 복잡한 처리가 일어나지만 외부는 단순

✅ 사용 편의성:
   - "어떻게"보다 "무엇을"에 집중
   - findById(id) - 직관적이고 간단
   - 내부가 JDBC든 Hibernate든 JPA든 상관없음

✅ 구현 교체 용이:
   - LocalFileStorage ↔ CloudFileStorage 쉽게 교체
   - UserService 코드 수정 불필요
   - 추상화된 인터페이스만 유지하면 됨

✅ 테스트 용이:
   - Mock Repository로 쉽게 테스트
   - 실제 DB 없이도 UserService 테스트 가능

✅ 협업 효율:
   - 팀 A: Repository 구현
   - 팀 B: UserService 구현
   - 인터페이스만 합의하면 병렬 개발 가능

======================================================================
핵심: 복잡성은 내부에, 단순함은 외부에
======================================================================
UserRepository 내부:
  ❌ 복잡: DB 연결 풀, SQL 쿼리, 결과 매핑, 트랜잭션...

UserService에서 사용:
  ✅ 단순: repository.findById(id)

이것이 추상화의 핵심!

 */