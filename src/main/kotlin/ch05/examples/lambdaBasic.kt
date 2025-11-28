package com.bible.ch05.examples

import com.bible.ch05.examples.sequences.Person

/**
 * Week 5 Code Examples: Lambda Basics
 *
 * 이 파일은 Lambda 표현식의 기본 개념을 실행 가능한 예제로 보여줍니다.
 */



fun main() {
    println("=== Lambda 기본 문법 ===")
    lambdaSyntax()

    println("\n=== Lambda와 컬렉션 ===")
    lambdaWithCollections()

    println("\n=== Member References ===")
    memberReferences()

    println("\n=== 변수 캡처링 ===")
    variableCapture()
}

fun lambdaSyntax() {
    // 1. 기본 Lambda 표현식
    val sum = {
        x: Int, y: Int -> x + y
    }
    fun sun_fun(x: Int, y: Int):Int {
        return (x + y)
    }
    println("sum(3, 5) = ${sum(3, 5)}")
    println("${sun_fun(3, 5)}")

    // 2. 여러 문장을 포함하는 Lambda
    val sumWithLog = { x: Int, y: Int ->
        println("  Computing sum of $x and $y...")
        x + y  // 마지막 표현식이 반환값
    }
    println("sumWithLog(3, 5) = ${sumWithLog(3, 5)}")

    // 3. 직접 호출 (비추천)
    println("Direct call: ${{ println("Hello"); 42 }()}")

    // 4. run 사용 (권장)
    val result = run {
        println("  Inside run block")
        42
    }
    println("run result: $result")
}

fun lambdaWithCollections() {
    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Carol", 27),
        Person("Dol", 31)
    )
//    var maxAge = 0
//    var maxPerson: Person = null
//    for (p in people) {
//        if (p.age > maxAge) {
//            maxAge = p.age
//            maxPerson = p
//        }
//    }

//    println(maxPerson)
//    for (p in people) {
//        if (p.age == maxAge) {
//            println(p.name)
//        }
//    }

    val maxPerson = people.maxBy({p: Person -> p.age})
    print(people.filter({it.age == maxPerson.age}))


    // maxByOrNull 간소화 과정
    println("1. 완전한 형태:")
    println("   ${people.maxByOrNull({ p: Person -> p.age })}")

    println("2. 괄호 밖으로:")
    println("   ${people.maxByOrNull() { p: Person -> p.age }}")

    println("3. 빈 괄호 제거:")
    println("   ${people.maxByOrNull { p: Person -> p.age }}")

    println("4. 타입 추론:")
    println("   ${people.maxByOrNull { it: Person -> it.age }}")

    println("5. it 사용:")
    println("   ${people.maxByOrNull { it.age }}")
    people.maxBy{ it.age }

}

fun memberReferences() {
    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31)
    )

    // Property reference
    println("Property reference:")
    println("  ${people.maxByOrNull(Person::age)}")
    println("  ${people.maxByOrNull({p: Person -> p.age })}")
    println("  ${people.maxByOrNull {it.age}}")

    // Function reference
    fun salute() = "Salute!"
//    fun salute(): String {
//        return "Salute!"
//    }

    println("\nFunction reference:")
    println("  ${run(::salute)}")

    // Constructor reference
    val createPerson = ::Person
    val person = createPerson("Charlie", 25)
    println("\nConstructor reference:")
    println("  $person")

    // Extension function reference
    fun Person.isAdult() = age >= 20
    val predicate = Person::isAdult
    println("\nExtension function reference:")
    println("  Alice is adult: ${predicate(people[0])}")
    people.forEach { predicate(it)  }

    // Bound callable reference
    val alice = people[0]
    val aliceAge = alice::age
    println("\nBound reference:")
    println("  Alice's age function: ${aliceAge()}")

    //일반 member reference와 차이점
    val seb = Person("Sebastian", 26)

    val personsAgeFunction = Person::age
    println(personsAgeFunction(seb)) // 26 (객체를 인자로)

    val sebsAgeFunction = seb::age
    println(sebsAgeFunction()) // 26 (인자 없음)
}

fun variableCapture() {
    val prefix = "Person: "

    // 변수 캡처
    val people = mutableListOf<Person>(
        Person("Alice", 29), Person("Bob", 31)
    )

    people.forEach {
        println("$prefix${it.name}")
    }
    printMessagesWithPrefix(people, prefix = "##prefix!?")
    // 가변 변수 캡처
    var count = 0
    people.forEach {
        count++
    }
    println("Total count: $count")

    people.add(Person("Chalie", 50))
    // 여러 가변 변수 캡처
    var youngCount = 0
    var oldCount = 0
    people.forEach {
        if (it.age < 30) youngCount++ else oldCount++
    }
    println("Young: $youngCount, Old: $oldCount")

    printProblemCounts(people)
}

fun printMessagesWithPrefix(
    messages: List<Person>,
    prefix: String
) {
    messages.forEach { p: Person ->
        println("$prefix $p")
    }
}

fun printProblemCounts(responses: List<Person>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.age > 10) {
            clientErrors++
        } else if (it.age < 20) {
            serverErrors++
        }
    }

    println("$clientErrors client errors, $serverErrors server errors")
}
