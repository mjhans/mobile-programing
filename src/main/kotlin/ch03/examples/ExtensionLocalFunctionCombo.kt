package com.bible.ch03.examples
/**
 * 3.6.2 Extension + Local Function 조합
 * Extension 함수와 Local 함수를 함께 사용하여 더 깔끔한 코드
 */

//class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    // user를 데이터베이스에 저장
    println("Saving user ${user.name} to database")
}

fun main() {
    val user = User(1, "Alice", "789 Pine St")
    saveUser(user)

    // 빈 주소로 테스트
    try {
        val invalidUser = User(2, "Bob", "")
        saveUser(invalidUser)
    } catch (e: IllegalArgumentException) {
        println("Caught exception: ${e.message}")
    }
}