package com.bible.ch03.examples
/**
 * 3.6.1 Local Functions: 코드 중복 제거
 * 함수 안에서 함수를 정의하여 중복을 제거
 */

class User(val id: Int, val name: String, val address: String)

// 문제: 중복된 검증 로직
fun saveUser_problematic(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    // 데이터베이스에 저장
    println("Saving user: ${user.name}")
}

// 해결책 1: 로컬 함수로 중복 제거
fun saveUser_improved(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // 데이터베이스에 저장
    println("Saving user: ${user.name}")
}

fun main() {
    val user1 = User(1, "Alice", "123 Main St")
    val user2 = User(2, "", "456 Oak Ave")  // 빈 이름

    saveUser_improved(user1)  // 성공

    try {
        saveUser_improved(user2)  // 예외 발생
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}