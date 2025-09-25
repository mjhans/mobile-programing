package com.bible.week03.examples

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

// 최종 해결책: Extension + Local function 조합
//fun User.validateBeforeSave() {
//    fun validate(value: String, fieldName: String) {
//        if (value.isEmpty()) {
//            throw IllegalArgumentException(
//                "Can't save user $id: empty $fieldName"  // this.id 생략 가능
//            )
//        }
//    }
//
//    validate(name, "Name")      // this.name 생략 가능
//    validate(address, "Address") // this.address 생략 가능
//}
//
//fun saveUser(user: User) {
//    user.validateBeforeSave()
//    // 데이터베이스에 저장
//    println("Saving user: ${user.name}")
//}
//
//fun main() {
//    val user = User(1, "Alice", "123 Main St")
//
//    try {
//        saveUser(user)
//    } catch (e: IllegalArgumentException) {
//        println("Validation failed: ${e.message}")
//    }
//}
