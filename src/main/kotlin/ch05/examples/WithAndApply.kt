package com.bible.ch05.examples

/*
회원 가입 화면에서 User 정보를 입력받아
•	객체를 초기화하고 (→ apply 사용)
•	화면에 표시할 메시지를 만들고 (→ with 사용)
•	로그 파일에 기록
 */
data class User(
    var name: String = "",
    var email: String = "",
    var age: Int = 0
)

fun createUserFromForm(formData: Map<String, Any>): User {
    // apply → 객체 초기화에 적합
    return User().apply {
        name = formData["name"] as String
        email = formData["email"] as String
        age = formData["age"] as Int
    }
}

fun generateUserSummary(user: User): String {
    //with → 객체를 이용해 결과 생성
    return with(user) {
        """
            사용자 정보
        이름: $name
        이메일: $email
        나이: $age
        """.trimIndent()
    }
}

fun logUser(user: User) {
    println("[LOG] ${user.name} (${user.age}) registered successfully.")
}

fun main() {
    val formData = mapOf(
        "name" to "Alice",
        "email" to "alice@kotlin.dev",
        "age" to 27
    )

    // 1️⃣ apply로 User 객체 구성
    val user = createUserFromForm(formData)

    // 2️⃣ with으로 User를 이용해 메시지 생성
    val summary = generateUserSummary(user)

    // 3️⃣ 결과 출력 및 로그
    println(summary)
    logUser(user)
}