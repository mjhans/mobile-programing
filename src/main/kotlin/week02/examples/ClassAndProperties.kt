package com.bible.week02.examples

class Person(
    val name: String,       // read-only, getter
    var isStudent: Boolean  // rewritable, getter, setter
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean // 프로퍼티는 값을 저장하지 않음
        get() {           // 커스텀 게터 선언
            return height == width
        }
}

fun main() {
    val person = Person("Bob", true)
    println(person.name)
    // Bob
    println(person.isStudent)
    // true
    person.isStudent = false // Graduation!
    println(person.isStudent)

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare) // false

    val square = Rectangle(10, 10)
    println(square.isSquare)    // true
}
