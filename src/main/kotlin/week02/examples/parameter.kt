package com.bible.week02.examples

fun greetWithDefault(
    name: String = "Guest",
    greeting: String = "안녕하세요"
) {
    println("$greeting, ${name}님!")
}

fun createUser(
    name: String,
    email: String,
    admin: Boolean = false
) {
    greetWithDefault(name = name)     // 재사용
    println("email: $email, admin: $admin")
}

fun main(){
    greetWithDefault()
    createUser(
        name = "Alice",
        email = "Alice@example.com")
}